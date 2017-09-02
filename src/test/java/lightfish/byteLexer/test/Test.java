package lightfish.byteLexer.test;

import lightfish.byteLexer.H;
import lightfish.byteLexer.LLKLexer;
import lightfish.byteLexer.NLexer;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.CharBuffer;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jamie on 2017/8/16.
 */
public class Test {

    public static final ArrayList<node> t_stack = new ArrayList<>();

    static {
        t_stack.add(new node());
    }

    public static class node {
        int pos;
        public byte[] text;
        public List<node> children = new ArrayList<>();

        public node() {
            this.text = "undefined".getBytes();
        }

        public node(int pos) {
            this.pos = pos;
        }

        public node(byte[] text) {
            this.text = text;
        }
    }
    public static int factor(LLKLexer l) throws Exception{
        int value = 0;
        if (l.t == H.LEFTBRACKET) {
            l.read();
          //  System.out.println(l.read2String());
            value = expr(l);
            l.match(H.RIGHTBRACKET);
        } else {
            value = l.read2Int();
            l.read();
        }
        return value;
    }

    public static int term_tail(LLKLexer l,int lvalue) throws Exception{
        if (l.t == H.ASTERISK) {
            l.read();
            int value = lvalue * factor(l);
            return term_tail(l,value);
//        } else if (token == '/') {
//            match('/');
//            int value = lvalue / factor();
//            return term_tail(value);
        } else {
            return lvalue;
        }
    }

   public static int term(LLKLexer l)throws Exception {
        int lvalue = factor(l);
        return term_tail(l,lvalue);
    }

    public static  int expr_tail(LLKLexer l,int lvalue)throws Exception {
        //System.out.println(l.read2String());
        if (l.t ==H.PLUS) {
            l.read();
            int value = lvalue + term(l);
            return expr_tail(l,value);
//        } else if (token == '-') {
//            match('-');
//            int value = lvalue - term();
//            return expr_tail(value);
        } else {
            return lvalue;
        }
    }

    public static  int expr(LLKLexer l) throws Exception{
        int lvalue = term(l);
        //System.out.println(l.read2String());
        return expr_tail(l,lvalue);
    }

    public static void parse(LLKLexer l) throws Exception {
        int type = l.t;
        while ((type = l.t) != -1) {
            switch (type) {
                case H.FROM: {
                    do {
                        type = l.read();
                        String head = l.read2String();
                        if (type == H.LEFTBRACKET) {
                            System.out.println("=====>");
                            parse(l);
                        }
                        if (type == H.ID_TOKEN) {
                            System.out.println(head);
                        }
                        if (l.peek() == H.DOT) {
                            l.read2();
                            System.out.println("." + l.read2String());
                        }
                        if (l.peek() == H.AS) {
                            l.read2();
                            System.out.println("as :" + l.read2String());
                        }
                        if (l.peek() == H.COMMA) {
                            l.read();
                        } else {
                            break;
                        }
                    } while (true);
                    continue;
                }
                case H.LEFTBRACKET: {
                    l.read();
                    parse(l);
                    continue;
                }
                case H.RIGHTBRACKET: {
                    l.read();
                    System.out.println("<=====");
                    return;
                }
                default:
            }
            l.read();
        }
    }

    public static void main(String[] args) throws Exception {
        NLexer lexer = new NLexer();
        LLKLexer l = new LLKLexer(lexer);
//        l.init("SELECT a fROm ab             , ee.ff AS f,(SELECT a FROM `schema_bb`.`tbl_bb`,(SELECT a FROM ccc AS c, `dddd`));".toLowerCase().getBytes(StandardCharsets.UTF_8));
//        parse(l);
        l.init("(1+8)*7+(1+8)*7+12345+((1+8)*7+(1+8)*7+(1+8)*7+ (1+8)*7+(1+8)*7   +(1+8)*7+(1+8)*7+(1+8)*7+(1+8)*7+(1+8)*7+(1+8)*7)*63 ".getBytes(StandardCharsets.UTF_8));
       System.out .println(expr(l));

    }
}
