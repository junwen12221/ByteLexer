package lightfish.byteLexer;


/**
 * Created by jamie on 2017/8/16.
 */
public class P {
    public boolean hasMore;
    public byte[] reader;
    public int start = 0;
    public int size;
    public int x = 0;
    public long t;

    /**
     * todo 性能优化
     *非标识符部分
     * @param b
     * @return
     */
    static boolean isSeparator(byte b) {
        return (!Character.isLetter(b) && !Character.isDigit(b) && b != '_');
    }

    /**
     * 分模块
     * 后缀符号解析有问题
     *
     * @return
     */

    public long getTokenType() {
        return t;
    }

    public void init(byte[] r, int index) {
        hasMore = true;
        reader = r;
        size = r.length - 1;
        x = index;
        t = 0;
    }

    /**
     * 把标识符变成字符串
     * @return
     */
    public String readString() {
        return new String(this.reader, start, x - start);
    }

    /**
     *todo 性能优化
     * @return
     */
    public int readInt() {
        return Integer.parseInt(new String(this.reader, start, x - start));
    }

    /**
     * todo 性能优化
     * @return
     */
    public double readDouble() {
        return Double.parseDouble(new String(this.reader, start, x - start));
    }

    /**
     * 向前读一个字符
     * @param x
     * @return
     */
    public int cc(int x) {
        return (int) this.reader[++this.x];
    }

    final boolean nextIsBlank() {
        return (reader[++x] == ' ' || reader[x] == '\t' || reader[x] == '\r' || reader[x] == '\n');
    }

    /**
     * 是否空白字符
     * @param b
     * @return
     */
    final  boolean isBlank(int b) {
        return (b == ' ' || b == '\t' || b == '\r' || b == '\n')||x<size;
    }

    /**
     * 离开暴力匹配部分,检查接着的字符是非标识符还是标识符
     */
    public final void endId() {
        byte c;
        c = reader[x];
        char t = (char) c;
        //优先处理符号
        if (isSeparator(c)) {
            return;
        } else {
            id();
        }
        if (x == size) {
            hasMore = false;
        }
    }

    /**
     * 是否标识符
     * @param c
     * @return
     */
    public boolean isId(int c) {
        return ('A' <= c && c <= 'Z') || ('a' <= c && c <= 'z') || ('0' <= c && c <= '9') || (c == '_');
    }

    /**
     * 处理标识符,字符串,整型,浮点数,以及单个符号
     */
    final void id() {
        char c = (char) reader[x];
        if (isId(c)) {
            if (Character.isDigit(reader[start])) {
                while (x < size) {
                    c = (char) reader[x];
                    if (Character.isDigit(c) || c == '.') {
                        ++x;
                    } else {
                        break;
                    }
                }
                t = H.IDENTIFIED;
            } else {
                while (x < size) {
                    c = (char) reader[x];
                    if (isId(c)) {
                        ++x;
                    } else {
                        break;
                    }
                }
                t = H.IDENTIFIED;
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
            t = H.IDENTIFIED;
        } else if (c == '\'') {
            while (x < size) {
                ++x;
                c = (char) reader[x];
                if ((c == '\'')) {
                    break;
                }
            }
            ++x;
            t = H.IDENTIFIED;
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
            t = H.IDENTIFIED;
        } else if (c == '-') {

            ++x;
            t = H.IDENTIFIED;
        } else {
            ++x;
            t = H.IDENTIFIED;
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
