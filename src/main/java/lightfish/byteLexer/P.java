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
     *
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
        size = r.length;
        x = index;
        t = 0;
    }


    public String readString() {
        return new String(this.reader, start, x - start);
    }

    public int cc(int x) {
        return (int) this.reader[++this.x];
    }

    final boolean nextIsBlank() {
        return (reader[++x] == ' ' || reader[x] == '\t' || reader[x] == '\r' || reader[x] == '\n');
    }

    //    final static boolean isBlank(int b) {
//        return (b== ' ' || b== '\t' || b== '\r' || b== '\n');
//    }
//    final static boolean isBlank(byte b) {
//        return (b== ' ' || b== '\t' || b== '\r' || b== '\n');
//    }
    final static boolean isBlank(int b) {
        return (b == ' ' || b == '\t' || b == '\r' || b == '\n');
    }
//    final boolean is(int c) {
//        boolean res = reader[x++] == c;
//        return res;
//    }


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

    public boolean isId(int c) {
        return ('A' <= c && c <= 'Z') || ('a' <= c && c <= 'z') || ('0' <= c && c <= '9') || (c == '_');
    }

    final void id() {
        char c = (char) reader[x];
        if (isId(c)) {
            while (x < size) {
                c = (char) reader[x];
                if (isId(c)) {
                    ++x;
                } else {
                    break;
                }
            }
            t = H.IDENTIFIED;
        } else if (c == '`') {
            while (!(c == '`') && x < size) {
                ++x;
                c = (char) reader[x];
            }
            ++x;
            t = H.IDENTIFIED;
        } else if (c == '\'') {
            while (!(c == '\'') && x < size) {
                ++x;
                c = (char) reader[x];
            }
            ++x;
            t = H.IDENTIFIED;
        } else if (c == '"') {
            if (x==0){
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

    public void jumpPassSpace() {
        while (hasMore = x < size) {
            int c = reader[x];
            if (c == ' ' || c == '\t' || c == '\n') {
                ++x;
            } else {
                break;
            }
        }
    }
}
