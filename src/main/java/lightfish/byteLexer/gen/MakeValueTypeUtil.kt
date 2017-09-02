package lightfish.byteLexer.gen

import lightfish.byteLexer.ast.Test
import java.io.FileWriter
import java.lang.reflect.Method
import java.util.*
import java.util.stream.Collectors

/**
 * Created by jamie on 2017/9/2.
 */


fun main(args: Array<String>) {
    val x = Test::class;
    val name = x.java.simpleName;
    makeValueType("lightfish.byteLexer.ast",name, x.java.methods);
}

fun makeValueType(packageName:String,className: String, methods: Array<Method>): Unit {
    val methodList = Arrays.asList(*methods).stream()
            .filter { i ->
                i.name.startsWith("get") && !i.returnType.name.contains("void")
            }.collect(Collectors.toList())
    var size = 0
    val fieldList = ArrayList<String>()
    val getMethodList = ArrayList<String>()
    val setMethodList = ArrayList<String>()
    val refMethodList = ArrayList<String>()
    val initMethodList = ArrayList<String>()
    for (i in methodList.indices) {
        val method = methodList[i]
        val name = method.name.substring(3, method.name.length)
        val field = "${name}s_Offset".toUpperCase()
        fieldList.add("public final int ${field}=${size};\n");
        val returnType = method.returnType.name
        getMethodList.add("public  ${getNormalizeReturnName(returnType)} get${name}(int thisAddress){return byteStore.get${getNormalizeVarName(getNormalizeReturnMethodName(returnType))}(thisAddress+${field});}\n");
        val setMethod = "public  void set${name}(int thisAddress,${getNormalizeReturnName(returnType)} value) {byteStore.set${getNormalizeVarName(getNormalizeReturnMethodName(returnType))}(thisAddress+${field},value);}\n"
        setMethodList.add(setMethod)
        initMethodList.add("set${name}(thisAddress,0);\n")
        if (!method.returnType.isPrimitive) {
            refMethodList.add("public  int getAlloc${getNormalizeVarName(name)}(int thisAddress) {return byteStore.getRef(thisAddress+${field},${className}ValueType.SIZE);}\n")
        }
        size += getSize(method.returnType.name)
    }
    val ValueTypeTemplate = """
package ${packageName};

public class ${className}ValueType extends ValueType{

public ${className}ValueType(ByteStore b){super(b);}
/**
 * static const field
 *
 *
 */
${fieldList.stream().collect(Collectors.joining())}

/**
 * static getter setter
 */

${getMethodList.stream().collect(Collectors.joining())}
${setMethodList.stream().collect(Collectors.joining())}

public static final int SIZE=${size};
@Override
int Sizeof(){return SIZE;}
/**
 * static getAlloc
 */
${refMethodList.stream().collect(Collectors.joining())}}
""";

    //输出结构体总大小
    val fileWriter = FileWriter("D:\\byteLexer\\src\\main\\java\\lightfish\\byteLexer\\ast\\${className}ValueType.java")
    fileWriter.write(ValueTypeTemplate)
    fileWriter.flush()
    fileWriter.close()
}

fun getSize(v: String): Int {
    when (v.trim { it <= ' ' }) {
        "byte" -> return 1
        "short" -> return 2
        "char" -> return 2
        "int" -> return 4
        "long" -> return 8
        "float" -> return 4
        "double" -> return 8
        else -> return 4
    }
}

fun getNormalizeVarName(v: String): String {
    val res = v[0].toString().toUpperCase() + v.substring(1, v.length)
    return res
}

fun getNormalizeReturnName(v: String): String {
    when (v.trim { it <= ' ' }) {
        "byte", "short", "char", "int", "long", "float", "double" -> return v
        else -> return "int"
    }
}

fun getNormalizeReturnMethodName(v: String): String {
    when (v.trim { it <= ' ' }) {
        "byte", "short", "char", "int", "long", "float", "double" -> return v
        else -> return "address"
    }
}

fun info(msg: String) {
    println(msg)
}




