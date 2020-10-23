package week8;

public class TotalNQueens {
    private int count = 0;
    public int totalNQueens(int n) {
        if (n < 1) return 0;
        DFS(n, 0, 0, 0, 0);
        return count;
    }

    public void DFS(int n, int row, int cols, int pie, int na) {
        if (row >= n) {
            this.count += 1;
            return;
        }
        int bits = (~(cols | pie | na)) & ((1 << n) - 1);//得到当前所有空位
        while (bits != 0) {
            int p = bits & -bits;//取得最低位的1
            bits = bits & (bits - 1);//在p位置上放入皇后
            DFS(n, row + 1, (cols | p), (pie | p) << 1, (na | p) >> 1);
        }
    }
}
