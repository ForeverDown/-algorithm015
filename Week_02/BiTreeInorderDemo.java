package Week2;

import java.util.*;

public class BiTreeInorderDemo {
    public static void main(String[] args) {

    }

    /*
    中序遍历递归实现，根据模板自行编写
    时间复杂度O(logn)
     */
    public static void inorderRe (TreeNode root, List<Integer> list) {
        if (root != null) {
            inorderRe(root.left, list);
            list.add(root.val);
            inorderRe(root.right, list);
        }
    }

    /*
    中序遍历，基于栈的循环，来自题解
    时间复杂度O(n)
     */
    public static List<Integer> inorderStack (TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        while (current != null || !(stack.isEmpty())) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            list.add(current.val);
            current = current.right;
        }
        return list;
    }


}