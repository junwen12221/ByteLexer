package lightfish.byteLexer;


import java.nio.charset.StandardCharsets;

public class Lexer {
    public boolean hasMore;
    byte[] reader;
    int start = 0;
    int size;
    int x = 0;
    long t;

    public Lexer() {


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

    public static void main(String[] args) throws Exception {
        long o = H.ACCESSIBLE;
        Lexer lexer = new Lexer("select t2.product_id,t2.PRODUCT_NAME,t2.product_status,t2.suggested_price,t3.file_path,t.sum,t4.min_price from v_product_num_all t join product t2 on t.product_id = t2.PRODUCT_ID join v_product_img t3 on t2.ATTACH_ID = t3.ATTACH_ROOT_ID join v_product_price t4 on t.product_id = t4.product_id where t2.CUST_ID = '100000000009818' ORDER BY t.sum desc LIMIT 3".toLowerCase().getBytes(StandardCharsets.US_ASCII));
        while (lexer.hasMore) {
            lexer.match();
            System.out.println(lexer.readString());
            System.out.println(lexer.getTokenType());
        }
    }


    public Lexer(byte[] r) {
        hasMore = true;
        reader = r;
        size = r.length;
    }

    public void init(byte[] r) {
        hasMore = true;
        reader = r;
        size = r.length;
    }

    public String readString() {
        return new String(this.reader, start, x - start);
    }

    int cc(int x) {
        return (int) this.reader[++this.x];
    }

    final boolean nextIsBlank() {
        return (reader[++x] == ' ' || reader[x] == '\t' || reader[x] == '\r' || reader[x] == '\n');
    }

    final boolean is(int c) {
        boolean res = reader[x++] == c;
        return res;
    }

    final void id() {
        char c;
        if ((x + 1) >= size) {
            hasMore = false;
            return;
        }
        c = (char) reader[x];
        if (('A' <= c && c <= 'Z') || ('a' <= c && c <= 'z') || ('0' <= c && c <= '9')) {
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


    final void findNextToken() {
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

    void jumpPassSpace() {
        while (hasMore = x < size) {
            int c = reader[x];
            if (c == ' ' || c == '\t' || c == '\n') {
                ++x;
            } else {
                break;
            }
        }
    }

    public void match() {
        jumpPassSpace();
        this.start = x;
        int c = 0;
        if (!hasMore) return;
//        switch (reader[x]){
//            case 'a' :{x=AParseNode.parse(x);t=AParseNode.t;}
//            case 'b' :{x=BParseNode.parse(x);t=BParseNode.t;}
//            case 'c' :{x=CParseNode.parse(x);t=CParseNode.t;}
//            case 'd' :{x=DParseNode.parse(x);t=DParseNode.t;}
//            case 'e' :{x=EParseNode.parse(x);t=EParseNode.t;}
//            case 'f' :{x=FParseNode.parse(x);t=FParseNode.t;}
//            case 'g' :{x=GParseNode.parse(x);t=GParseNode.t;}
//            case 'h' :{x=HParseNode.parse(x);t=HParseNode.t;}
//            case 'i' :{x=IParseNode.parse(x);t=IParseNode.t;}
//            case 'j' :{x=JParseNode.parse(x);t=JParseNode.t;}
//            case 'k' :{x=KParseNode.parse(x);t=KParseNode.t;}
//            case 'l' :{x=LParseNode.parse(x);t=LParseNode.t;}
//            case 'm' :{x=MParseNode.parse(x);t=MParseNode.t;}
//            case 'n' :{x=NParseNode.parse(x);t=NParseNode.t;}
//            case 'o' :{x=OParseNode.parse(x);t=OParseNode.t;}
//            case 'p' :{x=PParseNode.parse(x);t=PParseNode.t;}
//            case 'q' :{x=QParseNode.parse(x);t=QParseNode.t;}
//            case 'r' :{x=RParseNode.parse(x);t=RParseNode.t;}
//            case 's' :{x=SParseNode.parse(x);t=SParseNode.t;}
//            case 't' :{x=TParseNode.parse(x);t=TParseNode.t;}
//            case 'u' :{x=UParseNode.parse(x);t=UParseNode.t;}
//            case 'v' :{x=VParseNode.parse(x);t=VParseNode.t;}
//            case 'w' :{x=WParseNode.parse(x);t=WParseNode.t;}
//            case 'x' :{x=XParseNode.parse(x);t=XParseNode.t;}
//            case 'y' :{x=YParseNode.parse(x);t=YParseNode.t;}
//            case 'z' :{x=ZParseNode.parse(x);t=ZParseNode.t;}
//            default:id();return;
//        }
    }
}