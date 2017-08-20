package lightfish.byteLexer.test;


import lightfish.byteLexer.NLexer;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.profile.CompilerProfiler;
import org.openjdk.jmh.profile.GCProfiler;
import org.openjdk.jmh.profile.PausesProfiler;
import org.openjdk.jmh.profile.StackProfiler;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.Throughput)//基准测试类型
@OutputTimeUnit(TimeUnit.SECONDS)//基准测试结果的时间类型
@Warmup(iterations = 100)//预热的迭代次数
@Threads(1)//测试线程数量
@State(Scope.Thread)//该状态为每个线程独享
//度量:iterations进行测试的轮次，time每轮进行的时长，timeUnit时长单位,batchSize批次数量
@Measurement(iterations = 10, time = -1, timeUnit = TimeUnit.SECONDS, batchSize = -1)
public class SQLBenchmark {
NLexer lexer;
    byte[] srcBytes;
    String src;

    //run
    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(SQLBenchmark.class.getSimpleName())
                .forks(1)
                //     使用之前要安装hsdis
                //-XX:-TieredCompilation 关闭分层优化 -server
                //-XX:+LogCompilation  运行之后项目路径会出现按照测试顺序输出hotspot_pid<PID>.log文件,可以使用JITWatch进行分析,可以根据最后运行的结果的顺序按文件时间找到对应的hotspot_pid<PID>.log文件
                .jvmArgs("-XX:+UnlockDiagnosticVMOptions", "-XX:+LogCompilation", "-XX:+TraceClassLoading", "-XX:+PrintAssembly")
//                  .addProfiler(CompilerProfiler.class)    // report JIT compiler profiling via standard MBeans
//                  .addProfiler(GCProfiler.class)    // report GC time
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
    public void init() {
        src = "SELECT a FROM ab             , ee.ff AS f,(SELECT a FROM `schema_bb`.`tbl_bb`,(SELECT a FROM ccc AS c, `dddd`)); ".toLowerCase();
        srcBytes = src.getBytes(StandardCharsets.UTF_8);//20794
        lexer=new NLexer();
        //newSQLParser.init();
//        unsafeSQLParser = new NewUnsafeSQLParser();
//        unsafeSQLParser.init();
        System.out.println("=> init");
    }

    @Benchmark
    public void NewSqQLParserTest() { lexer.init(srcBytes);
    while (lexer.hasMore) {
        lexer.match();
    // System.out.println(lexer.readString());
//        System.out.println(lexer.getTokenType());
    }}

//    @Benchmark
//    public void UnsafeSqQLParserTest() { unsafeSQLParser.tokenize(srcBytes);}

//    @Benchmark
//    public void SQLParserTest() {
//        parser.parse(srcBytes, context);
//    }

//    @Benchmark
//    public void DruidTest() {
//        List<SQLStatement> stmtList = SQLUtils.parseStatements(src, "mysql");
//    }

//    public void DruidParse() {
//        List<SQLStatement> stmtList = SQLUtils.parseStatements(src, "mysql");
//        //解析出的独立语句的个数
//        System.out.println("size is:" + stmtList.size());
//        for (int i = 0; i < stmtList.size(); i++) {
//            SQLStatement stmt = stmtList.get(i);
//            MySqlSchemaStatVisitor visitor = new MySqlSchemaStatVisitor();
//            stmt.accept(visitor);
//            //获取表名称
//            System.out.println("Tables : " + visitor.getCurrentTable());
//            //获取操作方法名称,依赖于表名称
//            System.out.println("Manipulation : " + visitor.getTables());
//            //获取字段名称
//            System.out.println("fields : " + visitor.getColumns());
//        }
//    }
}
