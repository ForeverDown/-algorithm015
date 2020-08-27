package week1;
import java.util.Arrays;

public class RemoveDuplicatesDemo {
    public static void main(String[] args) {
        int[] nums = new int[] {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int result = removeDuplicates(nums);
        System.out.println(result);
        System.out.println(Arrays.toString(nums));

    }

    //自行编写
    //时间复杂度O(n)
    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        Arrays.sort(nums);//排序，排序之后重复元素必定相邻
        int index = 1;
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] != nums[i - 1]) {//若当前元素与前一个不相等
                nums[index] = nums[i];
                index ++;//指针后移
            }
        }
        return index;
    }

}
