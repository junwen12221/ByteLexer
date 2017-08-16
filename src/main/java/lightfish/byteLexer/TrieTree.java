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
            priority.put(String.valueOf(prioritys[i]), i);
        }
    }


    /**
     * 前缀树节点
     *
     * @author li
     */
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

        public String toSwitch() {
            List<Integer> nodeIds = getNodes();
//            nodeIds.stream().map((i)->this.childNodes[i]..toString())
//            toIfElse(this, args);
//            return Tool.genSwitch(, "endId();return;").genIfAnd(String.format("System.out.println(\"%s\");", args.toString()), "  x = Tool.getId(start, x, size, this.reader);", args.toArray(new String[args.size()]));
//
            return "";
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


        public String toString(String string) {
            List<Integer> list = getNodes();
            int size = list.size();
            switch (size) {
                case 0:
                    char c = string.length() == 0 ? 0 : string.charAt(0);
                    String ret;
                    if (('A' <= c && c <= 'Z') || ('a' <= c && c <= 'z')) {
                        ret = "t=H." + string.toUpperCase() + ";++x;return x;";
                    } else {
                        ret = "++x;return x;";
                    }
                    return ret;
                case 1:
                case 2:
                case 3:
                case 4: {
                    Map<String, String> res = new HashMap<>(list.size());
                    for (Integer i : list) {
                        String str = String.valueOf("'" + (char) (i.intValue()) + "'");
                        res.put(str, childNodes[i].toString(string + String.valueOf((char) (i.intValue()))));
                    }
                    return "{c" + "=cc(x);" + res.entrySet().stream()
                            .map((entry) -> "if(c==" + entry.getKey() + "){" + entry.getValue() + "}")
                            .collect(Collectors.joining()).concat(this.isLeaf ? "return x;}" : "endId();return x;}");
                }
                default:
                    Map<String, String> res = new HashMap<>(list.size());
                    for (Integer i : list) {
                        String str = String.valueOf("'" + (char) (i.intValue()) + "'");
                        res.put(str, childNodes[i].toString(string + String.valueOf((char) (i.intValue()))));
                    }
                    return genSwitchAdd1(res);
            }
        }

        public String toStr() throws IOException {
            List<Integer> list = getNodes();
            int size = list.size();
            switch (size) {
                case 0:
                    return "";
                case 1:
//                    if (dfs(this.childNodes[list.get(0)], "", new HashMap<>(), true)) {
//                        int i = list.get(0);
//                        return childNodes[i].toString();
//                    }
                case 2:
                case 3:
                case 4: {
                    Map<String, String> res = new HashMap<>(list.size());
                    for (Integer i : list) {
                        String str = String.valueOf("'" + (char) (i.intValue()) + "'");
                        res.put(str, childNodes[i].toString(String.valueOf((char) (i.intValue()))));
                    }
                    return "{c=reader[x];" + res.entrySet().stream().map((entry) -> "if(c" + "==" + entry.getKey() + "){" + entry.getValue() + "" + "}").collect(Collectors.joining()).concat("endId();return x;}");
                }
                default:
                    Map<String, String> res = new HashMap<>(list.size());
                    for (Integer i : list) {
                        String str = String.valueOf("" + (char) (i.intValue()) + "");
                        res.put(str, childNodes[i].toString(String.valueOf((char) (i.intValue()))));
                    }
                    String res1 = genSwitch(res);
                    System.out.println(res1);
                    return res1;
            }
        }
    }

    Map<String, String> funName = new HashMap<>();

    public Map<String, String> getFunName() {
        return funName;
    }

    /**
     * 顶部switch
     *
     * @param map
     * @return
     */
    String genSwitch(Map<String, String> map) throws IOException {
        String body;
        Set<Entry<String, String>> kv = map.entrySet();
        Map<Boolean, List<Entry<String, String>>> data = kv.stream().collect(Collectors.partitioningBy((i) -> priority.containsKey(i)));
        List<Entry<String, String>> main = data.get(Boolean.TRUE);
        List<Entry<String, String>> other = data.get(Boolean.FALSE);
        Path basePath = Paths.get("D:\\byteLexer\\src\\test\\java\\lightfish\\byteLexer");
        Iterator<Entry<String, String>> iterator = kv.iterator();
        while (iterator.hasNext()) {
            Entry<String, String> o = iterator.next();
            String className = o.getKey().toUpperCase() + "ParseNode";
            String ss = String.format("package lightfish.byteLexer;\n class %s extends P{  public  int parse(){int c;%s}}", className, o.getValue());
            System.out.println(ss);
            Path p = basePath.resolve(className + ".java");
            if (Files.exists(p)) {
                Files.delete(p);
            }
            Files.write(p, ss.getBytes(StandardCharsets.UTF_8), StandardOpenOption.CREATE);
            funName.put(o.getKey(), className);
        }
        return "switch (reader[x]){"
                .concat(funName.entrySet().stream()
                        .map((e) -> {
                            String down = e.getValue().toLowerCase();
                            String res = String.format("%ncase '%s' :{%s.init(reader,x);x=%s.parse();t=%s.t;break;}", e.getKey(),down, down, down);
                            return res;
                        })
                        .collect(Collectors.joining())).concat("\ndefault:id();return;")
                .concat("\n}");
    }

    static String genSwitchAdd1(Map<String, String> map) {
        return "switch (cc(x)){"
                .concat(map.entrySet().stream()
                        .map((e) -> String.format("%ncase %s :{%s}", e.getKey(), e.getValue()))
                        .collect(Collectors.joining())).concat("\ndefault:endId();return x;")
                .concat("\n}");
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

    /**
     * 插入单词
     *
     * @param root
     * @param word
     */
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

    /**
     * 获取以prefixStr为前缀的字符串
     *
     * @param prefixStr
     * @return
     */
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
                System.out.println(genSwitch(res));
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

    @Override
    public String toString() {
        try {
            return "public void match(){jumpPassSpace();this.start=x;int c=0;if (!hasMore)return;\n" + this.root.toStr() + "\n}";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean searchWord(String word) {
        return searchWord(root, word);

    }

    public static void main(String[] args) {
        TrieTree trieTree = new TrieTree();
        trieTree.insert("gab");
        trieTree.insert("gb");
        trieTree.insert("gb");
        trieTree.insert("gbc");
        trieTree.insert("gbc");
        trieTree.insert("go");
        trieTree.insert("go");
        trieTree.insert("goa");
        for (Entry<String, Integer> entry : trieTree.getPrefixString("g")
                .entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
        trieTree.delete("gb");
        System.out.println("***************");
        for (Entry<String, Integer> entry : trieTree.getPrefixString("g")
                .entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

    }
}