package lightfish.byteLexer;


import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TrieTree {
    static Map<String, Integer> priority = new HashMap<>();

    public TrieTree(char... prioritys) {
        priority.clear();
        for (int i = 0; i < prioritys.length; i++) {
            priority.put(String.valueOf(prioritys[i]).toLowerCase(), i);
        }
        root = new Node();
    }
    public TrieTree(List<String> read) {
        priority.clear();
        for (int i = 0; i < read.size(); i++) {
            priority.put(read.get(i).toLowerCase(), i);
        }
        root = new Node();
    }

    private class Node {
        private int prefixNum;// 以该字符串为前缀的字符数
        private Node[] childNodes;
        private boolean isLeaf;// 是否为单词
        private int dumplicateNum;// 该字符串重复出现的次数(单词重复出现次数)

        public Node() {
            prefixNum = 0;
            isLeaf = false;
            dumplicateNum = 0;
            childNodes = new Node[1024];
        }

        public String toIfElse(int i) {
            List<String> args = new ArrayList<>();
            args.add(String.valueOf(integerToChar(i)));
            toIfElse(this, args);
            return Tool.genIfAnd(String.format("System.out.println(\"%s\");", args.toString()), "  x = Tool.getId(start, x, size, this.reader);", args.toArray(new String[args.size()]))
                    .concat("findNextToken();return x;");
        }

        List<Integer> getNodes() {
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < childNodes.length; i++) {
                if (childNodes[i] != null) {
                    list.add(i);
                }
            }
            return list;
        }

        public void toIfElse(Node node, List<String> args) {
            int count = 0;
            for (int i = 0; i < this.childNodes.length; i++) {
                if (node.childNodes[i] != null) {
                    args.add(String.valueOf((char) (i)));
                    toIfElse(node.childNodes[i], args);
                    count++;
                    break;
                }
            }

        }

        char integerToChar(int i) {
            return (char) (i);
        }

        /**
         * 生成ParseNode的各解析子路径的代码
         *
         * @param string
         * @return
         */
        public String toNodeChildCode(String string, StringBuilder funString) {
            List<Integer> list = getNodes();
            int size = list.size();
            /**
             * 根据同一个位置需要匹配的字符数量来决定生成if还是switch,当是标识符最后一个字符时,也是if
             */
            switch (size) {
                case 0:
                    char c = string.length() == 0 ? 0 : string.charAt(0);
                    String ret;
                    //最后的匹配的if只会是剩下一个,不会是两个,如果后面的字符是空白符号,那就是匹配上标志符,否则就不是
                    if (('A' <= c && c <= 'Z') || ('a' <= c && c <= 'z')) {
                        ret = "if(x<size){c=cc();if (isBlank(c)){t=H." + string.toUpperCase() + ";return x;}}else{return x;}";
                    } else {
                        ret = "t=H." + Ascll.shiftAscll(string,false).toUpperCase() + ";++x;return x;";
                    }
                    return ret;
                case 1:
                case 2:
                case 3:
                case 4: {
                    //生成switch
                    Map<String, String> res = new HashMap<>(list.size());
                    for (Integer i : list) {
                        String str = String.valueOf("'" + (char) (i.intValue()) + "'");
                        res.put(str, childNodes[i].toNodeChildCodeDown(string + String.valueOf((char) (i.intValue()))));
                    }
                    String ifelse = "if(x<size){c" + "=cc();" + res.entrySet().stream()
                            .map((entry) -> "if(c==" + entry.getKey() + "){" + entry.getValue() + "}")
                            .collect(Collectors.joining());
                    if (priority.containsKey(string)){
                        String name =Ascll.shiftAscll(string,false);
                        return ifelse.concat(this.isLeaf ? "t=H." + name.toUpperCase() + ";return x;}return x;" : "endId(c);return x;}return x;");
                    }else {
                        return ifelse.concat(this.isLeaf ? "return x;}return x;" : "endId(c);return x;}return x;");
                    }
                }
                default:
                    Map<String, String> res = new HashMap<>(list.size());
                    for (Integer i : list) {
                        String vaule = childNodes[i].toNodeChildCodeDown(string + String.valueOf((char) (i.intValue())));
                        String name = String.valueOf("'" + (char) (i.intValue()) + "'");
                        String funName = Ascll.shiftAscll(String.valueOf((char) (i.intValue())),false);
                        String fun = String.format("private int %s(){int c;%s}", funName, vaule);
                        funString.append(fun);
                        res.put(name, String.format("{return %s();}", funName));
                    }
                    return genSwitchAdd1(res,                   priority.containsKey(string)?string:null);
            }
        }

        /**
         * 生成ParseNode的各解析子路径的代码
         *
         * @param string
         * @return
         */
        public String toNodeChildCodeDown(String string) {
            List<Integer> list = getNodes();
            int size = list.size();
            /**
             * 根据同一个位置需要匹配的字符数量来决定生成if还是switch,当是标识符最后一个字符时,也是if
             */
            switch (size) {
                case 0:
                    char c = string.length() == 0 ? 0 : string.charAt(0);
                    String ret;
                    //最后的匹配的if只会是剩下一个,不会是两个,如果后面的字符是空白符号,那就是匹配上标志符,否则就不是
                    if (('A' <= c && c <= 'Z') || ('a' <= c && c <= 'z')) {
                        ret = "return endBlank(H." + string.toUpperCase() + ");";
                    } else {
                        ret = "t=H." + Ascll.shiftAscll(string,true) + ";++x;return x;";
                    }
                    return ret;
                case 1:
                case 2:
                case 3:
                case 4: {
                    //生成switch
                    Map<String, String> res = new HashMap<>(list.size());
                    for (Integer i : list) {
                        String str = String.valueOf("'" + (char) (i.intValue()) + "'");
                        res.put(str, childNodes[i].toNodeChildCodeDown(string + String.valueOf((char) (i.intValue()))));
                    }
                    String ifelse = "if(x<size){c" + "=cc();" + res.entrySet().stream()
                            .map((entry) -> "if(c==" + entry.getKey() + "){" + entry.getValue() + "}")
                            .collect(Collectors.joining());
                    if (priority.containsKey(string)) {
                        String name = Ascll.shiftAscll(string, false);
                        return ifelse.concat(this.isLeaf ? "t=H." + name.toUpperCase() + ";return x;}return x;" : "endId(c);return x;}return x;");
                    } else {
                        return ifelse.concat(this.isLeaf ? "return x;}return x;" : "endId(c);return x;}return x;");
                    }
                }
                default:
                    Map<String, String> res = new HashMap<>(list.size());
                    for (Integer i : list) {
                        String str = String.valueOf("'" + (char) (i.intValue()) + "'");
                        String value = childNodes[i].toNodeChildCodeDown(string + String.valueOf((char) (i.intValue())));
                        res.put(str, value);
                    }
                    return genSwitchAdd1(res,                   priority.containsKey(string)?string:null);
            }
        }

        /**
         * 生成各AParseNode的顶层代码
         *
         * @return
         * @throws IOException
         */
        public String toNodeCode() throws IOException {
            List<Integer> list = getNodes();
            int size = list.size();
            switch (size) {
                case 0:
                    return "";
                case 1:
                case 2:
                case 3:
                case 4: {
//                    Map<String, String> res = new HashMap<>(list.size());
//                    for (Integer i : list) {
//                        String str = String.valueOf("'" + (char) (i.intValue()) + "'");
//                        res.put(str, childNodes[i].toNodeChildCode(String.valueOf((char) (i.intValue()))));
//                    }
//                    return "{c=reader[x];" + res.entrySet().stream().map((entry) -> "if(c" + "==" + entry.getKey() + "){" + entry.getValue() + "" + "}").collect(Collectors.joining()).concat("endId();return x;}");
                }
                default:
                    Map<String, String[]> res = new HashMap<>(list.size());
                    for (Integer i : list) {
                        String str = String.valueOf("" + (char) (i.intValue()) + "");
                        StringBuilder stringBuilder = new StringBuilder();
                        res.put(str, new String[]{childNodes[i].toNodeChildCode(String.valueOf((char) (i.intValue())), stringBuilder), stringBuilder.toString()});
                    }
                    String res1 = genSwitch(res);
                    return res1;
            }
        }
    }

    Map<String, String> funName = new HashMap<>();

    public Map<String, String> getFunName() {
        return funName;
    }

    /**
     * 顶部switch,生成各种字符节点例如AParseNode和顶层的Lexer
     *
     * @param map
     * @return
     */
    String genSwitch(Map<String, String[]> map) throws IOException {
        String body;
        Set<Entry<String, String[]>> kv = map.entrySet();
        Path basePath = Paths.get(Main.projectPath + "/src/test/java/lightfish/byteLexer");
        Iterator<Entry<String, String[]>> iterator = kv.iterator();
        while (iterator.hasNext()) {
            Entry<String, String[]> o = iterator.next();
            String className = Ascll.shiftAscll(o.getKey().toUpperCase(),false) + "ParseNode";
            String[] value = o.getValue();
            String ss = String.format("package lightfish.byteLexer;\nclass %s extends P{public  int parse(){int c;%s};%s}", className, value[0], value[1] == null ? "" : value[1]);
            System.out.println(ss);
            Path p = basePath.resolve(className + ".java");
            if (Files.exists(p)) {
                Files.delete(p);
            }
            Files.write(p, ss.getBytes(StandardCharsets.UTF_8), StandardOpenOption.CREATE);
            funName.put(o.getKey(), className);
        }
        return "switch (c=reader[x]){"
                .concat(funName.entrySet().stream()
                        .map((e) -> {
                            String down = e.getValue().toLowerCase();
                            String res = String.format("%ncase '%s' :{%s.init(reader,x);x=%s.parse();t=%s.t;return x;}", e.getKey(), down, down, down);
                            return res;
                        })
                        .collect(Collectors.joining())).concat("\ndefault:id(c);return x;")
                .concat("\n}");
    }

    static String genSwitchAdd1(Map<String, String> map, String name) {
        String body = "switch (c=cc()){"
                .concat(map.entrySet().stream()
                        .map((e) -> String.format("%ncase %s :{%s}", e.getKey(), e.getValue()))
                        .collect(Collectors.joining()));

        String res = body.concat("\ndefault:");
        if (name != null) {
            return res + "if (isBlank(c)){t=H." + name.toUpperCase() + ";return x;}else{endId(c);return x;}".concat("\n}");
        } else {
            return res + "endId(c);return x;".concat("\n}");
        }
    }

    static String genIfAnd(String body, String... args) {
        return Stream.of(args).collect(Collectors.joining("if(", "&&", ")")).concat("{").concat(body).concat("}");
    }

    private Node root;// 根节点

    public TrieTree() {
        root = new Node();

    }

    public void insert(String word) {
        insert(this.root, word);
    }


    public void insert(Node root, String word) {
        word = word.toLowerCase();
        char[] chars = word.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            try {
                int index = chars[i] - 0;// 对应的下标
                if (index == -2) {
                    System.out.println("");
                }
                if (root.childNodes[index] == null) {
                    root.childNodes[index] = new Node();
                }
                root.childNodes[index].prefixNum++;
                if (i == chars.length - 1) {
                    root.childNodes[index].isLeaf = true;// 单词
                    root.childNodes[index].dumplicateNum++;// 该单词出现的个数
                }
                root = root.childNodes[index];
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }

    private HashMap<String, Integer> getPrefixString(Node root, String prefixStr) {
        prefixStr = prefixStr.toLowerCase();
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        char[] prefixs = prefixStr.toCharArray();
        for (int i = 0; i < prefixs.length; i++) {
            int index = prefixs[i] - 0;
            if (root.childNodes[index] != null) {
                root = root.childNodes[index];
            } else {
                return null;
            }
        }
        dfs(root, prefixStr, map, false);
        return map;

    }

    public HashMap<String, Integer> getPrefixString(String prefixStr) {

        return getPrefixString(root, prefixStr);

    }


    /**
     * 深度优先遍历
     * 驱动整个生成过程
     *
     * @param root :根节点
     * @param map
     */
    private boolean dfs(Node root, String prefixs, HashMap<String, Integer> map, boolean tryFlag) {
        if (root.isLeaf) {
            map.put(prefixs, root.dumplicateNum);
        }
        Node[] nodes = root.childNodes;
        List<Integer> chi = new ArrayList<>();
        for (int i = 0; i < nodes.length; i++) {
            if (nodes[i] != null) {
                chi.add(i);
            }
        }
        Map<String, String> res = new HashMap<>(chi.size());
        for (int k = 0; k < chi.size(); k++) {
            int i = chi.get(k);
            char c = (char) (i);
            String tempStr = prefixs + c;
            if (dfs(root.childNodes[i], tempStr, map, true)) {
                res.put("'" + c + "'", root.toIfElse(i));
            } else {
                res.put(String.valueOf("'" + c + "'"), root.childNodes[i].toString());
            }
        }
        if (!tryFlag) {
            try {
                //  System.out.println(genSwitch(res));
            } catch (Exception e) {
                e.printStackTrace();
            }
            ;
        }
        return chi.size() == 1;
    }

    /**
     * 遍历所有的字符串
     *
     * @return
     */
    public boolean dfs(HashMap<String, Integer> map) {
        return dfs(this.root, "", map, false);
    }

    /**
     * 删除节点
     *
     * @param word
     */
    public boolean delete(String word) {
        // 不存在该单词则删除
        Node p = root;
        if (!searchWord(word)) {
            return false;
        }
        word = word.toLowerCase();
        char[] chars = word.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int index = chars[i] - 0;
            Node[] nodes = p.childNodes;
            if (nodes[index].prefixNum == 1) {
                nodes[index] = null;
                return true;
            } else {
                nodes[index].prefixNum--;
                p = nodes[index];
            }
        }
        if (p.dumplicateNum == 1) {
            p.isLeaf = false;
        }
        p.dumplicateNum--;
        return true;

    }

    /**
     * @param root
     * @param word
     * @return
     */
    private boolean searchWord(Node root, String word) {
        if (root == null) {
            return false;
        }
        word = word.toLowerCase();
        char[] chars = word.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            int index = chars[i] - 0;
            Node[] nodes = root.childNodes;
            if (nodes[index] != null) {
                root = nodes[index];
            } else {
                return false;
            }
        }
        if (!root.isLeaf) {
            return false;
        }
        return true;

    }

    /**
     * 最顶层的生成字符串
     *
     * @return
     */
    @Override
    public String toString() {
        try {
            return "public int parse(){jumpPassSpace();this.start=x;int c=0;if (!hasMore)return x;\n" + this.root.toNodeCode() + "\n}";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean searchWord(String word) {
        return searchWord(root, word);

    }
}