package Week3;
import java.util.*;
/*
组合
 */
public class Combine {
    public static void main(String[] args) {
        combine(4, 2);
    }
    public static List<Integer> numList = new ArrayList<>();
    public static List<List<Integer>> result = new ArrayList<>();

    public static List<List<Integer>> combine(int n, int k) {
        if (k <= 0 || n < k) {
            return result;
        }
        dfs(1, n, k);
        return result;
    }
    /*
    来自题解
     */

    //传参 i->指针
    public static void dfs(int i, int n, int k) {
        //递归结果输出
        if (numList.size() == k) {
            //打印结果
            for (int j = 0; j < numList.size(); ++ j) {
                System.out.print(numList.get(j) + " ");
            }
            System.out.println();
            result.add(numList);//记录结果
            return;
        }
        //递归数据处理
        for (int x = i; x <= n; ++ x) {
            numList.add(x);
            dfs(x + 1, n, k);//进入下一层
            numList.remove(numList.size() - 1);
        }
    }
}
