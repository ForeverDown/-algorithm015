package week8;
/*
1的个数
 */
public class HammingWeightAndPowerOfTwo {
    public int hammingWeight(int n) {
        //清空最低位的1，然后判断是否为0
        int count = 0;
        while (n != 0) {
            count ++;
            n = n & (n - 1);
        }
        return count;
    }

    public boolean isPowerOfTwo(int n) {
        //是2的幂次方就代表这个数的二进制表示有且仅有一个1
        //将最低位的1置0以后应该等于0
        return n > 0 && ((n & (n - 1)) == 0);
    }
}
