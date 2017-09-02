package lightfish.byteLexer.ast;

/**
 * Created by jamie on 2017/9/1.
 */
public interface ObjectProvider<T extends ValueObject> {
    <T extends ValueObject> T NewInstance();
    void Free();
     T Clone(T value);
}
