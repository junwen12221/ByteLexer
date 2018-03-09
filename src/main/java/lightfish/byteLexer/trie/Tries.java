package lightfish.byteLexer.trie;

import java.util.HashMap;

class Tries{
    Boolean isTrie ;
    HashMap<Long, Tries> children=new HashMap<Long, Tries>();
    public static boolean insertNode(long[] str,Tries head)
    {
        if(str==null||str.length==0)
            return false;
        //如果插入的单词为null 或者单词长度为0直接返回false，false代表该单词不是前缀树中某个单词的前缀，
        //或者前缀树中某个单词是该单词的前缀。
        long chs[]=str;
        int i=0;
        Tries cur=head;
        //将字符串的每个字符插入到前缀树中
        while(i<chs.length)
        {
            if(!cur.children.containsKey(chs[i]))
            {

                cur.children.put(chs[i], new Tries());
                //如果当前节点中的子树节点中不包含当前字符，新建一个子节点。
            }
            //否则复用该节点
            cur=cur.children.get(chs[i]);
            if(cur.isTrie==true)
            {
                System.out.println(" trie tree");
                return true;
                //判断前缀树中是否有字符串为当前字符串的前缀。
            }
            i++;
        }
        cur.isTrie=true;
        if(cur.children.size()>0)
        {
            System.out.println(" trie tree");
            return true;
            //判断当前字符串是否是前缀树中某个字符的前缀。
        }
        return false;
    }

    public static void main(String[] args) {
        Tries tries=new Tries();


//
//        for(int i=0;i<strs.length;i++)
//            insertNode(strs[i], tries);
    }

}