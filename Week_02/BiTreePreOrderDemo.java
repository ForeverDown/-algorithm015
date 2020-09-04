package Week2;
import java.util.*;

public class BiTreePreOrderDemo {
    public static void main(String[] args) {

    }

    /*
    前序遍历递归实现，根据模板自行编写
    时间复杂度O(logn)
     */

    public static void preOrderRe (TreeNode root, List<Integer> list) {
        list.add(root.val);
        TreeNode leftTree = root.left;
        if (leftTree != null) {
            preOrderRe(leftTree, list);
        }
        TreeNode rightTree = root.right;
        if (rightTree != null) {
            preOrderRe(rightTree, list);
        }
    }

}
