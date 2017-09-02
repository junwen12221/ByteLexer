package lightfish.byteLexer.ast;

import java.nio.ByteBuffer;
import java.util.Arrays;

/**
 * Created by jamie on 2017/8/29.
 */
public class ByteStore {
    ByteBuffer bytes;
    int position = 1;
    public  final boolean isDebug=false;

    public ByteBuffer getBytes() {
        return bytes;
    }

    public void setBytes(ByteBuffer bytes) {
        this.bytes = bytes;
    }

    public void set(int index, byte value) {
       // debugSet("byte",index,value);
        bytes.put(value);
    }

   public void setAddress(int index, int value) {
       // debugSet("address",index,value);
        bytes.putInt(index, value);
    }

   public int  getAddress(int index) {
        int res=bytes.getInt(index);
       // debugGet("address",index,res);
        return res;
    }

    public  void setInt(int index, int value) {
       // debugSet("int",index,value);
        bytes.putInt(index, value);
    }

    public  int getInt(int index) {
        int res= bytes.getInt(index);
       // debugGet("int",index,res);
        return res;
    }

    public byte get(int index) {
        return bytes.get(index);
    }

    public void setChar(int index, char value) {
       // debugGet("char",index,(int)value);
        bytes.putChar(value);
    }

    public char getChar(int index) {
        char res=bytes.getChar(index);
       // debugGet("char",index,(int)res);
        return res;
    }

    public void setShort(int index, short value) {
       // debugGet("short",index,value);
        bytes.putShort(value);
    }

    public short getShort(int index) {
        short res= bytes.getShort(index);
       // debugGet("short",index,res);
        return res;
    }

    public  void setDouble(int index, double value) {
       // debugSet("double",index,value);
        bytes.putDouble(value);
    }

    public double getDouble(int index) {
        double res= bytes.getDouble(index);
       // debugGet("double",index,res);
        return res;
    }

    public void setFloat(int index, float value) {
       // debugSet("float",index,value);
        bytes.putFloat(value);
    }

    public float getFloat(int index) {
        float res=bytes.getFloat(index);
       // debugGet("float",index,res);
        return res;
    }

    public void setLong(int index, long value) {
       // debugSet("long",index,value);
        bytes.putLong(value);
    }

    public long getLong(int index) {
        long res=bytes.getLong(index);
       // debugGet("long",index,res);
        return res;
    }

    public  void setByte(int index, byte value) {
       // debugSet("byte",index,value);
        bytes.put(value);
    }

    public byte getByte(int index) {
        byte res= bytes.get(index);
       // debugGet("byte",index,res);
        return res;
    }

     public void start() {
        position = 1;
    }

    public void end() {
        position = 1;
    }

    public int malloc(int size) {
        int res = position;
        int finalPos = res + size;
        if ((finalPos) > this.bytes.capacity()) {
            return -1;
        }
        position= finalPos;
       // init(res,size);
       // debugMalloc(size,res);
        return res;
    }

    public int getRef(int pos, int size) {
        int var;
        if ((var = this.getAddress(pos)) == 0) {
            var = this.malloc(size);
            this.setAddress(pos,var);
        }
       // debugRef(pos,size,var);
        return var;
    }
    public void init(int thisAddress,int SIZE) {
        int size = SIZE + thisAddress;
        for (int i = thisAddress; i < size; ++i) {
            this.setByte(i, (byte) 0);
        }
    }

    @Override
    public String toString() {
        return "ByteStore{" +
                "bytes=" + Arrays.toString(bytes.array()) +
                ", position=" + position +
                '}';
    }
    private static final boolean READ=true;
    private void debugSet(String type, int pos, Number value){
        if (isDebug) {
            String opString = "set";
            System.out.println(String.format("set%s(%d,%d);", type, pos, value));
        }
    }
    private void  debugGet(String type, int pos,Number res){
        if (isDebug) {
            String opString = "get";
            System.out.println(String.format("get%s(%d);//res=%d%n", type, pos, res));
        }
    }
    private void  debugRef(int pos,int size,int res){
        if (isDebug) {
            String opString = "get";
            System.out.println(String.format("getRef(%d,%d);//res=%d", pos, size, res));
        }
    }
    private void  debugMalloc(int size,int pos){
        if (isDebug){
            System.out.println(String.format("address=Malloc(%d);//address=%d%n",size,pos));
        }

    }
}
