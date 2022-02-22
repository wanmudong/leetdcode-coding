package 慢慢刷.二叉树.二叉搜索树中第K小的元素;

import 慢慢刷.二叉树.TreeNode;

/**
 * 描述:
 *
 * @author chenjiehao
 * @create 2021-08-21
 */
public class Solution {
    int k;
    int res ;
    boolean skip =false;
    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        dfs(root);
        return res;
    }

    private void dfs(TreeNode root) {
        if (root == null || skip){
            return;
        }

        dfs(root.left);
        if(--k == 0){
            res = root.val;
            skip = true;
            return;
        }
        dfs(root.right);

    }
}
