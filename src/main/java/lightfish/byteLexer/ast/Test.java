package lightfish.byteLexer.ast;

import java.io.FileWriter;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by jamie on 2017/8/30.
 */
public interface Test {
    byte getByte();

    char getChar();

    short getShort();

    int getInt();

    long getLong();

    float getFloat();

    double getDouble();

    Test getLeft();
    Test getRight();
    int getValue();
}
