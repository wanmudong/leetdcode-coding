package hot100.BFS算法.二叉树的最小深度;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 111. 二叉树的最小深度
 *
 * 给定一个二叉树，找出其最小深度。
 *
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 *
 * 说明：叶子节点是指没有子节点的节点。
 *
 * https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/
 *
 *
 */
class Solution {
    /**
     * 典型BFS问题
     * @param root
     * @return
     */
    public int minDepth(TreeNode root) {
        if (root == null){
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);
        int depth = 1;

        while (! queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                if (cur.left == null && cur.right == null){
                    return depth;
                }
                if (cur.left != null){
                    queue.offer(cur.left);
                }
                if (cur.right != null){
                    queue.offer(cur.right);
                }
            }
            depth++;
        }
        return depth;
    }
}