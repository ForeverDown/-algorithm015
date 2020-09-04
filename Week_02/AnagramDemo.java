package Week2;

import java.util.Arrays;
import java.util.HashMap;

public class AnagramDemo {
    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";
        System.out.println(isAnagram(s, t));

    }

    /*
    暴力解法，自行编写
    直接将两个字符串拆分成字符数组，然后直接排序
    排序后如果相等则返回true，不相等则返回false
    时间复杂度O(nlogn)
     */
//    public static boolean isAnagram(String s, String t) {
//        if (s.length() != t.length()) {
//            return false;
//        }
//        char[] charS = s.toCharArray();
//        char[] charT = t.toCharArray();
//        Arrays.sort(charS);
//        Arrays.sort(charT);
//        return Arrays.equals(charS, charT);
//    }

    /*
    哈希表法，来自题解
    思路：为了检查 t 是否是 s 的重新排列，我们可以计算两个字符串中每个字母的出现次数并进行比较。
    因为 S 和 T 都只包含 A-ZA−Z 的字母，所以一个简单的 26 位计数器表就足够了。
    我们需要两个计数器数表进行比较吗？实际上不是，因为我们可以用一个计数器表计算 s 字母的频率，
    用 t 减少计数器表中的每个字母的计数器，然后检查计数器是否回到零。
    时间复杂度O(n)
     */
    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        //创建26个字母计数器
        //记录26个字母中每一种字母出现的次数
        int[] counter = new int[26];
        //遍历字符串s
        for (int i = 0; i < s.length(); ++ i) {
            counter[s.charAt(i) - 'a'] ++;//获取一个s的字母后，就在该字母对应的位置加一
            counter[t.charAt(i) - 'a'] --;//获取一个t的字母后，就在该字母对应的位置减一
        }
        for (int count : counter) {
            if (count != 0) {
                return false;
            }
        }
        return true;
    }

}
