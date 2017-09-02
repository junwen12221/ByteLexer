package lightfish.byteLexer.ast;

import java.nio.ByteBuffer;
import java.util.Arrays;

/**
 * Created by jamie on 2017/8/29.
 */
public  abstract class ValueType {
    final ByteStore byteStore;

    public ValueType(ByteStore b) {
        this.byteStore = b;
    }

    public ByteStore GetByteStore() {
        return this.byteStore;
    }


    public int Malloc() {
        return byteStore.malloc(Sizeof());
    }
    abstract int Sizeof();

}
