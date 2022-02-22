package 慢慢刷.二叉树.二叉树的右视图;

import 慢慢刷.二叉树.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 描述:
 *
 * @author chenjiehao
 * @create 2021-08-21
 */
public class Solution {
    List<Integer> list = new ArrayList<>();

    public List<Integer> rightSideView(TreeNode root) {
        bfs(root);
        return list;
    }

    private void bfs(TreeNode root) {
        if (root == null) {
            return;
        }
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offerLast(root);
        while (!deque.isEmpty()) {
            int size = deque.size();
            Integer last = null;
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = deque.pollFirst();
                if (treeNode.left != null) {
                    deque.offerLast(treeNode.left);
                }
                if (treeNode.right != null) {
                    deque.offerLast(treeNode.right);
                }
                last = treeNode.val;
            }
            list.add(last);
        }
    }
}
