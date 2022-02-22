package 慢慢刷.二叉树;

/**
 * 描述:
 *
 * @author chenjiehao
 * @create 2021-08-07
 */


public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
