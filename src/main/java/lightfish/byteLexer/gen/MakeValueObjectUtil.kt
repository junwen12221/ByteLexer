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
    makeValueObjectUtil("lightfish.byteLexer.ast", name, x.java.methods);
}


fun makeValueObjectUtil(packageName: String, className: String, methods: Array<Method>): Unit {
    val methodList = Arrays.asList(*methods).stream()
            .filter { i ->
                i.name.startsWith("get") && !i.returnType.name.contains("void")
            }.collect(Collectors.toList())
    var size = 0
    val fieldList = ArrayList<String>()
    val getMethodList = ArrayList<String>()
    val setMethodList = ArrayList<String>()
    val providerList = ArrayList<Method>()
    val refInfoList = ArrayList<String>()
    val initMethodList = ArrayList<String>()
    for (i in methodList.indices) {
        val method = methodList[i]
        val name = method.name.substring(3, method.name.length)
        val returnType = method.returnType.name
        if (method.returnType.isPrimitive) {
            getMethodList.add("public ${getNormalizeReturnName(returnType)} get${name}(){return getValueType().get${name}(thisAddress);}\n");
            val setMethod = "public void set${name}(${getNormalizeReturnName(returnType)} value) {getValueType().set${name}(thisAddress,value);}\n"
            setMethodList.add(setMethod)
            initMethodList.add("set${name}(thisAddress,0);\n")
        }
        if (!method.returnType.isPrimitive) {
            providerList.add(method);
            var typename = method.returnType.name;
            typename=typename.drop(typename.lastIndexOf(".")+1)
            val methodName = method.name.drop(3);
            refInfoList.add("""
    public ${typename}ValueObject get${methodName}() {
        TestValueObject object = ${typename.toLowerCase()}Provider.NewInstance();
        object.setThisAddress(getValueType().get${methodName}(thisAddress));
        return object;
    }

    public ${typename}ValueObject getAlloc${methodName}() {
        TestValueObject object = ${typename.toLowerCase()}Provider.NewInstance();
        object.setThisAddress(getValueType().getAlloc${methodName}(thisAddress));
        return object;
    }

    public void set${methodName}(${typename} object) {
        getValueType().set${methodName}(thisAddress, ((${typename}ValueObject) object).getThisAddress());
    }
    public void set${methodName}(${typename}ValueObject object) {
        getValueType().set${methodName}(thisAddress,object.getThisAddress());
    }
    public int get${methodName}Address() {
        return getValueType().get${methodName}(thisAddress);
    }
    public void set${methodName}Address(int value) {
        getValueType().setRight(thisAddress,value);
    }
            """);
        }
        size += getSize(method.returnType.name)
    }
    val providerInfo = providerList.distinct().map { i ->
        val typename = i.returnType.name;
        var providerName = typename.toLowerCase();
        providerName=providerName.substring(providerName.lastIndexOf(".")+1,providerName.length)
        """
    ObjectProvider<${getNormalizeVarName(providerName)}ValueObject>  ${providerName.toLowerCase()}Provider;
  public  ObjectProvider<${getNormalizeVarName(providerName)}ValueObject> get${getNormalizeVarName(providerName)}Provider(){return ${providerName.toLowerCase()}Provider;}
  public  void set${getNormalizeVarName(providerName)}Provider(ObjectProvider<${getNormalizeVarName(providerName)}ValueObject> p){${providerName}Provider=p;}
"""
    };
    val ValueObjectTemplate = """
package ${packageName};
/**
 * Created by jamie on 2017/9/1.
 */
public class ${className}ValueObject extends ValueObject<${className}ValueObject,${className}ValueType> implements ${className} {

${getMethodList.stream().collect(Collectors.joining())}
${setMethodList.stream().collect(Collectors.joining())}

${providerInfo.distinct().stream().collect(Collectors.joining())}

 ${refInfoList.stream().collect(Collectors.joining())}

}
"""
    val fileWriter = FileWriter("D:\\byteLexer\\src\\main\\java\\lightfish\\byteLexer\\ast\\${className}ValueObject.java")
    fileWriter.write(ValueObjectTemplate)
    fileWriter.flush()
    fileWriter.close()
}