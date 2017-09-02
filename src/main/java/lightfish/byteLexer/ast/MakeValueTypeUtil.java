package lightfish.byteLexer.ast;

import java.io.FileWriter;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by jamie on 2017/9/1.
 */
public class MakeValueTypeUtil {

    public static void main(String[] args) throws Exception {
        Method[] methods = Test.class.getMethods();
        String className = Test.class.getSimpleName() + "ValueType";
        List<Method> methodList = Arrays.asList(methods).stream()
                .filter((i) -> {
                    String name = i.getName();
                    return name.startsWith("get") && !i.getReturnType().getName().contains("void");
                }).collect(Collectors.toList());
        Map<Boolean, List<Method>> booleanListMap = methodList.stream()
                .collect(Collectors.partitioningBy((s) -> s.getReturnType().isPrimitive()));
        info("=> 输出内存布局");
        int size = 0;
        List<String> fieldList = new ArrayList<>();
        List<String> getMethodList = new ArrayList<>();
        List<String> setMethodList = new ArrayList<>();
        List<String> refMethodList = new ArrayList<>();
        List<String> initMethodList = new ArrayList<>();
        for (int i = 0; i < methodList.size(); i++) {
            Method method = methodList.get(i);
            String name = method.getName().substring(3, method.getName().length());
            String field = String.format("%s_Offset", name).toUpperCase();
            fieldList.add(String.format("public final int %s=%d;%n", field, size));
            String returnType = method.getReturnType().getName();
            getMethodList.add(String.format("public  %s get%s(int thisAddress){return byteStore.get%s(thisAddress+%s);}",
                    getNormalizeReturnName(returnType),
                    name,
                    getNormalizeVarName(getNormalizeReturnMethodName(returnType)),
                    field));
            Object[] setArgs = new Object[]{name,
                    (getNormalizeReturnName(returnType)),
                    getNormalizeVarName(getNormalizeReturnMethodName(returnType)), field};
            String setMethod = String.format("public  void set%s(int thisAddress,%s value) {byteStore.set%s(thisAddress+%s,value);}",
                    setArgs);
            setMethodList.add(setMethod);
            initMethodList.add(String.format("set%s(thisAddress,0);", name));
            if (!method.getReturnType().isPrimitive()) {
                refMethodList.add(String.format("public  int getAlloc%s(int thisAddress) {return byteStore.getRef(thisAddress+%s,%s.SIZE);}", getNormalizeVarName(name), field, className));
            }
            size += getSize(method.getReturnType().getName());
        }


        //输出结构体总大小
        FileWriter fileWriter = new FileWriter("D:\\byteLexer\\src\\main\\java\\lightfish\\byteLexer\\ast\\" + className + ".java");
        String code = String.format("package lightfish.byteLexer.ast; public class  %s{final ByteStore byteStore;%s}", className,
                String.format(" public %s(ByteStore b){this.byteStore = b;}" +
                        //  "public void setByteStore(ByteStore b){this.byteStore = b;}" +
                        "public ByteStore GetByteStore(){return this.byteStore;}", className) +
                        fieldList.stream().collect(Collectors.joining()) +
                        getMethodList.stream().collect(Collectors.joining()) +
                        setMethodList.stream().collect(Collectors.joining()) +
                        String.format("public static final int SIZE=%d;%n", size) +
                        refMethodList.stream().collect(Collectors.joining())+
                      //  String.format("public void init(int thisAddress){int size=SIZE+thisAddress; for(int i=thisAddress;i<size;++i){byteStore.setByte(i,(byte)0);}}")+
                        ""
        );
        fileWriter.write(code);
        fileWriter.flush();
        fileWriter.close();


    }

    static int getSize(String v) {
        switch (v.trim()) {
            case "byte":
                return 1;
            case "short":
                return 2;
            case "char":
                return 2;
            case "int":
                return 4;
            case "long":
                return 8;
            case "float":
                return 4;
            case "double":
                return 8;
            default:
                return 4;
        }
    }

    static String getNormalizeVarName(String v) {
        String res = String.valueOf(v.charAt(0)).toUpperCase() + v.substring(1, v.length());
        return res;
    }

    static String getNormalizeReturnName(String v) {
        switch (v.trim()) {
            case "byte":
            case "short":
            case "char":
            case "int":
            case "long":
            case "float":
            case "double":
                return v;
            default:
                return "int";

        }
    }

    static String getNormalizeReturnMethodName(String v) {
        switch (v.trim()) {
            case "byte":
            case "short":
            case "char":
            case "int":
            case "long":
            case "float":
            case "double":
                return v;
            default:
                return "address";

        }
    }


    public static void info(String msg) {
        System.out.println(msg);
    }
}
