package 慢慢刷.二叉树.二叉树的锯齿形层序遍历;

import 慢慢刷.二叉树.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 描述:
 *
 * @author chenjiehao
 * @create 2021-08-11
 */
public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        return bfs(root);

    }

    private List<List<Integer>> bfs(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
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
            if (level % 2 == 1){
                List<Integer> reverse = new ArrayList<>();
                for (int i = inner.size() -1 ; i >=0; i--) {
                    reverse.add(inner.get(i));
                }
                inner = reverse;
            }
            result.add(level,inner);
            level++;

            Queue<TreeNode> temp = queue1;
            queue1 = queue2;
            queue2 = temp;
        }
        return result;
    }
}
