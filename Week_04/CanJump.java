package Week4;

public class CanJump {
    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4};
        boolean result = canJump(nums);
        System.out.print(result);
    }
    /*
    来自题解
    思路：贪心算法，每次只找最大的跳步次数
    若找到最大的跳步次数可以抵达数组最后则返回true
    否则返回false
     */
    public static boolean canJump(int[] nums) {
        int n = nums.length;
        int maxMove = 0;//最大步数
        for (int i = 0; i < n; i ++) {
            if (i <= maxMove) {
                maxMove = Math.max(maxMove, i + nums[i]);
            }
            if (maxMove >= n - 1) return true;
        }
        return false;
    }
}
