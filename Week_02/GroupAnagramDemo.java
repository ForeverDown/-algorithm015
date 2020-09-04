package Week2;
import java.util.*;

public class GroupAnagramDemo {
    public static void main(String[] args) {
        String[] strs = new String[] {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> list = groupAnagrams(strs);
        for (int i = 0; i < list.size(); ++ i) {
            List<String> listInside = list.get(i);
            for (String str : listInside) {
                System.out.print(str + " ");
            }
            System.out.println();
        }


    }
    /*
    排序后判断，自行编写
    使用哈希表来存放，key为每一个排序后的字符串，value为一个放原字符串的集合
    若和key值相同，则丢到集合中
    时间复杂度O(n * mlogm) （即排序复杂度O(nlogn)乘以循环复杂度O(n)）
     */
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> totalMap = new HashMap<String, List<String>>();
        for (int i = 0; i < strs.length; ++ i) {
            char[] chars = strs[i].toCharArray();//将下标为i的字符串拆分成一个字符数组
            Arrays.sort(chars);//将字符数组排序
            String chars_str = String.valueOf(chars);
            if (!(totalMap.containsKey(chars_str))) {//若不存在对应的key
                ArrayList<String> list = new ArrayList<String>();//新建一个字符串集合
                list.add(strs[i]);//放入集合
                totalMap.put(chars_str, list);
            } else {
                totalMap.get(chars_str).add(strs[i]);//添加到对应的key中
            }
        }
        return new ArrayList<List<String>>(totalMap.values());
    }

    /*
    计算每一个字母出现的次数，来自题解
    思路：自己实现一个哈希算法，计算每个字母出现的次数，映射到一个数组中，判断数组是否相等即可
    首先初始化 key = "0#0#0#0#0#"，数字分别代表 abcde 出现的次数，# 用来分割。
    这样的话，"abb" 就映射到了 "1#2#0#0#0"。
    "cdc" 就映射到了 "0#0#2#1#0"。
    "dcc" 就映射到了 "0#0#2#1#0"。
    时间复杂度O(n * K)
     */
//    public static List<List<String>> groupAnagrams(String[] strs) {
//        Map<String, List<String>> map = new HashMap<String, List<String>>();
//        for (int i = 0; i < strs.length; ++ i) {
//            int[] counter = new int[26];//记录26个字母出现的次数
//            for (int j = 0; j < strs[i].length(); ++ j) {
//                counter[strs[i].charAt(j) - 'a'] ++;
//            }
//            //建立字符串，中间加入“#”
//            String key = "";
//            for (int j = 0; j < counter.length; ++ j) {
//                key = key + counter[j] + "#";
//            }
//            if (!(map.containsKey(key))) {//若不存在对应的key，则新建List
//                List<String> list = new ArrayList<String>();
//                list.add(strs[i]);
//                map.put(key, list);
//            } else {
//                map.get(key).add(strs[i]);
//            }
//        }
//        return new ArrayList<List<String>>(map.values());
//    }



}
