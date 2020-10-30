package week9;

import java.util.HashMap;
import java.util.Map;
//第一个不重复的字符
public class FirstUniqChar {
    /*
    自行编写，使用map提高查询速度
    复杂度依旧很高，需要进一步优化
     */
    public int firstUniqChar(String s) {
        //建立map，用于存储字符
        Map<Integer, Character> map = new HashMap<>();
        //循环1，将字符串拆分成字符然后放入map
        for (int i = 0; i < s.length(); i ++) {
            map.put(i, s.charAt(i));//键为索引，值为字符
        }
        //循环2，遍历s字符串
        for (int i = 0; i < s.length(); i ++) {
            map.remove(i);//现将当前字符键值移出
            //移出后不存在相同的值，则返回i
            if (!map.containsValue(s.charAt(i))) {
                return i;
            }
            //再将移除的值放回
            map.put(i, s.charAt(i));
        }
        return -1;
    }
}
