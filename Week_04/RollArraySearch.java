package Week4;

public class RollArraySearch {
    public static void main(String[] args) {

    }
    /*
    来自题解
    思路：使用二分查找，先判断需要找的目标在数组的哪一半，通过和第一个元素(nums[0])
    进行比较，如果大于nums[0]，说明在左半边，那就把右半边所有的数设置为inf，使得整个数组
    变为一个严格有序的数组，如果小于nums[0]，说明在右半边，那就把左半边的所有值设为-inf，
    使得整个数组变为一个严格有序的数组，再对其进行二分查找即可。
     */

    public int search (int[] nums, int target) {
        //设定左右边界
        int lo = 0, hi = nums.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (target == nums[mid]) {//找到了则输出
                return mid;
            }
            if (target >= nums[0]) {//若目标在左半边
                if (nums[mid] < nums[0]) {//而mid在右半边
                    //将mid设为inf，可以使得整个数组变为有序
                    nums[mid] = Integer.MAX_VALUE;
                }
            } else {//目标在右半边
                if (nums[mid] >= nums[0]) {//而mid在左半边
                    //将mid设为-inf，可以使得整个数组变为有序
                    nums[mid] = Integer.MIN_VALUE;
                }
            }
            if (nums[mid] < target) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return -1;
    }
}
