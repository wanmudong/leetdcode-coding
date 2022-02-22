package 慢慢刷.二叉树.二叉搜索树的最近公共祖先;

import 慢慢刷.二叉树.TreeNode;

/**
 * 描述:
 *
 * @author chenjiehao
 * @create 2021-08-21
 */
public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null){
            return null;
        }
        TreeNode node = root;
        while(true){
            int val = node.val;
            if (p.val< val && q.val<val){
                node = node.left;
            }else if(p.val> val && q.val>val){
                node = node.right;
            }else {
                break;
            }
        }
        return node;
    }
}
