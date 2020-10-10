package week7;
/*
字典树的实现
 */

public class TrieNode {
    private TrieNode[] links;

    private final int R = 26;

    private boolean isEnd;

    public TrieNode() {
        links = new TrieNode[R];
    }

    //判断是否包含键
    public boolean containsKey(char ch) {
        return links[ch - 'a'] != null;
    }
    //获取当前键
    public TrieNode get(char ch) {
        return links[ch - 'a'];
    }
    //创建一个键
    public void put(char ch, TrieNode node) {
        links[ch - 'a'] = node;
    }
    //控制结束符
    public void setEnd() {
        isEnd = true;
    }
    public boolean getEnd() {
        return isEnd;
    }
}

class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    //插入单词
    public void insert(String word) {
        TrieNode node = root;
        //遍历单词
        for (int i = 0; i < word.length(); i ++) {
            char currentChar = word.charAt(i);//获取当前字符
            //若字典树中没有当前字符，则加入
            if (!node.containsKey(currentChar)) {
                node.put(currentChar, new TrieNode());
            }
            node = node.get(currentChar);
        }
        node.setEnd();//单词遍历完毕
    }

    //通过前缀或者整个单词来查找字典树
    //如果查找到了就输出
    public TrieNode searchPrefix(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i ++) {
            char currentChar = word.charAt(i);
            if (node.containsKey(currentChar)) {
                node = node.get(currentChar);
            } else {
                return null;
            }
        }
        return node;
    }

    //确认如果单词在字典树中
    public boolean search(String word) {
        TrieNode node = searchPrefix(word);
        return node != null && node.getEnd();
    }

    //查找前缀
    public boolean startWith(String prefix) {
        TrieNode node = searchPrefix(prefix);
        return node != null;
    }
}

class Demo {
    public static void main(String[] args) {
        Trie t = new Trie();
        t.insert("apple");
        System.out.println(t.search("app"));
    }
}
