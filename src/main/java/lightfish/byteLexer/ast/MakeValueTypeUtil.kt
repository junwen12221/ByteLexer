//package lightfish.byteLexer.ast
//
//import java.io.FileWriter
//import java.lang.reflect.Method
//import java.util.*
//import java.util.stream.Collectors
//
///**
// * Created by jamie on 2017/9/1.
// */
//object MakeValueTypeUtil {
//
//    @Throws(Exception::class)
//    @JvmStatic fun main(args: Array<String>) {
//        val methods = Test::class.java.methods
//        val className = Test::class.java.simpleName + "ValueType"
//        val methodList = Arrays.asList(*methods).stream()
//                .filter { i ->
//                    val name = i.name
//                    name.startsWith("get") && !i.returnType.name.contains("void")
//                }.collect<List<Method>, Any>(Collectors.toList<Method>())
//        val booleanListMap = methodList.stream()
//                .collect<Map<Boolean, List<Method>>, Any>(Collectors.partitioningBy<Method> { s -> s.returnType.isPrimitive })
//        info("=> 输出内存布局")
//        var size = 0
//        val fieldList = ArrayList<String>()
//        val getMethodList = ArrayList<String>()
//        val setMethodList = ArrayList<String>()
//        val refMethodList = ArrayList<String>()
//        val initMethodList = ArrayList<String>()
//        for (i in methodList.indices) {
//            val method = methodList[i]
//            val name = method.name.substring(3, method.name.length)
//            val field = String.format("%s_Offset", name).toUpperCase()
//            fieldList.add(String.format("public final int %s=%d;%n", field, size))
//            val returnType = method.returnType.name
//            getMethodList.add(String.format("public  %s get%s(int thisAddress){return byteStore.get%s(thisAddress+%s);}",
//                    getNormalizeReturnName(returnType),
//                    name,
//                    getNormalizeVarName(getNormalizeReturnMethodName(returnType)),
//                    field))
//            val setArgs = arrayOf<Any>(name, getNormalizeReturnName(returnType), getNormalizeVarName(getNormalizeReturnMethodName(returnType)), field)
//            val setMethod = String.format("public  void set%s(int thisAddress,%s value) {byteStore.set%s(thisAddress+%s,value);}",
//                    *setArgs)
//            setMethodList.add(setMethod)
//            initMethodList.add(String.format("set%s(thisAddress,0);", name))
//            if (!method.returnType.isPrimitive) {
//                refMethodList.add(String.format("public  int getAlloc%s(int thisAddress) {return byteStore.getRefIfNull(thisAddress+%s,%s.SIZE);}", getNormalizeVarName(name), field, className))
//            }
//            size += getSize(method.returnType.name)
//        }
//
//
//
//        //输出结构体总大小
//        val fileWriter = FileWriter("D:\\byteLexer\\src\\main\\java\\lightfish\\byteLexer\\ast\\$className.java")
//        val code = String.format("package lightfish.byteLexer.ast; public class  %s{final ByteStore byteStore;%s}", className,
//                String.format(" public %s(ByteStore b){this.byteStore = b;}" +
//                        //  "public void setByteStore(ByteStore b){this.byteStore = b;}" +
//                        "public ByteStore GetByteStore(){return this.byteStore;}", className) +
//                        fieldList.stream().collect<String, *>(Collectors.joining()) +
//                        getMethodList.stream().collect<String, *>(Collectors.joining()) +
//                        setMethodList.stream().collect<String, *>(Collectors.joining()) +
//                        String.format("public static final int SIZE=%d;%n", size) +
//                        refMethodList.stream().collect<String, *>(Collectors.joining()) +
//                        //  String.format("public void init(int thisAddress){int size=SIZE+thisAddress; for(int i=thisAddress;i<size;++i){byteStore.setByte(i,(byte)0);}}")+
//                        ""
//        )
//        fileWriter.write(code)
//        fileWriter.flush()
//        fileWriter.close()
//
//
//    }
//
//    internal fun getSize(v: String): Int {
//        when (v.trim { it <= ' ' }) {
//            "byte" -> return 1
//            "short" -> return 2
//            "char" -> return 2
//            "int" -> return 4
//            "long" -> return 8
//            "float" -> return 4
//            "double" -> return 8
//            else -> return 4
//        }
//    }
//
//    internal fun getNormalizeVarName(v: String): String {
//        val res = v[0].toString().toUpperCase() + v.substring(1, v.length)
//        return res
//    }
//
//    internal fun getNormalizeReturnName(v: String): String {
//        when (v.trim { it <= ' ' }) {
//            "byte", "short", "char", "int", "long", "float", "double" -> return v
//            else -> return "int"
//        }
//    }
//
//    internal fun getNormalizeReturnMethodName(v: String): String {
//        when (v.trim { it <= ' ' }) {
//            "byte", "short", "char", "int", "long", "float", "double" -> return v
//            else -> return "address"
//        }
//    }
//
//    fun info(msg: String) {
//        println(msg)
//    }
//    //    public static String genValueTypeTemplate(String )
//}
