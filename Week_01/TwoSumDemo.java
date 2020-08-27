package week1;
import java.util.*;

public class TwoSumDemo {
    public static void main(String[] args) {
        int[] nums = new int[] {1, 3, 4, 2};
        System.out.println(Arrays.toString(twoSum(nums, 6)));

    }


    /*
    暴力解法，自行编写
    直接创建双指针遍历数组，找两数相加满足要求的
    时间复杂度O(n^2)，运行较慢
     */
//    public static int[] twoSum(int[] nums, int target) {
//        int firstNum = 0;
//        int secondNum = 0;
//        for (int i = 0; i < nums.length - 1; ++ i) {
//            for (int j = i + 1; j < nums.length; ++ j) {
//                if (nums[i] + nums[j] == target) {
//                    firstNum = i;
//                    secondNum = j;
//                }
//            }
//        }
//        if (firstNum == 0 && secondNum == 0) {
//            return null;
//        } else {
//            return new int[] {firstNum, secondNum};
//        }
//    }

    /*
    哈希表法，来自题解
    来自作者：
    由于哈希表的查找时间复杂度为O(1)，因此可以通过使用哈希表来降低时间复杂度
    key为数组nums对应下标i的值，value为下标i
    如果存在则找到了两个值，如果不存在则将当前的 (nums[i],i) 存入 map 中，继续遍历直到找到为止
    如果最终都没有结果则抛出异常
    时间复杂度为O(n)，比暴力解法降低了很多，优势是使用哈希表来查找，而不是用循环遍历来查找
     */
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; ++ i) {
            if (map.containsKey(target - nums[i])) {
                return new int[] {map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
