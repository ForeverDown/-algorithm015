package week1;
import java.util.Arrays;
public class MoveZerosDemo {
    public static void main(String[] args) {
        int nums[] = new int[] {0, 1, 0, 3, 12};
        moveZeros(nums);
        System.out.println(Arrays.toString(nums));

    }

    /*
    经过视频课讲解之后，自行编写一遍
    思路：将所有非0元素拉到前面，剩下的全部赋值为0即可
    时间复杂度 O(n)
     */
    public static void moveZeros(int[] nums) {
        int index = 0;
        for (int i = 0; i < nums.length; ++ i) {//第一层循环将所有非0值拉到数组前面
            if (nums[i] != 0) {//若不是0，则往前放
                nums[index ++] = nums[i];
            }
        }
        for (int i = index; i < nums.length; ++ i) {//从最后一个非0元素开始，其余全部赋值0
            nums[i] = 0;
        }
    }

    /*
    来自题解
    思路：第一个指针从数组头开始逐步后移
         第二个指针从第二个数开始后移，遇到非零元素与指针1所对位置的数进行调换
    时间复杂度 O(n)
     */
//    public static void moveZeros(int[] nums) {
//        if (nums == null || nums.length == 0) return;//若数组为空则跳出去
//        int j = 0;//指针2
//        for (int i = 0; i < nums.length; ++ i) {
//            if (nums[i] != 0) {//遇到不为0的元素，交换j位置的数
//                int tmp = nums[i];
//                nums[i] = nums[j];
//                nums[j++] = tmp;
//            }
//        }
//    }
}
