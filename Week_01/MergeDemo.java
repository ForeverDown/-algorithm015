package week1;
import java.util.Arrays;

public class MergeDemo {
    public static void main(String[] args) {
        int nums1[] = new int[] {1, 2, 3, 0, 0, 0};
        int nums2[] = new int[] {4, 5, 6};
        merge(nums1, 3, nums2, 3);
        System.out.println(Arrays.toString(nums1));

    }

    /*
    自行编写
    直接从对应位置开始赋值然后排序
    时间复杂度O(n)
     */
//    public static void merge(int[] nums1, int m, int[] nums2, int n) {
//        for (int i = 0; i < n; ++ i) {
//            nums1[m] = nums2[i];
//            m ++;
//        }
//        Arrays.sort(nums1);
//    }

    /*
    来自题解
    从后向前数组遍历
    来自作者：
    因为 nums1 的空间都集中在后面，所以从后向前处理排序的数据会更好，节省空间，一边遍历一边将值填充进去
    设置指针 len1 和 len2 分别指向 nums1 和 nums2 的有数字尾部，从尾部值开始比较遍历，
    同时设置指针 len 指向 nums1 的最末尾，每次遍历比较值大小之后，则进行填充
    当 len1<0 时遍历结束，此时 nums2 中海油数据未拷贝完全，将其直接拷贝到 nums1 的前面，最后得到结果数组
    时间复杂度：O(m+n)
     */
    public static  void merge(int[] nums1, int m, int[] nums2, int n) {
        int len1 = m - 1;
        int len2 = n - 1;
        int len = m + n - 1;
        while(len1 >= 0 && len2 >= 0) {
            // 注意--符号在后面，表示先进行计算再减1，这种缩写缩短了代码
            if (nums1[len1] > nums2[len2]) {
                nums1[len --] = nums1[len1 --];
            } else {
                nums1[len --] = nums2[len2 --];
            }
        }
        // 表示将nums2数组从下标0位置开始，拷贝到nums1数组中，从下标0位置开始，长度为len2+1
        System.arraycopy(nums2, 0, nums1, 0, len2 + 1);

    }





}
