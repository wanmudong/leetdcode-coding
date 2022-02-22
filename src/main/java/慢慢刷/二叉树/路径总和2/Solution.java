package 慢慢刷.二叉树.路径总和2;

import 慢慢刷.二叉树.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 描述:
 *
 * @author chenjiehao
 * @create 2021-08-18
 */
public class Solution {
    List<List<Integer>> result = new ArrayList<>();
    Deque<Integer> deque = new LinkedList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
            dfs(root, targetSum);
            return result;
    }

    private void dfs(TreeNode root, int targetSum) {
        if (root == null){
            return;
        }
        deque.offerLast(root.val);
        targetSum -=root.val;
        if (root.left == null && root.right == null && targetSum == 0){
            result.add(new ArrayList<>(deque));
        }
        dfs(root.left, targetSum);
        dfs(root.right, targetSum);
        deque.pollLast();
    }
}
