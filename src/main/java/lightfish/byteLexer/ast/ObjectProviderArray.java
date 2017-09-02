package lightfish.byteLexer.ast;

/**
 * Created by jamie on 2017/9/1.
 */
public class ObjectProviderArray<T extends ValueObject,R extends ValueType> implements ObjectProvider<T,R> {
    final ValueObject[] objects;
    int count;
    final R valueType;

    public ObjectProviderArray(int size,Class<T> tClass,R valueType) throws Exception{
        this.objects = new ValueObject[size];
        this.count = 0;
        for (int i = 0; i < objects.length; i++) {
            T b=tClass.newInstance();
            b.setObjectProvider(this);
            objects[i] = b;
        }
        this.valueType = valueType;
    }

    public T NewInstance() {
        return (T) objects[count++];
    }

    public void Free() {
        count = 0;
        for (int i = 0; i < objects.length; i++) {
            objects[i].thisAddress = 0;
        }
    }

    public T New() {
        T res = NewInstance();
        res.setThisAddress(valueType.Malloc());
        return res;
    }

    public T New(int address) {
        T res = NewInstance();
        res.setThisAddress(address);
        return res;
    }

    public R getValueType() {
        return valueType;
    }
    public T Clone(T value) {
        T testValueObject = this.NewInstance();
        int newAddress = valueType.GetByteStore().malloc(TestValueType.SIZE);
        testValueObject.setThisAddress(newAddress);
        int limit = newAddress + TestValueType.SIZE;
        ByteStore byteStore = valueType.byteStore;
        for (int i = value.getThisAddress(), j = newAddress; j < limit; i++, j++) {
            byteStore.set(j, byteStore.getByte(i));
        }
        return testValueObject;
    }
}
