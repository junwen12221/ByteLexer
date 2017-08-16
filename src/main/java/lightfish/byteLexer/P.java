package lightfish.byteLexer;


/**
 * Created by jamie on 2017/8/16.
 */
public   class P {
    public boolean hasMore;
    public byte[] reader;
    public int start = 0;
    public int size;
    public int x = 0;
    public long t;

    /**
     * 分模块
     * 后缀符号解析有问题
     *
     * @return
     */

    public long getTokenType() {
        return t;
    }
    public void init(byte[] r,int index) {
        hasMore = true;
        reader = r;
        size = r.length;
        x=index;
        t=0;
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

    final boolean is(int c) {
        boolean res = reader[x++] == c;
        return res;
    }
    public final void endId() {
        char c;
        if ((x + 1) >= size) {
            hasMore = false;
            return;
        }
        c = (char) reader[x];
      if (Character.isWhitespace(c)){
          return;
      }else {
          id();
      }
    }

    public final void id() {
        char c;
        if ((x + 1) >= size) {
            hasMore = false;
            return;
        }
        c = (char) reader[x];
        if (('A' <= c && c <= 'Z') || ('a' <= c && c <= 'z') || ('0' <= c && c <= '9')||c=='_') {
            while (!(c == ' ' || c == '\n' || c == '\t' || c == '.' || c == ',') && x < size) {
                if (c != '.' && c != ',') {
                    ++x;
                    c = (char) reader[x];
                } else {
                    x -= 2;
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
            while (x < size) {
                if (c == '"' && (reader[x - 1] != '\\')) {

                } else {
                    ++x;
                    c = (char) reader[x];
                }
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
