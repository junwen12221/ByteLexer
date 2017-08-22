package lightfish.byteLexer;


/**
 * Created by jamie on 2017/8/16.
 */
public abstract class P {
    public boolean hasMore;
    public byte[] reader;
    public int start = 0;
    public int size;
    public int x = 0;
    public int t;
    private final byte ICMask = (byte) 0xDF;//ignore case mask;
    public abstract int parse();
    /**
     * todo 性能优化
     * 非标识符部分
     *
     * @param b
     * @return
     */
    boolean isSeparator(int b) {
        return (!isId(b) && !isDigit(b) && b != '_');
    }

    /**
     * 分模块
     * 后缀符号解析有问题
     *
     * @return
     */

    public int getTokenType() {
        return t;
    }

    public void init(byte[] r, int index) {
        hasMore = true;
        reader = r;
        size = r.length - 1;
        x = index;
        t = H.ID_TOKEN;
    }

    /**
     * 把标识符变成字符串
     *
     * @return
     */
    public String readString() {
        return new String(this.reader, start, x - start);
    }

    /**
     * todo 性能优化
     *
     * @return
     */
    public int readInt() {
        return Integer.parseInt(new String(this.reader, start, x - start));
    }

    /**
     * todo 性能优化
     *
     * @return
     */
    public double readDouble() {
        return Double.parseDouble(new String(this.reader, start, x - start));
    }

    /**
     * 向前读一个字符
     *
     * @param
     * @return
     */
    public int cc() {
        return (int) (this.reader[++this.x]);
    }

    /**
     * 依赖jit优化
     * @param
     * @return
     */
//    public boolean cc(int h) {
//        if (x<size){
//            int c=this.reader[++this.x];
//            if (isDigit(h)) {//编译时确定,避免ICMask影响
//                return c == (h);
//            } else {
//                if (h == (ICMask & c)) {
//                    return true;
//                }else {
//                    endId(c);
//                    return false;
//                }
//            }
//        }else {
//            return false;
//        }
//    }

    final boolean nextIsBlank() {
        return (reader[++x] == ' ' || reader[x] == '\t' || reader[x] == '\r' || reader[x] == '\n');
    }

    /**
     * 是否空白字符
     *
     * @param b
     * @return
     */
    final boolean isBlank(int b) {
        return (b == ' ' || b == '\t' || b == '\r' || b == '\n') || x < size;
    }

    /**
     * 离开暴力匹配部分,检查接着的字符是非标识符还是标识符
     */
    public final void endId(int c) {
        char t = (char) c;
        //优先处理符号
        if (isSeparator(c)) {
            return;
        } else {
            id(c);
        }
        if (x == size) {
            hasMore = false;
        }
    }

    public final void endId() {
        endId(reader[x]);
    }

    public final int endBlank(int H) {
        int c;
        if (x < size) {
            c = cc();
            if (isBlank(c)) {
                t = H;
                return x;
            } else {
                endId(c);
                return x;
            }
        } else {
            return x;
        }
    }

    /**
     * 是否标识符
     *
     * @param c
     * @return
     */
    public boolean isId(int c) {
        return ('A' <= c && c <= 'Z') || ('a' <= c && c <= 'z') || ('0' <= c && c <= '9') || (c == '_');
    }

    public boolean isDigit(int c) {
        return ('0' <= c && c <= '9');
    }

    /**
     * 处理标识符,字符串,整型,浮点数,以及单个符号
     */
    final void id() {
        id(reader[x]);
    }

    final void id(int c) {
        if (isId(c)) {
            if (isDigit(reader[start])) {
                boolean isDouble=false;
                while (x < size) {
                    c = (char) reader[x];
                    if (isDigit(c) ||(isDouble= (c == '.'))) {
                        ++x;
                    } else {
                        break;
                    }
                }
                if (isDouble){
                    t = H.DOUBLE_TOKEN;
                }else{
                    t = H.INT_TOKEN;
                }
            } else {
                while (x < size) {
                    c = (char) reader[x];
                    if (isId(c)) {
                        ++x;
                    } else {
                        break;
                    }
                }
                t = H.ID_TOKEN;
            }
        } else if (c == '`') {
            while (x < size) {
                ++x;
                c = (char) reader[x];
                if ((c == '`')) {
                    break;
                }
            }
            ++x;
            t = H.ID_TOKEN;
        } else if (c == '\'') {
            while (x < size) {
                ++x;
                c = (char) reader[x];
                if ((c == '\'')) {
                    break;
                }
            }
            ++x;
            t = H.ID_TOKEN;
        } else if (c == '"') {
            if (x == 0) {
                ++x;
            }//避免x-1越界
            while (x < size) {
                c = (char) reader[x];
                if ((c == '"' && (reader[x - 1] != '\\'))) {
                    break;
                }
                ++x;
            }
            ++x;
            t = H.STRING_TOKEN;
        } else if (c == '-') {
            ++x;
            t = H.MINUS;
        } else {
            ++x;
            t = H.ID_TOKEN;
        }
    }


    public void findNextToken() {
        if (x + 1 >= size) {
            hasMore = false;
            return;
        } else {
            ++x;
            int c = reader[x];
            if (c == ' ' || c == '\t' || c == '\n') {
                for (; x < size; x++) {
                    c = reader[x];
                    if (c == ' ' || c == '\t' || c == '\n') {
                        continue;
                    }
                }
            } else {
                return;
            }
        }

    }

    /**
     * 跳过注释和空白字符
     */
    public void jumpPassSpace() {
        while (hasMore = x < size) {
            int c = reader[x];
            switch (c) {
                case '-': {
                    int x1 = x + 1;
                    c = (char) reader[x + 1];
                    if (c == '-') {
                        for (x = x1 + 1; x < size && reader[x] != '\n'; x++) {
                        }
                        continue;
                    } else {
                        return;
                    }
                }
                case ' ':
                case '\t':
                case '\n':
                    ++x;
                    continue;
                case '/': {
                    int x1 = x + 1;
                    c = reader[x1];
                    if (c == '*') {
                        for (x = x1 + 1; x < size && reader[x] != '*' && reader[x + 1] != '/'; x++) {
                        }
                        x += 2;
                        continue;
                    } else {
                        return;
                    }
                }
                default:
                    return;
            }
        }
    }
}
