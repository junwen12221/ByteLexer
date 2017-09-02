package lightfish.byteLexer.ast;

/**
 * Created by jamie on 2017/9/1.
 */
public abstract class ValueObject<T extends ValueObject, R extends ValueType> {
    int thisAddress = 0;
    R valueType;
//    ObjectProvider<T, R>[] objectProvider;
//
    public int getThisAddress() {
        return thisAddress;
    }

    public void setThisAddress(int thisAddress) {
        this.thisAddress = thisAddress;
    }
//
//
//    public ObjectProvider getObjectProvider() {
//        return objectProvider;
//    }
//

    public R getValueType() {
        return valueType;
    }

    public void setValueType(R valueType) {
        this.valueType = valueType;
    }

//
//    public void setObjectProvider(ObjectProvider objectProvider) {
//        this.objectProvider = objectProvider;
//    }

}
