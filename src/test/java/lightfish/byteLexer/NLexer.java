package lightfish.byteLexer;




import java.nio.charset.StandardCharsets;

public class NLexer {
    public boolean hasMore;
    byte[] reader;
    int start = 0;
    int size;
    int x = 0;
    long t;

    public NLexer() {


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
        String name="select t2.product_id,t2.PRODUCT_NAME,t2.product_status,t2.suggested_price,t3.file_path,t.sum,t4.min_price from v_product_num_all t join product t2 on t.product_id = t2.PRODUCT_ID join v_product_img t3 on t2.ATTACH_ID = t3.ATTACH_ROOT_ID join v_product_price t4 on t.product_id = t4.product_id where t2.CUST_ID = '100000000009818' ORDER BY t.sum desc LIMIT 3";
        NLexer lexer = new NLexer("t.".toLowerCase().getBytes(StandardCharsets.US_ASCII));
        while (lexer.hasMore) {
            lexer.match();
            System.out.println(lexer.readString());
            System.out.println(lexer.getTokenType());
        }
    }


    public NLexer(byte[] r) {
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
        if ((x + 1) > size) {
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

    AParseNode aparsenode =new AParseNode();
BParseNode bparsenode =new BParseNode();
CParseNode cparsenode =new CParseNode();
DParseNode dparsenode =new DParseNode();
EParseNode eparsenode =new EParseNode();
FParseNode fparsenode =new FParseNode();
GParseNode gparsenode =new GParseNode();
HParseNode hparsenode =new HParseNode();
IParseNode iparsenode =new IParseNode();
JParseNode jparsenode =new JParseNode();
KParseNode kparsenode =new KParseNode();
LParseNode lparsenode =new LParseNode();
MParseNode mparsenode =new MParseNode();
NParseNode nparsenode =new NParseNode();
OParseNode oparsenode =new OParseNode();
PParseNode pparsenode =new PParseNode();
QParseNode qparsenode =new QParseNode();
RParseNode rparsenode =new RParseNode();
SParseNode sparsenode =new SParseNode();
TParseNode tparsenode =new TParseNode();
UParseNode uparsenode =new UParseNode();
VParseNode vparsenode =new VParseNode();
WParseNode wparsenode =new WParseNode();
XParseNode xparsenode =new XParseNode();
YParseNode yparsenode =new YParseNode();
ZParseNode zparsenode =new ZParseNode();
public void match(){jumpPassSpace();this.start=x;int c=0;if (!hasMore)return;
switch (reader[x]){
case 'a' :{aparsenode.init(reader,x);x=aparsenode.parse();t=aparsenode.t;break;}
case 'b' :{bparsenode.init(reader,x);x=bparsenode.parse();t=bparsenode.t;break;}
case 'c' :{cparsenode.init(reader,x);x=cparsenode.parse();t=cparsenode.t;break;}
case 'd' :{dparsenode.init(reader,x);x=dparsenode.parse();t=dparsenode.t;break;}
case 'e' :{eparsenode.init(reader,x);x=eparsenode.parse();t=eparsenode.t;break;}
case 'f' :{fparsenode.init(reader,x);x=fparsenode.parse();t=fparsenode.t;break;}
case 'g' :{gparsenode.init(reader,x);x=gparsenode.parse();t=gparsenode.t;break;}
case 'h' :{hparsenode.init(reader,x);x=hparsenode.parse();t=hparsenode.t;break;}
case 'i' :{iparsenode.init(reader,x);x=iparsenode.parse();t=iparsenode.t;break;}
case 'j' :{jparsenode.init(reader,x);x=jparsenode.parse();t=jparsenode.t;break;}
case 'k' :{kparsenode.init(reader,x);x=kparsenode.parse();t=kparsenode.t;break;}
case 'l' :{lparsenode.init(reader,x);x=lparsenode.parse();t=lparsenode.t;break;}
case 'm' :{mparsenode.init(reader,x);x=mparsenode.parse();t=mparsenode.t;break;}
case 'n' :{nparsenode.init(reader,x);x=nparsenode.parse();t=nparsenode.t;break;}
case 'o' :{oparsenode.init(reader,x);x=oparsenode.parse();t=oparsenode.t;break;}
case 'p' :{pparsenode.init(reader,x);x=pparsenode.parse();t=pparsenode.t;break;}
case 'q' :{qparsenode.init(reader,x);x=qparsenode.parse();t=qparsenode.t;break;}
case 'r' :{rparsenode.init(reader,x);x=rparsenode.parse();t=rparsenode.t;break;}
case 's' :{sparsenode.init(reader,x);x=sparsenode.parse();t=sparsenode.t;break;}
case 't' :{tparsenode.init(reader,x);x=tparsenode.parse();t=tparsenode.t;break;}
case 'u' :{uparsenode.init(reader,x);x=uparsenode.parse();t=uparsenode.t;break;}
case 'v' :{vparsenode.init(reader,x);x=vparsenode.parse();t=vparsenode.t;break;}
case 'w' :{wparsenode.init(reader,x);x=wparsenode.parse();t=wparsenode.t;break;}
case 'x' :{xparsenode.init(reader,x);x=xparsenode.parse();t=xparsenode.t;break;}
case 'y' :{yparsenode.init(reader,x);x=yparsenode.parse();t=yparsenode.t;break;}
case 'z' :{zparsenode.init(reader,x);x=zparsenode.parse();t=zparsenode.t;break;}
default:id();return;
}
}}