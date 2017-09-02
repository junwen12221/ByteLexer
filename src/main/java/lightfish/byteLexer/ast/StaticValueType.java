package lightfish.byteLexer.ast;

import java.nio.ByteBuffer;
import java.util.Arrays;

/**
 * Created by jamie on 2017/8/29.
 */
public class StaticValueType {
    int thisAddress;
    final static int size = 4 * 3;
    static ByteStore byteStore;
    // int value;
    static int allocCount = 0;
    static final StaticValueType[] valueTypeCollection = new StaticValueType[8];

    static {
        Arrays.setAll(valueTypeCollection, (i) -> new StaticValueType());
    }

    public static void end() {
        allocCount = 0;
    }

    public final static int NIL = -1;

    private static StaticValueType newINSTANCE() {
        return valueTypeCollection[allocCount++];
    }

    public static int getLeft(int thisAddress) {
        final int pos = thisAddress + 4;
        return getRef(pos);
    }

    public static int getRight(int thisAddress) {
        final int pos = thisAddress + 8;
        return getRef(pos);
    }

    public static int getRef(int pos) {
        int var;
        if ((var = byteStore.getAddress(pos)) == 0) {
            var = byteStore.malloc(size);
            byteStore.setAddress(pos, var);
        }
        return var;
    }

//
//    public void offHeap() {
//        offHeapHelper(this);
//        if (this.leftAddress != NIL) {
//            offHeapHelper(new ValueType().setThisAddress(leftAddress));
//        }
//        if (this.rightAddress != NIL) {
//            offHeapHelper(new ValueType().setThisAddress(rightAddress));
//        }
//    }

//    private static void offHeapHelper(ValueType valueType) {
//        byteStore.setAddress(valueType.thisAddress + 4, valueType.leftAddress);
//        byteStore.setAddress(valueType.thisAddress + 8, valueType.rightAddress);
//
//    }


    public int getThisAddress() {
        return thisAddress;
    }

    public StaticValueType setThisAddress(int thisAddress) {
        this.thisAddress = thisAddress;
        return this;
    }

    public ByteStore getByteStore() {
        return byteStore;
    }

    public void setByteStore(ByteStore byteStore) {
        this.byteStore = byteStore;
        thisAddress = byteStore.malloc(size);
    }

    public static void setValue(int thisAddress, int value) {
        byteStore.setInt(thisAddress, value);
    }

    public static int getValue(int thisAddress) {
        return byteStore.getInt(thisAddress);
    }

    public static StaticValueType init(ByteStore byteStore) {
        byteStore.setBytes(ByteBuffer.allocateDirect(256));
        byteStore.start();
        StaticValueType root = new StaticValueType();
        byteStore.start();
        root.setByteStore(byteStore);
        return root;
    }

    public static void main(String[] args) {
        ByteStore byteStore = new ByteStore();
        init(byteStore);
        ///////////////////////////////////
        for (int i = 0; i < 7; i++) {
            byteStore.end();
            int address = byteStore.malloc(12);
            setValue(address, '+');
            int left = getLeft(address);
            setValue(left, 1);
            int right = getRight(address);
            setValue(right, 2);
            setValue(getRight(getRight(getRight(getRight(right)))), 99999);
            System.out.println(getValue(address));
            System.out.println(getValue(getLeft(address)));
            System.out.println(getValue(getRight(address)));
            System.out.println(getValue(getRight(getRight(getRight(getRight(right))))));
        }
    }
}
