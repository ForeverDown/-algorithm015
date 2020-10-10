package week7;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class FindWordsII {
    /*
    单词查找II
     */
    char[][] _board;
    List<String> _result = new ArrayList<>();

    public List<String> findWords(char[][] board, String[] words) {
        //构造字典树
        TrieNode1 root = new TrieNode1();
        //遍历words数组
        for (String word : words) {
            TrieNode1 node = root;
            //将每一个word拆分后储存到字典树中
            for (Character letter : word.toCharArray()) {
                if (node.children.containsKey(letter)) {
                    node = node.children.get(letter);//若已经存在该字母节点，则获取
                } else {
                    TrieNode1 newNode = new TrieNode1();//新建节点
                    node.children.put(letter, newNode);//存入字典树
                    node = newNode;
                }
            }
            node.word = word;
        }
        this._board = board;
        //遍历单元格，执行操作
        for (int row = 0; row < board.length; row ++) {
            for (int col = 0; col < board[row].length; col ++) {
                if (root.children.containsKey(board[row][col])) {
                    dfs(row, col, root);
                }
            }
        }
        return this._result;

    }

    private void dfs(int row, int col, TrieNode1 root) {
        Character letter = this._board[row][col];//获取当前字母
        TrieNode1 currentNode = root.children.get(letter);//获取当前节点
        //dfs控制数组
        int[] rowOffset = {-1, 0, 1, 0};
        int[] colOffset = {0, 1, 0, -1};
        //对应上右下左
        //递归终止条件
        if (currentNode.word != null) {
            this._result.add(currentNode.word);
            currentNode.word = null;
        }
        //防止重复，当前节点改为#
        this._board[row][col] = '#';
        //dfs遍历
        for (int i = 0; i < 4; i ++) {
            int newRow = row + rowOffset[i];//新行
            int newCol = col + colOffset[i];//新列
            //检查是否越界
            if (newRow < 0 || //行数小于0
                newRow >= this._board.length || //行数大于数组总行数
                newCol < 0 || //列数小于0
                newCol >= this._board[0].length//列数大于总列数
            ) {
                continue;
            }
            //如果包含当前节点的字符，则继续dfs
            if (currentNode.children.containsKey(this._board[newRow][newCol])) {
                dfs(newRow, newCol, currentNode);
            }
        }
        //还原当前节点的字母
        this._board[row][col] = letter;
        //增量地删除节点
        if (currentNode.children.isEmpty()) {
            root.children.remove(letter);
        }
    }
}
/*
使用HashMap构造字典树
 */
class TrieNode1 {
    HashMap<Character, TrieNode1> children = new HashMap<>();
    String word = null;
    public TrieNode1() {}
}


