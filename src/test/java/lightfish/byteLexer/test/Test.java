package lightfish.byteLexer.test;

import lightfish.byteLexer.H;
import lightfish.byteLexer.LLKLexer;
import lightfish.byteLexer.NLexer;

import java.nio.charset.StandardCharsets;

/**
 * Created by jamie on 2017/8/16.
 */
public class Test {
    public static void main(String[] args) throws Exception {

        NLexer lexer = new NLexer();
        LLKLexer l = new LLKLexer(lexer);
        l.init("SELECT a fROm ab             , ee.ff AS f,(SELECT a FROM `schema_bb`.`tbl_bb`,(SELECT a FROM ccc AS c, `dddd`));".toLowerCase().getBytes(StandardCharsets.UTF_8));
        int type = l.t;
        while ((type = l.t) != -1) {
            switch (type) {
                case H.FROM: {
                    do {
                       type= l.read();
                        String head = l.readToString();
                        if (type==H.ID_TOKEN){
                            System.out.println(head);
                        }
                        if (l.peek() == H.DOT) {
                            l.read2();
                            System.out.println( "." + l.readToString());
                        }
                        if (l.peek() == H.AS) {
                            l.read2();
                            System.out.println("as :" + l.readToString());
                        }
                        if (l.peek() == H.COMMA) {
                            l.read();
                        } else {
                            break;
                        }
                    } while (true);
                }
                default:
            }
            l.read();
        }

    }
}
