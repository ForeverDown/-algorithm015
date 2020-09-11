package Week3;
import java.util.*;
/*
全排列
 */
public class Permute {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        permute(nums);
    }
    /*
    来自题解
    思路：可以看做是n个排列成一行的空格，需要从左往右依次填入题目给定的n个数，且
    每个数只能使用一次。那么就可以用穷举法来解决。和括号生成类似。

    定义递归函数 dfs 表示从左往右填到第i个位置，当前排列为integers，递归分为两个情况：
    1.如果i == nums.length，说明填完了，知道了一个可行解，把integers放入最终
    集合中，递归结束
    2.如果i < nums.length，我们要考虑在这个第i个位置要填哪一个数。根据题目要求
    我们不能填入已填过的数，因此很容易想到一个处理手段是我们定义一个标记数组vis[]
    来标记填过的数，那么在填第i个数的时候我们遍历给定的n个数，如果这个数没有被标记过
    那么我们就可以尝试填入，并将其标记，继续尝试填下一个位置，即递归dfs(i+1)。
    搜索回溯的时候要撤销这一个位置填的数和标记，并继续尝试其他没被标记过的数。

    优化：将题目给定的数组nums划分成左右两个部分，左边表示已经填过的数，右边表示
    待填入的数，我们在递归搜索的时候只需动态维护这个数组即可。
    （不需要建立标记数组vis[]）

    具体来说，加入我们已经填到第i个位置，那么nums数组中第[0, i-1]个数是已经被填过
    的，[i, n-1]是没有被填过的。我们肯定尝试用[i, n-1]中的数去尝试填第i个数，假设
    待定的数下标为j，那么填完后将第i个数和第j个数交换，就能使得在填第i+1个数时nums
    数组的[0, i]部分是已经填过的数，[i+1, n-1]为等待被填的数，回溯的时候交换回来
    就能完成撤销操作。
     */

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> integers = new ArrayList<Integer>();
        for (int num : nums) {
            integers.add(num);
        }
        dfs(nums, result, integers, 0);
        return result;

    }

    private static void dfs(int[] nums,List<List<Integer>> result, List<Integer> integers, int i) {
        if (i == nums.length) {
            result.add(new ArrayList<Integer>(integers));
            return;
        }
        for (int j = i; j < nums.length; ++ j) {
            Collections.swap(integers, i, j);
            dfs(nums, result, integers, i + 1);
            Collections.swap(integers, i, j);
        }
    }


}
