package lightfish.byteLexer.gen

import lightfish.byteLexer.ast.ByteStore
import lightfish.byteLexer.ast.TestValueType
import java.lang.Thread.yield
import java.nio.ByteBuffer
import kotlin.coroutines.experimental.buildSequence

/**
 * Created by jamie on 2017/9/3.
 */
inline operator fun ByteBuffer.invoke(block: (TestValueType) -> Unit) {
    block(TestValueType(ByteStore(this)))
}

inline operator fun TestValueType.invoke(block: (TestValueType) -> TestValueType) {
    block(this)
}

infix inline fun ByteBuffer.setValue(value: Int) = this.putInt(value)
inline fun ByteBuffer.getValue(value: Int) = this.getInt();
inline fun ByteBuffer.getLeft() = this.getInt(4 + this.position());
inline fun ByteBuffer.getRight(value: Int) = this.getInt(8 + this.position());
infix inline fun ByteBuffer.setLeft(value: Int) = this.putInt(4, value);
inline fun ByteBuffer.setRight(value: Int) = this.putInt(8, this.position());
inline fun ByteBuffer.setThisAddress(index: Int) = this.position(index);

fun main(args: Array<String>) {
    val vvv = ByteBuffer.allocate(111);
    vvv.setThisAddress(1)
    vvv setValue 1



}
fun <T> async(block: suspend () -> T){

}
suspend fun doSomething(foo: Int): Unit {
    System.out.print(foo)

}

