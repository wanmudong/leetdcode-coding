package 慢慢刷.二叉树.左叶子之和;

import 慢慢刷.二叉树.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 描述:
 *
 * @author chenjiehao
 * @create 2021-08-21
 */
public class Solution {

    int sum = 0;
    public int sumOfLeftLeaves(TreeNode root) {
        bfs(root);
        return sum;
    }

    private void bfs(TreeNode root) {
        if (root == null){
            return;
        }
        if ( root.left == null && root.right == null){
           return;
        }
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offerLast(root);

        while (!deque.isEmpty()){
            TreeNode node = deque.pollFirst();
            if (node.left != null){
                if (node.left.left == null && node.left.right == null ){
                    sum+=node.left.val;
                }else {
                    deque.offerLast(node.left);
                }
            }
            if (node.right != null){
                    deque.offerLast(node.right);
            }
        }
    }
}
