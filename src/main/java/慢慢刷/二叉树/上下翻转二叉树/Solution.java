package 慢慢刷.二叉树.上下翻转二叉树;

import 慢慢刷.二叉树.TreeNode;

/**
 * 描述:
 *
 * @author chenjiehao
 * @create 2021-08-21
 */
public class Solution {
    TreeNode res = null;
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        dfs(root, null, null);
        return res;
    }

    private void dfs(TreeNode root, TreeNode forLeft, TreeNode forRight) {
        if (root == null) {
            return;
        }
        res = root;
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = forLeft;
        root.right = forRight;

        dfs(left, right, root);

    }
}
