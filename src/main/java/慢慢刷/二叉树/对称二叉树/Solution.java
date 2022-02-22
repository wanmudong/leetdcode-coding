package 慢慢刷.二叉树.对称二叉树;

import 慢慢刷.二叉树.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 描述:
 *
 * @author chenjiehao
 * @create 2021-08-10
 */
public class Solution {

    public boolean isSymmetric(TreeNode root) {
        return bfs(root,root);
    }

    private boolean bfs(TreeNode x, TreeNode y) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(x);
        queue.offer(y);
        while ( ! queue.isEmpty()){
            TreeNode a = queue.poll();
            TreeNode b = queue.poll();
            if (a == null && b == null ){
                continue;
            }
            if (a == null || b == null || a.val != b.val){
                return false;
            }
            queue.offer(a.left);
            queue.offer(b.right);
            queue.offer(a.right);
            queue.offer(b.left);

        }
        return true;
    }

    private void swap(TreeNode root) {
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
    }
}
