package 慢慢刷.二叉树.二叉树的层序遍历2;

import 慢慢刷.二叉树.TreeNode;

import java.util.*;

/**
 * 描述:
 *
 * @author chenjiehao
 * @create 2021-08-15
 */
public class Solution {
    Stack<List<Integer>> stack = new Stack<>();
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        bfs(root);
        List<List<Integer>> result = new ArrayList<>(stack.size());
        while (!stack.isEmpty()){
            List<Integer> list = stack.pop();
            result.add(list);
        }
        return result;
    }
    private void bfs(TreeNode root) {

        int level = 0;
        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();
        queue1.offer(root);
        while (!queue1.isEmpty() || !queue2.isEmpty()) {
            List<Integer> inner = new ArrayList<>();
            while (!queue1.isEmpty()) {
                TreeNode poll = queue1.poll();
                if (poll == null){
                    continue;
                }
                inner.add(poll.val);
                queue2.offer(poll.left);
                queue2.offer(poll.right);
            }
            if (inner.isEmpty()){
                continue;
            }
            stack.add(level,inner);
            level++;

            Queue<TreeNode> temp = queue1;
            queue1 = queue2;
            queue2 = temp;
        }
    }
}
