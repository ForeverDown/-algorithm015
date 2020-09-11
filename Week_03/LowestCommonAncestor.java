package Week3;
/*
最近公共祖先
 */
public class LowestCommonAncestor {
    private TreeNode ans;
    public static void main(String[] args) {

    }
    /*
    来自题解
    思路：定义函数fx表示x节点的子树中是否包含p节点或者q节点，如果包含为true，否则为
    false。那么符合条件的最近公共祖先x节点一定满足：
    (左孩子f && 右孩子f) || ((x==p || x==q) && (左孩子f || 右孩子f))
    左孩子f && 右孩子f：说明左子树和右子树都包含p节点或q节点，如果左子树包含的是p节点，
    那么右子树只能包含q节点，反之亦然，因为p和q节点都是不同且唯一的节点，因此如果满足这个判断
    条件即可说明x就是我们要找的最近公共祖先。
    (x==q||x==q)：考虑了x恰好是p节点或者q节点的情况
    (左孩子f || 右孩子f)：它的左子树或者右子树包含了另一个节点
    以上二者用&&连接，即x恰好为其中一个节点，并且它的左子树或者右子树有一个包含了另一个节点

    这样一来所有情况都考虑到了，如果满足则x就是我们要找的最近公共祖先

     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        this.dfs(root, p, q);
        return this.ans;
    }

    public boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return false;//终结条件
        boolean leftSon = dfs(root.left, p, q);
        boolean rightSon = dfs(root.right, p, q);
        if ((leftSon && rightSon) || ((root.value == p.value || root.value == q.value) && (leftSon || rightSon))) {
            ans = root;
        }
        return leftSon || rightSon || (root.value== p.value || root.value == q.value);
    }
}
