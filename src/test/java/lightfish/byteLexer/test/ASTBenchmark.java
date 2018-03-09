package lightfish.byteLexer.test;


import lightfish.byteLexer.ast.ByteStore;
import lightfish.byteLexer.ast.StaticValueType;
import lightfish.byteLexer.ast.TestValueType;
import lightfish.byteLexer.old.OldValueType;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.profile.GCProfiler;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.concurrent.TimeUnit;

import static lightfish.byteLexer.ast.StaticValueType.*;

@BenchmarkMode(Mode.Throughput)//基准测试类型
@OutputTimeUnit(TimeUnit.SECONDS)//基准测试结果的时间类型
@Warmup(iterations = 20)//预热的迭代次数
@Threads(1)//测试线程数量
@State(Scope.Thread)//该状态为每个线程独享
//度量:iterations进行测试的轮次，time每轮进行的时长，timeUnit时长单位,batchSize批次数量
@Measurement(iterations = 5, time = -1, timeUnit = TimeUnit.SECONDS, batchSize = -1)
public class ASTBenchmark {
    ByteStore byteStore;
    OldValueType oldValueType;
    TestValueType testValueType;

    int addr;

    //run
    public static void main(String[] args) throws Exception {
        ASTBenchmark benchmark = new ASTBenchmark();
        benchmark.init();
        // benchmark.testValueObject();
        // benchmark.staticValueType();
        Options opt = new OptionsBuilder()
                .include(ASTBenchmark.class.getSimpleName())
                .forks(1)
                //     使用之前要安装hsdis
                //-XX:-TieredCompilation 关闭分层优化 -server
                //-XX:+LogCompilation  运行之后项目路径会出现按照测试顺序输出hotspot_pid<PID>.log文件,可以使用JITWatch进行分析,可以根据最后运行的结果的顺序按文件时间找到对应的hotspot_pid<PID>.log文件
                 .jvmArgs("-XX:+UnlockDiagnosticVMOptions", "-XX:+LogCompilation", "-XX:+TraceClassLoading", "-XX:+PrintAssembly")
//                  .addProfiler(CompilerProfiler.class)    // report JIT compiler profiling via standard MBeans
                  .addProfiler(GCProfiler.class)    // report GC time
//                 .addProfiler(StackProfiler.class) // report method stack execution profile
//                 .addProfiler(PausesProfiler.class)
                /*
                WinPerfAsmProfiler
                You must install Windows Performance Toolkit. Once installed, locate directory with xperf.exe file
                and either add it to PATH environment variable, or set it to jmh.perfasm.xperf.dir system property.
                 */
                //.addProfiler(WinPerfAsmProfiler.class)
                //更多Profiler,请看JMH介绍
                //.output("InstructionsBenchmark.log")//输出信息到文件
                .build();
        new Runner(opt).run();
    }


    @Setup
    public void init() throws Exception {
        byteStore = new ByteStore();
        oldValueType = OldValueType.init(byteStore);
        StaticValueType.init(byteStore);
        testValueType=new TestValueType(byteStore);
        ///////////////////////////////////////////
        valueType = new TestValueType(byteStore);
//        provider = new ObjectProviderArray<>();
//        provider.init(64, TestValueObject.class, valueType, (e, f) -> {
//            e.setTestProvider(f);
//            e.setValueType(valueType);
//        });
        System.out.println("=> init");
    }

    // ObjectProviderArray<TestValueObject, TestValueType> provider;
    TestValueType valueType;

    //  @Benchmark
    public void newValueType() throws Exception {
        byteStore.end();
        int address = byteStore.malloc(12);
        testValueType.setValue(address, '+');
        int left = testValueType.getAllocLeft(address);
        testValueType.setValue(left, 1);
        int right = testValueType.getAllocRight(address);
        testValueType.setValue(right, 2);
        testValueType.setValue(testValueType.getAllocRight(testValueType.getAllocRight(testValueType.getAllocRight(testValueType.getAllocRight(right)))), 99999);
        testValueType.getValue(address);
        testValueType.getValue(testValueType.getLeft(address));
        testValueType.getValue(testValueType.getRight(address));
        testValueType.getValue(testValueType.getRight(testValueType.getRight(testValueType.getRight(testValueType.getRight(right)))));

    }

//    @Benchmark
//    public void testValueObject() throws Exception {
//        byteStore.end();
//        //provider.Free();
//       // TestValueObject root = provider.New();
//        int address = root.getThisAddress();
//        root.setValue('+');
//        TestValueObject left = provider.New();
//        root.setLeft(left);
//        left.setValue(1);
//        TestValueObject right = root.getAllocRightIfNull();
//        right.setValue(2);
//        root.getRight().getValue();
//        right.getAllocRightIfNull().getAllocRightIfNull().getAllocRightIfNull().getAllocRightIfNull().setValue(99999);
//        provider.Free();
//        //  System.out.println( byteStore.toString());
//        root = null;
//        root = provider.New(address);
//        root.getValue();
//        root.getLeft().getValue();
//        root.getRight().getValue();
//        root.getRight().getRight().getRight().getRight().getRight().getValue();
    //   }

    //  @Benchmark

    public void oldValueType() throws Exception {
        byteStore.end();
        oldValueType.end();
        int address = byteStore.malloc(12);
        oldValueType.setThisAddress(address);
        oldValueType.setValue('+');
        OldValueType left = oldValueType.getLeft();
        left.setValue(1);
        OldValueType right = oldValueType.getRight();
        right.setValue(2);
        right.getRight().getRight().getRight().getRight().setValue(99999);
        oldValueType.end();
        oldValueType.setThisAddress(address);
        oldValueType.getValue();
        oldValueType.getLeft().getValue();
        oldValueType.getRight().getValue();
        oldValueType.getRight().getRight().getRight().getRight().getRight().getValue();
    }

    // @Benchmark
    public void staticValueType() throws Exception {
        byteStore.end();
        int address = byteStore.malloc(12);
        setValue(address, '+');
        int left = getLeft(address);
        setValue(left, 1);
        int right = getRight(address);
        setValue(right, 2);
        setValue(getRight(getRight(getRight(getRight(right)))), 99999);
        getValue(address);
        getValue(getLeft(address));
        getValue(getRight(address));
        getValue(getRight(getRight(getRight(getRight(right)))));
    }

    Exception exception = new Exception("lll");

    public void except() throws Exception {
        throw exception;
    }

    @Benchmark
    public void catchRun() throws Exception {
        try {
            except();
        } catch (Exception e) {

        }

    }

}
