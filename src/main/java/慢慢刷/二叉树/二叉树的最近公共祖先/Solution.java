package 慢慢刷.二叉树.二叉树的最近公共祖先;

import 慢慢刷.二叉树.TreeNode;

/**
 * 描述:
 *
 * @author chenjiehao
 * @create 2021-08-21
 */
public class Solution {
    TreeNode res;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root,p,q);
        return res;
    }

    private boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null ){
            return false;
        }

        boolean left = dfs(root.left,p,q);
        boolean right = dfs(root.right,p,q);

       if ((left && right) || ((left || right) && (p.val == root.val || q.val == root.val))){
           res = root;
       }
       return left || right || p.val == root.val || q.val == root.val;
    }
}
