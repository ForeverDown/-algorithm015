package Week4;
/*
岛屿数量
 */
public class NumIslands {
    public static void main(String[] args) {

    }
    /*
    思路：找到1以后，计数加一，然后将所有与它相邻的1全部变为0
    意思是我已经找到了这个岛，那么把它和它相邻的1全部变为0以后（即把岛屿打掉），
    就不会再重复的找到这个岛（1）。
    使用深度优先递归来实现
     */
    public static int numIslands(char[][] grid) {
        int count = 0;//记录结果
        int n = grid.length;//行
        if (n == 0) return 0;
        int m = grid[0].length;//列
        for (int i = 0; i < n; i ++) {//遍历二维数组
            for (int j = 0; j < m; j ++) {
                //如果节点为1
                if (grid[i][j] == '1') {
                    DFSMaking(grid, i, j);
                    count ++;
                }
            }

        }
        return count;
    }

    private static void DFSMaking(char[][] grid, int i, int j) {
        //边界条件
        if ((i < 0 || j < 0) || //i和j不能小于0
            (i >= grid.length || j >= grid[0].length) || //i和j不能越界
            grid[i][j] == '0' //当前节点为0
            ) return;//直接跳出

        grid[i][j] = '0';//当前节点置0，即将这块陆地打平为海
        DFSMaking(grid, i + 1, j);//处理当前节点的下方节点
        DFSMaking(grid, i - 1, j);//处理当前节点的上方节点
        DFSMaking(grid, i, j + 1);//处理当前节点的右方节点
        DFSMaking(grid, i, j - 1);//处理当前节点的左方节点

    }
}
