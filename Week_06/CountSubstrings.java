package week6;

public class CountSubstrings {

    public static void main(String[] args) {

    }
    /*
    来自题解
    思路：建立一个dp数组，用来保存字符串s在下标i和j之间是否为一个回文
    此时有3中情况
    1.只有一个字符比如a，那自然是一个回文串
    2.只有2个字符比如bb，则只需判断s[i]==s[j]即可
    3.字符个数大于2比如bab，则需要判断s[i]==s[j]同时i与j之间的字符串是回文即可
    所以可以得到如下递推公式：s[i]==s[j] && (j - i < 2 || d[i + 1][j - 1])
                            子串两头相同    子串长度小于2   除去两头内部是回文串
    由此可得：
     */
    public static int countSubstrings(String s) {
        //建立dp数组，表示字符串中s[i]和s[j]之间是否为一个回文
        boolean[][] dp = new boolean[s.length()][s.length()];
        int answer = 0;//记录结果
        //第一个指针j遍历字符串
        for (int j = 0; j < s.length(); j ++) {
            //第二个指针从头开始遍历到j
            for (int i = 0; i <= j; i ++) {
                //递推公式的java代码实现
                if (s.charAt(i) == s.charAt(j) && (j - i < 2 || dp[i + 1][j - 1])) {
                    dp[i][j] = true;
                    answer ++;
                }
            }
        }
        return answer;
    }
}
