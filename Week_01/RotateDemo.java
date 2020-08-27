package week1;

import java.util.Arrays;

public class RotateDemo {
    public static void main(String[] args) {
        int[] nums = new int[] {1, 2, 3, 4, 5, 6, 7};
        rotate(nums, 3);
        System.out.println(Arrays.toString(nums));

    }

    /*
    暴力解法，直接使用嵌套循环调换数组中数的位置
    自行编写
    时间复杂度O(n*k)
    空间复杂度O(1)，没有建立额外的数组
     */
    public static void rotate(int[] nums, int k) {
        for (int i = 0; i < k; ++ i) {//第一层循环控制需要旋转的次数
            int LastNum = nums[nums.length - 1];//保留数组的最后一位
            for (int j = nums.length - 1; j > 0; -- j) {//指针从最后一位向前遍历不到第一位
                nums[j] = nums[j - 1];//赋值
            }
            nums[0] = LastNum;//最后一位赋值给第一位
        }
    }

    /*
    使用额外的数组，用i表示指针，用(i + k) % length来获取旋转后元素应该在的位置，然后再赋值回原数组
    来自题解
    时间复杂度O(n)
    空间复杂度O(n)，建立了额外的数组，属于空间换时间
     */
//    public static void rotate(int[] nums, int k) {
//        int[] a = new int[nums.length];
//        for (int i = 0; i < nums.length; ++ i) {//简单遍历整个数组
//            a[(i + k) % nums.length] = nums[i];//赋值到对应位置
//        }
//        for (int i = 0; i < nums.length; ++ i) {//简单遍历
//            nums[i] = a[i];//重载原来的数组
//        }
//    }

}
