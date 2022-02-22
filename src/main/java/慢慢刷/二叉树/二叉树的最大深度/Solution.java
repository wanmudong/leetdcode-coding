package 慢慢刷.二叉树.二叉树的最大深度;

import 慢慢刷.二叉树.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 描述:
 *
 * @author chenjiehao
 * @create 2021-08-11
 */
public class Solution {
    public int maxDepth(TreeNode root) {
        return bfs(root);
    }

    private int bfs(TreeNode root) {
        int level = 0;
        if (root == null){
            return level;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (poll == null){
                    continue;
                }
                if (poll.left != null) {
                    queue.offer(poll.left);
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                }

            }
            level++;
        }
        return level;
    }
}
