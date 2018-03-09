package lightfish.byteLexer;


import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.ArrayList;
import java.util.List;

public class LLKLexer {
    boolean hasMore = true;
    public P lexer;
    public static final int EOF = -1;
    public int start;
    public int end;
    public int t;
    public int start2;
    public int end2;
    public int t2;
    private void  two2One(){
       t= t2;
       start=start2;
       end=end2;
    }
    private List<Integer> queue = new ArrayQueue<>(4096);
    private List<Integer> StringStartQueue = new ArrayQueue<Integer>(16);
    private List<Integer> StringEndQueue = new ArrayQueue<Integer>(16);
    private List<Integer> IntStartQueue = new ArrayQueue<Integer>(16);
    private List<Integer> IntEndQueue = new ArrayQueue<Integer>(16);
    private List<Integer> IdStartQueue = new ArrayQueue<Integer>(16);
    private List<Integer> IdEndQueue = new ArrayQueue<Integer>(16);

    public String read2String() {
        String str = new String(lexer.reader, start, end - start);
        return str;
    }
    public int read2Int() {
        int value = 0;
        for (int i=start; i<end; i++) {
            value = (value*10)+(lexer.reader[i]-'0');
        }
       return value;
    }
    public double read2Double() {
        return Double.parseDouble(new String(lexer.reader, start, end - start));
    }
    public LLKLexer(P r) {
        hasMore = true;
        lexer = r;
    }

    public void init(byte[] r) {
        hasMore=true;
        lexer.init(r, 0);
        lexer.parse();
        t=lexer.t;
        start=lexer.start;
        end=lexer.x;
        lexer.parse();
        t2=lexer.t;
        start2=lexer.start;
        end2=lexer.x;
    }

    public int read() throws Exception {
        two2One();
        if (lexer.hasMore) {
            lexer.parse();
            t2=lexer.t;
            start2=lexer.start;
            end2=lexer.x;
            return t;
        } else {
            t=-1;
            return EOF;
        }
    }
    public int read2() throws Exception {
        if (lexer.hasMore) {
            lexer.parse();
            t=lexer.t;
            start=lexer.start;
            end=lexer.x;
            lexer.parse();
            t2=lexer.t;
            start2=lexer.start;
            end2=lexer.x;
            return t;
        } else {
            t=-1;
            return EOF;
        }
    }


    public void match(int key) throws Exception {
        int token = t;
        read();
        if (key != token) {
            throw new Exception(key + " expected.");//todo 输出token\
        }
    }

    public int peek() throws Exception {
        if (lexer.hasMore)
            return t2;
        else
            return EOF;
    }

    private boolean fillQueue(int i) throws Exception {
        while (i >= queue.size())
            if (lexer.hasMore){
            lexer.parse();
                queue.add(lexer.getTokenType());
            }

            else
                return false;
        return true;
    }

    protected void readLeftBracket() throws Exception {
            lexer.parse();
            int type = lexer.getTokenType();
            switch (type) {
                case H.LEFTBRACKET:
                    queue.add(type);
                    break;
                case H.ID_TOKEN: {
                    IdStartQueue.add(lexer.start);
                    IdEndQueue.add(lexer.x);
                    queue.add(type);
                    break;
                }
                case H.STRING_TOKEN: {
                    StringStartQueue.add(lexer.start);
                    StringEndQueue.add(lexer.x);
                    queue.add(type);
                    break;
                }
                case H.INT_TOKEN: {
                    IntStartQueue.add(lexer.start);
                    IntEndQueue.add(lexer.x);
                    queue.add(type);
                    break;
                }
                default:
                    queue.add(type);
            }
        if (queue.size() == 1 && lexer.hasMore == false) {
            hasMore = false;
        }
        return;
    }
}