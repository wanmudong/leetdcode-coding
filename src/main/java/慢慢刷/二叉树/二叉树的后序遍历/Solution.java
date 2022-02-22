package 慢慢刷.二叉树.二叉树的后序遍历;

import 慢慢刷.二叉树.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述:
 *
 * @author chenjiehao
 * @create 2021-08-21
 */
public class Solution {

    List<Integer> list = new ArrayList<>();
    public List<Integer> postorderTraversal(TreeNode root) {
        dfs(root);
        return list;
    }

    private void dfs(TreeNode root) {
        if (root == null){
            return ;
        }
        postorderTraversal(root.left);
        postorderTraversal(root.right);
        list.add(root.val);
    }
}
