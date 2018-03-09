
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class DyStruct {
    interface ByteInterface {
        int alloc(int size);

        void free(int address, StructMeta structMeta);

        int getInt(int address);

        void setInt(int address, int value);

        byte getByte(int address);

        void setByte(int address, byte value);

        short getShort(int address);

        void setShort(int address, short value);

        long getLong(int address);

        void setLong(int address, long value);

        float getFloat(int address);

        void setFloat(int address, float value);

        double getDouble(int address);

        void setDouble(int address, double value);

        boolean getBoolean(int address);

        void setBoolean(int address, boolean value);

        char getChar(int address);

        void setChar(int address, char value);

        int getRef(int address);

        void setRef(int address, int value);

    }

    public enum Type {
        Int(4), Long(8), Short(4), Byte(1), Float(4), Double(8), Char(8), Ref(4);
        final int size;

        Type(int size) {
            this.size = size;
        }

        public int getSize() {
            return size;
        }
    }

    public static class StructObjectFactory {
        static ByteInterface memory = new ByteInterface() {
            @Override
            public int alloc(int size) {
                return 0;
            }

            @Override
            public void free(int address, StructMeta structMeta) {

            }

            @Override
            public int getInt(int address) {
                return 0;
            }

            @Override
            public void setInt(int address, int value) {

            }

            @Override
            public byte getByte(int address) {
                return 0;
            }

            @Override
            public void setByte(int address, byte value) {

            }

            @Override
            public short getShort(int address) {
                return 0;
            }

            @Override
            public void setShort(int address, short value) {

            }

            @Override
            public long getLong(int address) {
                return 0;
            }

            @Override
            public void setLong(int address, long value) {

            }

            @Override
            public float getFloat(int address) {
                return 0;
            }

            @Override
            public void setFloat(int address, float value) {

            }

            @Override
            public double getDouble(int address) {
                return 0;
            }

            @Override
            public void setDouble(int address, double value) {

            }

            @Override
            public boolean getBoolean(int address) {
                return false;
            }

            @Override
            public void setBoolean(int address, boolean value) {

            }

            @Override
            public char getChar(int address) {
                return 0;
            }

            @Override
            public void setChar(int address, char value) {

            }

            @Override
            public int getRef(int address) {
                return 0;
            }

            @Override
            public void setRef(int address, int value) {

            }
        };

        public static StructObject create(StructMeta meta) {
            StructObject structObject = new StructObject();
            structObject.setStructMeta(meta);
            structObject.setAddress(memory.alloc(meta.size));
            structObject.setMemory(memory);
            return structObject;
        }
    }

    public static class StructObject {
        StructMeta structMeta;
        int rc = 0;
        int address;
        ByteInterface memory;

        public int $(String name) {
            return memory.getInt(getMemberOffset(name));
        }

        public StructObject $Ref(String name) {
            StructObject structObject = new StructObject();
            structObject.setAddress(memory.getRef(getMemberOffset(name)));
            structObject.setMemory(this.memory);
            return structObject;
        }

        private int getMemberOffset(String name) {
            return structMeta.map.get(name).offset + address;
        }

        public <R> void __(String name, R value) {
            if (value instanceof Boolean) {
                memory.setBoolean(getMemberOffset(name), (Boolean) value);
            } else if (value instanceof Integer) {
                memory.setInt(getMemberOffset(name), (Integer) value);
            } else if (value instanceof Short) {
                memory.setShort(getMemberOffset(name), (Short) value);
            } else if (value instanceof Long) {
                memory.setLong(getMemberOffset(name), (Long) value);
            } else if (value instanceof Double) {
                memory.setDouble(getMemberOffset(name), (Double) value);
            } else if (value instanceof Float) {
                memory.setFloat(getMemberOffset(name), (Float) value);
            } else if (value instanceof Character) {
                memory.setChar(getMemberOffset(name), (Character) value);
            } else if (value instanceof Byte) {
                memory.setByte(getMemberOffset(name), (Byte) value);
            } else {
                StructObject v = (StructObject) value;
                StructMeta.Member member = structMeta.map.get(name);
                int start = member.offset + address;
                int size = v.structMeta.size;
                int copyAddress = v.address;
                for (int i = 0; i < size; i++) {
                    memory.setByte(start++, v.memory.getByte(copyAddress++));
                }
            }
        }

        public void _Ref(String name, StructObject value) {
            memory.setRef(getMemberOffset(name), value.address);
        }

        public void retain() {
            ++rc;
        }

        public void release() {
            --rc;
        }

        public StructMeta getStructMeta() {
            return structMeta;
        }

        public void setStructMeta(StructMeta structMeta) {
            this.structMeta = structMeta;
        }

        public int getRc() {
            return rc;
        }

        public void setRc(int rc) {
            this.rc = rc;
        }

        public ByteInterface getMemory() {
            return memory;
        }

        public void setMemory(ByteInterface memory) {
            this.memory = memory;
        }

        public int getAddress() {
            return address;
        }

        public void setAddress(int address) {
            this.address = address;
        }
    }

    public static class StructMeta {
        int size = 0;

        static class Member {
            public int offset;
            public Type type;
            public String name;

            public Member(int offset, Type type, String name) {
                this.offset = offset;
                this.type = type;
                this.name = name;
            }
        }

        Map<String, Member> map = new HashMap<>();

        public void put(String name, Type type) {
            map.put(name, new Member(size += type.size, type, name));
        }

        public void print() {
            System.out.println(map.entrySet()
                    .stream()
                    .map(Map.Entry::getValue)
                    .map((entry -> String.format("member name:%s type:%s size:%d offset:%d", entry.name, entry.type.name(), entry.type.getSize(), entry.offset)))
                    .collect(Collectors.toList()));
        }
    }

    public static class Memory {
        public static StructMeta StructBuilder(Object... map) throws Exception {
            // if ((map.length + 1) % 2 != 0) throw new Exception("名字与类型不匹配");
            StructMeta meta = new StructMeta();
            for (int i = 0; i < map.length; i += 2) {
                Object value = map[i + 1];
                String key = (String) map[i];
                if (value instanceof StructMeta) {
                    StructMeta innerStruct = (StructMeta) value;
                    meta.map.putAll(innerStruct.map.entrySet().stream().collect(Collectors.toMap(k -> key + "." + k.getKey(), Map.Entry::getValue)));
                } else {
                    meta.put(key, (Type) value);
                }
            }
            return meta;
        }
    }

    public static void main(String[] args) throws Exception {
        StructMeta subMeta = Memory.StructBuilder("a", Type.Byte);
        StructMeta meta = Memory.StructBuilder(
                "a", Type.Byte,
                "b", Type.Ref,
                "c", subMeta);
        StructObject structObject = StructObjectFactory.create(meta);


        int f = structObject.$("a");
        structObject.__("c.a", 1);
        structObject._Ref("c.a", StructObjectFactory.create(subMeta));
        structObject.$Ref("c.a");
        int f1 = structObject.$("c.a");

    }


}
