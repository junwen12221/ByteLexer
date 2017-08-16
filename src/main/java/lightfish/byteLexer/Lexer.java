package lightfish.byteLexer;


import java.nio.charset.StandardCharsets;

public class Lexer extends P{
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
        Lexer lexer = new Lexer("select t2.product_id,t2.PRODUCT_NAME,t2.product_status,t2.suggested_price,t3.file_path,t.sum,t4.min_price from v_product_num_all t join product t2 on t.product_id = t2.PRODUCT_ID join v_product_img t3 on t2.ATTACH_ID = t3.ATTACH_ROOT_ID join v_product_price t4 on t.product_id = t4.product_id where t2.CUST_ID = '100000000009818' ORDER BY t.sum desc LIMIT 3".toLowerCase().getBytes(StandardCharsets.US_ASCII));
        while (lexer.hasMore) {
            lexer.match();
            System.out.println(lexer.readString());
            System.out.println(lexer.getTokenType());
        }
        System.out.println("=>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        lexer.init("SELECT a fROm ab             , ee.ff AS f,(SELECT a FROM `schema_bb`.`tbl_bb`,(SELECT a FROM ccc AS c, `dddd`));".toLowerCase().getBytes(StandardCharsets.US_ASCII));
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
        x=0;
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