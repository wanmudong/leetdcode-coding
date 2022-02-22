package 慢慢刷.二叉树.恢复二叉搜索树;

import 慢慢刷.二叉树.TreeNode;

/**
 * 描述:
 *
 * @author chenjiehao
 * @create 2021-08-09
 */
public class Solution {
    TreeNode x = null;
    TreeNode y = null;
    TreeNode pred = null;
    public void recoverTree(TreeNode root) {
        dfs(root);
        if (x != null && y!= null){
            int temp = x.val;
            x.val = y.val;
            y.val = temp;
        }
    }

    private void dfs(TreeNode root) {
        if (root == null){
            return;
        }
        dfs(root.left);
        if (pred != null && pred.val>root.val){
            y = root;
            if (x == null){
                x =pred;
            }
        }
        pred = root;
        dfs(root.right);
    }
}
