package lightfish.byteLexer.ast;

import java.nio.ByteBuffer;

/**
 * Created by jamie on 2017/9/1.
 */
public class TestValueObject extends ValueObject<TestValueObject, TestValueType> implements Test {


    public byte getByte() {
        return getValueType().getByte(thisAddress);
    }

    public char getChar() {
        return getValueType().getChar(thisAddress);
    }

    public short getShort() {
        return getValueType().getShort(thisAddress);
    }

    public int getInt() {
        return getValueType().getInt(thisAddress);
    }

    public long getLong() {
        return getValueType().getInt(thisAddress);
    }

    public float getFloat() {
        return getValueType().getFloat(thisAddress);
    }

    public double getDouble() {
        return getValueType().getDouble(thisAddress);
    }

    public TestValueObject getLeft() {
        TestValueObject object = objectProvider.NewInstance();
        object.setThisAddress(getValueType().getLeft(thisAddress));
        return object;
    }

    public TestValueObject getAllocLeft() {
        TestValueObject object = objectProvider.NewInstance();
        object.setThisAddress(getValueType().getAllocLeft(thisAddress));
        return object;
    }

    public TestValueObject getRight() {
        TestValueObject object = objectProvider.NewInstance();
        object.setThisAddress(getValueType().getRight(thisAddress));
        return object;
    }

    public TestValueObject getAllocRight() {
        TestValueObject object = objectProvider.NewInstance();
        object.setThisAddress(getValueType().getAllocRight(thisAddress));
        return object;
    }

    public void setValue(int value) {
        getValueType().setValue(thisAddress, value);
    }


    public double setDouble() {
        return getValueType().getFloat(thisAddress);
    }

    public void setLeft(Test object) {
        getValueType().setLeft(thisAddress, ((TestValueObject) object).getThisAddress());
    }

    public void setRight(Test object) {
        getValueType().setRight(thisAddress, ((TestValueObject) object).getThisAddress());
    }

    public int getValue() {
        return getValueType().getValue(thisAddress);
    }


    public static void main(String[] args) throws Exception {
        ByteStore byteStore = new ByteStore();
        byteStore.setBytes(ByteBuffer.allocate(8192));
        TestValueType valueType = new TestValueType(byteStore);
        ObjectProviderArray<TestValueObject, TestValueType> provider = new ObjectProviderArray<>(64, TestValueObject.class, valueType);
        ///////////////////////////////////
        TestValueObject root;
        for (int i = 0; i < 1; i++) {
            byteStore.end();
            provider.Free();
            root = provider.New();
            int address = root.getThisAddress();
            root.setValue('+');
            TestValueObject left = provider.NewInstance();
            root.setLeft(left);
            left.setValue(1);
            TestValueObject right = root.getAllocRight();
            System.out.println("right:" + right.getThisAddress());
            System.out.println("right:" + root.getRight().thisAddress);
            right.setValue(2);
            System.out.println(root.getRight().getValue());
            right.getAllocRight().getAllocRight().getAllocRight().getAllocRight().setValue(99999);
            System.out.println("----------------");

            System.out.println(root.getValue());
            System.out.println(root.getLeft().getValue());
            System.out.println(root.getAllocRight().getValue());
            System.out.println(root.getRight().getRight().getRight().getRight().getRight().getValue());

            System.out.println(right.getAllocRight().getAllocRight().getAllocRight().getAllocRight().getValue());
            System.out.println("====================================================");
            provider.Free();
            //  System.out.println( byteStore.toString());
            root = null;
            root = provider.New(address);
            System.out.println(root.getValue());
            System.out.println(root.getLeft().getValue());
            System.out.println(root.getRight().getValue());
            System.out.println(root.getRight().getRight().getRight().getRight().getRight().getValue());
        }
    }
}
