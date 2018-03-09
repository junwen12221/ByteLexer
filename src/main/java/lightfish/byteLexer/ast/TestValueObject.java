//
//package lightfish.byteLexer.ast;
//
//import java.nio.ByteBuffer;
//
///**
// * Created by jamie on 2017/9/1.
// */
//public class TestValueObject extends ValueObject<TestValueObject> implements Test {
//
//public byte getByte(){return getValueType().getByte(thisAddress);}
//public short getShort(){return getValueType().getShort(thisAddress);}
//public char getChar(){return getValueType().getChar(thisAddress);}
//public int getInt(){return getValueType().getInt(thisAddress);}
//public long getLong(){return getValueType().getLong(thisAddress);}
//public float getFloat(){return getValueType().getFloat(thisAddress);}
//public double getDouble(){return getValueType().getDouble(thisAddress);}
//public int getValue(){return getValueType().getValue(thisAddress);}
//
//public void setByte(byte value) {getValueType().setByte(thisAddress,value);}
//public void setShort(short value) {getValueType().setShort(thisAddress,value);}
//public void setChar(char value) {getValueType().setChar(thisAddress,value);}
//public void setInt(int value) {getValueType().setInt(thisAddress,value);}
//public void setLong(long value) {getValueType().setLong(thisAddress,value);}
//public void setFloat(float value) {getValueType().setFloat(thisAddress,value);}
//public void setDouble(double value) {getValueType().setDouble(thisAddress,value);}
//public void setValue(int value) {getValueType().setValue(thisAddress,value);}
//
//
//
//    ObjectProvider<TestValueObject>  testProvider;
//  public  ObjectProvider<TestValueObject> getTestProvider(){return testProvider;}
//  public  void setTestProvider(ObjectProvider<TestValueObject> p){testProvider=p;}
//
//
//
//    public TestValueObject getLeft() {
//        TestValueObject object = testProvider.NewInstance();
//        object.setThisAddress(getValueType().getLeft(thisAddress));
//        return object;
//    }
//
//    public TestValueObject getAllocLeftIfNull() {
//        TestValueObject object = testProvider.NewInstance();
//        object.setThisAddress(getValueType().getAllocLeftIfNull(thisAddress));
//        return object;
//    }
//
//    public void setLeft(Test object) {
//        getValueType().setLeft(thisAddress, ((TestValueObject) object).getThisAddress());
//    }
//    public void setLeft(TestValueObject object) {
//        getValueType().setLeft(thisAddress,object.getThisAddress());
//    }
//    public int getLeftAddress() {
//        return getValueType().getLeft(thisAddress);
//    }
//    public void setLeftAddress(int value) {
//        getValueType().setRight(thisAddress,value);
//    }
//
//    public TestValueObject getRight() {
//        TestValueObject object = testProvider.NewInstance();
//        object.setThisAddress(getValueType().getRight(thisAddress));
//        return object;
//    }
//
//    public TestValueObject getAllocRightIfNull() {
//        TestValueObject object = testProvider.NewInstance();
//        object.setThisAddress(getValueType().getAllocRightIfNull(thisAddress));
//        return object;
//    }
//
//    public void setRight(Test object) {
//        getValueType().setRight(thisAddress, ((TestValueObject) object).getThisAddress());
//    }
//    public void setRight(TestValueObject object) {
//        getValueType().setRight(thisAddress,object.getThisAddress());
//    }
//    public int getRightAddress() {
//        return getValueType().getRight(thisAddress);
//    }
//    public void setRightAddress(int value) {
//        getValueType().setRight(thisAddress,value);
//    }
//    public static void main(String[] args)throws Exception {
//        ByteStore byteStore=new ByteStore();
//        byteStore.setBytes(ByteBuffer.allocate(8192));
//        TestValueType valueType=new TestValueType(byteStore);
//        ObjectProviderArray<TestValueObject, TestValueType> provider = new ObjectProviderArray<>();
//        provider.init(64, TestValueObject.class, valueType,(e,f)->{e.setTestProvider(f);e.setValueType(valueType);});
//        ///////////////////////////////////
//        TestValueObject root;
//        for (int i = 0; i < 1; i++) {
//            byteStore.end();
//            provider.Free();
//            root = provider.New();
//            int address = root.getThisAddress();
//            root.setValue('+');
//            TestValueObject left = provider.New();
//            root.setLeft(left);
//            left.setValue(1);
//            TestValueObject right = root.getAllocRightIfNull();
//            System.out.println("right:" + right.getThisAddress());
//            System.out.println("right:" + root.getRight().thisAddress);
//            right.setValue(2);
//            System.out.println(root.getRight().getValue());
//            right.getAllocRightIfNull().getAllocRightIfNull().getAllocRightIfNull().getAllocRightIfNull().setValue(99999);
//            System.out.println("----------------");
//
//            System.out.println(root.getValue());
//            System.out.println(root.getLeft().getValue());
//            System.out.println(root.getAllocRightIfNull().getValue());
//            System.out.println(root.getRight().getRight().getRight().getRight().getRight().getValue());
//
//            System.out.println(right.getAllocRightIfNull().getAllocRightIfNull().getAllocRightIfNull().getAllocRightIfNull().getValue());
//            System.out.println("====================================================");
//            provider.Free();
//            //  System.out.println( byteStore.toString());
//            root = null;
//            root = provider.New(address);
//            System.out.println(root.getValue());
//            System.out.println(root.getLeft().getValue());
//            System.out.println(root.getRight().getValue());
//            System.out.println(root.getRight().getRight().getRight().getRight().getRight().getValue());
//        }
//    }
//
//
//}
