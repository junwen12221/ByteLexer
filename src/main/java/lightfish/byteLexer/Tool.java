package lightfish.byteLexer;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Administrator on 2017/4/6 0006.
 */
public class Tool {
    public static void main(String[] args) {
        System.out.println(genMethod("test",genIfAnd("main();", "main2();", "a==b")));
    }

    static String genIfAnd(String body, String elseBody, String... args) {
        return Stream.of(args).collect(Collectors.joining("')&&is('", "if(is('", "'))")).concat("{").concat(body).concat("}").concat("else {").concat(elseBody).concat("}");
    }

    static String genSwitch(List<String> caseList, String defaultBody) {
        return "switch (x){".concat(caseList.stream().collect(Collectors.joining())).concat("default:").concat("{").concat(defaultBody).concat("}")
                .concat("\n};");
    }

    static String genBreakCaseBody(String body) {
        return "{".concat(body).concat("break;}");
    }

    static String genReturnCaseBody(String body) {
        return "{".concat(body).concat("return;}");
    }
    static String genReturnCase(String cvalue,String body) {
        return "case "+cvalue+":"+genReturnCaseBody(body);
    }
    static String genMethod(String name, String body) {
        return "static class " + name + "{\n" + "public static void match(int x){" + body + "}}";
    }

    static int jumpToSeparator(int index, int size, byte[] src) {
        for (int i = index; i < size; i++) {
            byte c = src[i];
            switch (c) {
                case ';':
                case ' ':
                case '(': case ')':
                case ',':
                case '+': {
                    return i;
                }
            }
        }
        return size;
    }

//    static int getId(int start, int index, int size, byte[] src, BiConsumer<Integer, Integer> biConsumer) {
//        int end= jumpToSeparator(index, size, src);
//        biConsumer.accept(start,end);
//        return end;
//    }
//    static int getId(int start, int index, int size, byte[] src) {
//        int end= jumpToSeparator(index, size, src);
//        return end;
//    }
    static int getString(int start, int index, int size, byte[] src, BiConsumer<Integer, Integer> biConsumer) {
        for (int i = index; i < size; i++) {
            byte c = src[i];
            if (c == '"'&&(src[i-1]!='\\')) {
                biConsumer.accept(start,i);
                ++i;
                return i;
            }
        }
        return  size;
    }
    static int getString(int start, int index, int size, byte[] src) {
        for (int i = index; i < size; i++) {
            byte c = src[i];
            if (c == '"'&&(src[i-1]!='\\')) {
                ++i;
                return i;
            }
        }
        return  size;
    }

}
