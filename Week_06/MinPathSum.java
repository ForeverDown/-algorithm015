package week6;
/*
最小路径和
 */

public class MinPathSum {
    public static void main(String[] args) {

    }
    /*
    自行编写
    思路：参考了机器人走路和最长公共子序列的思考方式，
    先思考只有一格的情况：grid = [1]，则答案为1
    思考只有1行n列的情况：grid = [1][2]，则答案为3，值为1+2
    思考只有n行1列的情况：grid = [1]
                               [2]
                        答案为3，值为1+2
    思考只有2行2列的情况:grid = [1][2]
                              [1][1]
                       那么在右下角的1的位置取左和上的较小值
                       再加上右下角的值
    由此可得：到达某一个节点的最小值（路径）只和该节点的左和上相关。
    建立dp数组，将dp数组的第0行第0列初始化，将grid的第0行的值进行累加
    得到dp的第0行，将grid的第0列进行累加得到dp的第0列，然后每一个格子
    取其左和上的最小值，再加上grid的当前位置的值，即可得到dp的当前位置的值
    最终返回dp[m][n]即可
     */

    public static int minPathSum(int[][] grid) {
        //先进行空数组判断
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        //获取长宽
        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
        //初始化第一列和第一行
        for (int i = 1; i < m; i ++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        for (int i = 1; i < n; i ++) {
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }
        //取左和上的最小值与grid的当前值相加
        for (int i = 1; i < m; i ++) {
            for (int j = 1; j < n; j ++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[m - 1][n - 1];
    }
}
