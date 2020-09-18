package Week4;
/*
柠檬水找零
 */

import java.util.Arrays;

public class LemonadeChange {
    public static void main(String[] args) {
        int[] bills = {5,5,5,5,20,20,5,5,5,5};
        System.out.print(lemonadeChange(bills));

    }

    public static boolean lemonadeChange(int[] bills) {
        int five = 0, ten = 0;
        if (bills[0] != 5) return false;//若第一个顾客给的不是5，则直接返回false
        for (int bill : bills) {
            switch (bill) {
                case 5: five ++; break;//获得5块钱
                case 10: five --; ten ++; break;//获得10块钱，找回5块钱
                case 20: {
                    if (ten > 0) {//若有10块剩余，则用10块和5块找零
                        ten--;
                        five--;
                    } else {//若没有10块，则用3张5块找零
                        five -= 3;
                    }
                    break;
                }
                default: break;
            }
            if (five < 0) return false;//如果5块用光了，则返回false
        }
        return true;

    }
}
