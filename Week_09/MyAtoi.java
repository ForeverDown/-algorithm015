package week9;
//字符串转换整数
public class MyAtoi {

    public static void main(String[] args) {

    }

    public static int myAtoi(String s) {
        int index = 0;//遍历指针
        int sign = 1;//符号
        int total = 0;//值
        if (s.length() == 0) return 0;
        //循环1，过滤掉字符串前面的空格
        while (s.charAt(index) == ' ' && index < s.length()) index ++;
        //判断1，判断符号
        if (s.charAt(index) == '+' || s.charAt(index) == '-') {
            sign = s.charAt(index) == '+' ? 1 : -1;
            index ++;
        }
        //循环2，计算值
        while (index < s.length()) {
            int num = s.charAt(index) - '0';
            if (num < 0 || num > 9) break;
            //判断2，判断越界
            if (Integer.MAX_VALUE / 10 < total ||
                Integer.MIN_VALUE / 10 > total && Integer.MAX_VALUE % 10 < num) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            total = 10 * total + num;
            index ++;
        }
        return total * sign;
    }
}
