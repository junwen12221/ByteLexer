package lightfish.byteLexer.ast;

import java.nio.ByteBuffer;
import java.util.Arrays;

/**
 * Created by jamie on 2017/8/29.
 */
public class ByteStore {
    ByteBuffer bytes;
    int position = 1;
    public static final   boolean isDebug=false;

    public ByteBuffer getBytes() {
        return bytes;
    }

    public void setBytes(ByteBuffer bytes) {
        this.bytes = bytes;
    }

    public void set(int index, byte value) {
        if(isDebug) debugSet("byte", index, value);
        bytes.put(value);
    }

   public void setAddress(int index, int value) {
       if (isDebug)debugSet("address",index,value);
        bytes.putInt(index, value);
    }

   public int  getAddress(int index) {
        int res=bytes.getInt(index);
       if (isDebug)debugGet("address",index,res);
        return res;
    }

    public  void setInt(int index, int value) {
        if (isDebug)debugSet("int",index,value);
        bytes.putInt(index, value);
    }

    public  int getInt(int index) {
        int res= bytes.getInt(index);
        if (isDebug) debugGet("int",index,res);
        return res;
    }

    public byte get(int index) {
        byte res=bytes.get(index);
        if (isDebug) debugGet("byte",index,res);
        return res;
    }

    public void setChar(int index, char value) {
        if (isDebug) debugGet("char",index,(int)value);
        bytes.putChar(value);
    }

    public char getChar(int index) {
        char res=bytes.getChar(index);
        if (isDebug) debugGet("char",index,(int)res);
        return res;
    }

    public void setShort(int index, short value) {
        if (isDebug) debugGet("short",index,value);
        bytes.putShort(value);
    }

    public short getShort(int index) {
        short res= bytes.getShort(index);
        if (isDebug) debugGet("short",index,res);
        return res;
    }

    public  void setDouble(int index, double value) {
        if (isDebug) debugSet("double",index,value);
        bytes.putDouble(value);
    }

    public double getDouble(int index) {
        double res= bytes.getDouble(index);
        if (isDebug) debugGet("double",index,res);
        return res;
    }

    public void setFloat(int index, float value) {
        if (isDebug) debugSet("float",index,value);
        bytes.putFloat(value);
    }

    public float getFloat(int index) {
        float res=bytes.getFloat(index);
        if (isDebug) debugGet("float",index,res);
        return res;
    }

    public void setLong(int index, long value) {
        if (isDebug) debugSet("long",index,value);
        bytes.putLong(value);
    }

    public long getLong(int index) {
        long res=bytes.getLong(index);
        if (isDebug) debugGet("long",index,res);
        return res;
    }

    public  void setByte(int index, byte value) {
        if (isDebug) debugSet("byte",index,value);
        bytes.put(index,value);
    }

    public byte getByte(int index) {
        byte res= bytes.get(index);
        if (isDebug) debugGet("byte",index,res);
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
       //init(res,finalPos);
        if (isDebug) debugMalloc(size,res);
        return res;
    }

    public int getRef(int pos, int size) {
        int var;
        if ((var = this.getAddress(pos)) == 0) {
            var = this.malloc(size);
            this.setAddress(pos,var);
        }
        if (isDebug) debugRef(pos,size,var);
        return var;
    }
    public void init(int start,int limit) {
        for (int i = start; i < limit; ++i) {
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
            String opString = "set";
            System.out.println(String.format("set%s(%d,%d);", type, pos, value));

    }
    private void  debugGet(String type, int pos,Number res){
            String opString = "get";
            System.out.println(String.format("get%s(%d);//res=%d%n", type, pos, res));
    }
    private void  debugRef(int pos,int size,int res){
            String opString = "get";
            System.out.println(String.format("getRef(%d,%d);//res=%d", pos, size, res));
    }
    private void  debugMalloc(int size,int pos){
            System.out.println(String.format("address=Malloc(%d);//address=%d%n",size,pos));
    }
}
