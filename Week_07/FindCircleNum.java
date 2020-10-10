package week7;
/*
朋友圈
 */
public class FindCircleNum {

    /*
    DFS深度优先解法：
    类似岛屿问题，由于题目规定朋友具有传递性，那么可以从
    二维矩阵中看出：
          0  1  2
    M = 0[1, 1, 0]
        1[1, 1, 0]
        2[0, 0, 1]
    这种情况下显然同学2和同学0和1没有关系，因此同岛屿问题一样，
    标记已被访问过的同学依次遍历即可，但实际可以看出同学数量是
    一维的，因此只需要建立一个一维标记数组即可。
    时间复杂度O(n^2)，因为实际上是遍历了一遍整个二维数组，所以
    复杂度如此。
     */
//    public int findCircleNum(int[][] M) {
//        boolean[] visited = new boolean[M.length];
//        int result = 0;
//        //遍历行
//        for (int i = 0; i < M.length; i ++) {
//            //若第i位同学没有被访问过
//            if (!visited[i]) {
//                dfs(M, visited, i);//进行深度（纵向）搜索该列
//                result ++;//结果自增
//            }
//        }
//        return result;
//    }
//
//    private void dfs(int[][] m, boolean[] visited, int i) {
//        //纵向搜索该列
//        for (int j = 0; j < m.length; j ++) {
//            //若第i行第j列的节点为1（第i位同学和第j位同学是朋友）且该节点没有被访问过
//            if (m[i][j] == 1 && !visited[j]) {
//                visited[j] = true;//标记该节点（同学）
//                dfs(m, visited, j);//继续向下搜索
//            }
//        }
//    }

    /*
    并查集解法：
     */
    public int findCircleNum(int[][] M) {
        if (M.length == 0 || M[0].length == 0) {
            return 0;
        }
        int len = M.length;
        //创建并查集
        UnionFind uf = new UnionFind(len);
        //二重循环遍历二维数组
        for (int i = 0; i < len; i ++) {
            for (int j = 0; j < len; j ++) {
                //如果这两个同学是朋友
                if (M[i][j] == 1) {
                    //合并集合
                    uf.union(i, j);
                }
            }
        }
        return uf.count;
    }


}

/*
并查集模板
 */
class UnionFind {
    public int count = 0;//记录大小
    private int[] parent;
    //构造时设置大小
    public UnionFind(int n) {
        this.count = n;
        this.parent = new int[count];
        //初始化数组
        for (int i = 0; i < n; i ++) {
            parent[i] = i;
        }
    }
    //查询集合领头
    public int find(int p) {
        while (p != parent[p]) {
            parent[p] = parent[parent[p]];
            p = parent[p];
        }
        return p;
    }
    //合并集合
    public void union(int p, int q) {
        //首先将p和q的领头元素找到
        int rootP = find(p);
        int rootQ = find(q);
        //如果相等则直接退出，说明已经被合并
        if (rootP == rootQ) return;
        parent[rootP] = rootQ;//将其中一个领头的指针指向另一个领头
        count --;//大小减一
    }
}

