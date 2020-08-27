package week1;

import java.util.Arrays;

public class PlusOneDemo {
    public static void main(String[] args) {
        int[] digits = new int[] {9, 9, 9};
        int[] result = plusOne(digits);
        System.out.println(Arrays.toString(result));

    }

    /*
    自行编写
    思路：加一的唯一特殊点在于需要末尾为9的时候，从数组末尾开始向前遍历，若不为9，当前指针对应数加一即可
         若为9，则当前指针对应的数变为0
         此时没有考虑全部为9的情况，如果全部为9，那么执行完循环以后应该全部都是0
         则判断数组是否全部为0，若全部为0，新建一个长度加一的数组，头置1即可
         不全为0，直接返回
    时间复杂度为 O(n)，没有循环嵌套
     */
    public static int[] plusOne(int[] digits) {
        int len = digits.length;
        //并不是全部都为9的情况：
        for (int i = len - 1; i >= 0; --i) {//从最后一位向前遍历
            if (digits[i] != 9) {//若这一位不是9
                digits[i]++;//加一然后跳出
                break;
            } else {//若这一位是9
                digits[i] = 0;//这一位置0
            }
        }
        //若全部都是9，则进行完循环后应该全部都是0
        boolean judgeAllZero = true;
        for (int num : digits) {
            if (num != 0) {
                judgeAllZero = false;
                break;
            }
        }
        if (!judgeAllZero) {
            return digits;
        } else {
            digits = new int[len + 1];
            digits[0] = 1;
            return digits;
        }
    }

        /*
        来自题解
        思路：基本相同，但巧妙的运用return和if，有效的缩短了代码的长度
             可见语句运用的熟练度的差距，需要加深对return语句的理解以及判断的逻辑理解
             根据题解给出的例子，虽然逻辑大致相同但省略了很多if，非常值得学习
        时间复杂度 O(n) 虽然一样，运行时间也都是0ms，但这样写代码简洁很多，大幅度降低
        代码量
         */
//        public static int[] plusOne(int[] digits) {
//            for (int i = digits.length - 1; i >= 0; i--) {
//                digits[i]++;
//                digits[i] = digits[i] % 10;
//                if (digits[i] != 0) return digits;
//            }
//            digits = new int[digits.length + 1];
//            digits[0] = 1;
//            return digits;
//        }

}
