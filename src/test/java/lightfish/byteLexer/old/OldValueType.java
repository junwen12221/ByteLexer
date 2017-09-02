package lightfish.byteLexer.old;

import lightfish.byteLexer.ast.ByteStore;

import java.nio.ByteBuffer;
import java.util.Arrays;

/**
 * Created by jamie on 2017/8/29.
 */
public class OldValueType {
    int thisAddress;
    final static int size = 4 * 3;
    static ByteStore byteStore;
   // int value;
    static int allocCount = 0;
    static final OldValueType[] valueTypeCollection = new OldValueType[8];

    static {
        Arrays.setAll(valueTypeCollection, (i) -> new OldValueType());
    }

    public static void end() {
        allocCount = 0;
    }
    public final static int NIL = -1;

    private static OldValueType newINSTANCE() {
        return valueTypeCollection[allocCount++];
    }

    public OldValueType getLeft() {
        final int pos = thisAddress + 4;
        return getRef(pos);
    }

    public OldValueType getRight() {
        final int pos = thisAddress + 8;
        return getRef(pos);
    }

    public OldValueType getRef(int pos) {
        int var;
        if ((var = byteStore.getAddress(pos)) == 0) {
            var = byteStore.malloc(size);
            byteStore.setAddress(pos, var);
        }
        OldValueType valueType = newINSTANCE().setThisAddress(var);
        return valueType;
    }

//
//    public void offHeap() {
//        offHeapHelper(this);
//        if (this.leftAddress != NIL) {
//            offHeapHelper(new OldValueType().setThisAddress(leftAddress));
//        }
//        if (this.rightAddress != NIL) {
//            offHeapHelper(new OldValueType().setThisAddress(rightAddress));
//        }
//    }

//    private static void offHeapHelper(OldValueType valueType) {
//        byteStore.setAddress(valueType.thisAddress + 4, valueType.leftAddress);
//        byteStore.setAddress(valueType.thisAddress + 8, valueType.rightAddress);
//
//    }


    public int getThisAddress() {
        return thisAddress;
    }

    public OldValueType setThisAddress(int thisAddress) {
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

    public void setValue(int value) {
        byteStore.setInt(thisAddress, value);
    }

    public int getValue() {
        return byteStore.getInt(thisAddress);
    }

    public static OldValueType init(ByteStore byteStore) {
        byteStore.setBytes(ByteBuffer.allocateDirect(256));
        byteStore.start();
        OldValueType root = new OldValueType();
        byteStore.start();
        root.setByteStore(byteStore);
        return root;
    }

    public static void main(String[] args) {
        ByteStore byteStore = new ByteStore();
        OldValueType root = init(byteStore);
        ///////////////////////////////////
        for (int i = 0; i < 7; i++) {
            byteStore.end();
            root.end();
            int address = byteStore.malloc(12);
            root.setThisAddress(address);
            root.setValue('+');
            OldValueType left = root.getLeft();
            left.setValue(1);
            OldValueType right = root.getRight();
            right.setValue(2);
            right.getRight().getRight().getRight().getRight().setValue(99999);
            root.end();
            root.setThisAddress(address);
            System.out.println(root.getValue());
            System.out.println(root.getLeft().getValue());
            System.out.println(root.getRight().getValue());
            System.out.println(root.getRight().getRight().getRight().getRight().getRight().getValue());
        }
    }
}