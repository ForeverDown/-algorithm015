package week7;

import java.util.*;

public class LabberLength {
    /*
    广度优先遍历解法：来自题解，理解后默写
    首先使用哈希表来保存wordList，这样一来能够有效的缩短
    查询时间，同时建立一个哈希表来标记使用过的单词。
    然后直接套用bfs模板进行搜索，搜索类型为String
     */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        //建立哈希表，存放wordList，方便查询每一个单词
        Set<String> wordSet = new HashSet<>(wordList);
        //若wordSet为空或者没有endWord，返回0
        if (wordSet.size() == 0 || !wordSet.contains(endWord)) return 0;
        wordSet.remove(beginWord);
        //建立队列，准备用于bfs搜索
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        //建立哈希表，用于标记用过的单词
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);
        //记录步骤
        int result = 1;
        //进行bfs
        while (!queue.isEmpty()) {
            int currentSize = queue.size();
            //遍历当前队列中的单词
            for (int i = 0; i < currentSize; i ++) {
                String currentWord = queue.poll();
                //建立一个方法判断，如果当前词currentWord能够变换一个字母与endWord相同
                //返回result + 1
                if (ChangeOneLetterCanEqual(currentWord, endWord, queue, visited, wordSet)) {
                    return result + 1;
                }
            }
            result ++;
        }
        return 0;
    }

    private boolean ChangeOneLetterCanEqual(String currentWord, String endWord,
                                            Queue<String> queue, Set<String> visited,
                                            Set<String> wordSet) {
        //先将currentWord拆分成字符
        char[] charArray = currentWord.toCharArray();
        //第一层循环遍历整个单词
        for (int i = 0; i < endWord.length(); i ++) {
            char currentChar = charArray[i];//获取当前字母
            //第二层循环替换字母
            for (char k = 'a'; k < 'z'; k++) {
                if (k == currentChar) continue;
                charArray[i] = k;//替换字母
                String nextWord = String.valueOf(charArray);//字符数组拼成字符串
                //如果wordList中含有nextWord
                if (wordSet.contains(nextWord)) {
                    //达成目的，返回真
                    if (nextWord.equals(endWord)) return true;
                    //若该单词未被使用过
                    if (!visited.contains(nextWord)) {
                        queue.add(nextWord);//加入队列
                        visited.add(nextWord);//标记该单词
                    }
                }
            }
            //恢复单词
            charArray[i] = currentChar;
        }
        return false;
    }


}
class BFSExample {
//
//    广度优先遍历模板，队列实现
//
//    public void BFS(TreeNode head) {
//        if (head == null) {
//            return;
//        }
//        Queue<TreeNode> q = new LinkedList<>();
//        q.add(head);
//        while (!q.isEmpty()) {
//            TreeNode node = q.poll();
//            System.out.println(node.val + " ");//打印节点值
//            if (node.left != null) q.add(node.left);
//            if (node.right != null) q.add(node.right);
//        }
//    }
}