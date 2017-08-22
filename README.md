# ByteLexer

##### 如何开发

在\src\main\java\lightfish\byteLexer\Main.java中的projectPath写上项目的路径

之后运行Main.main

这样就可以在根src\main\resources\sql_tokens.txt

在\src\test\java\lightfish\byteLexer生成词法分析器,

其中src\test\java\lightfish\byteLexer\NLexer.java包含了测试用的主函数main

bug:大小写解析会影响数字,这个需要生成后修改
-不生成解析,因为-涉及注释--的解析
