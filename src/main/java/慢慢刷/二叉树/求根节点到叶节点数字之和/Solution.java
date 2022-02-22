package 慢慢刷.二叉树.求根节点到叶节点数字之和;

import 慢慢刷.二叉树.TreeNode;

/**
 * 描述:
 *
 * @author chenjiehao
 * @create 2021-08-21
 */
public class Solution {
    public int sumNumbers(TreeNode root) {
           return dfs(root,0);
    }

    private int dfs(TreeNode root, int preSum) {
        if (root == null){
            return 0;
        }
       int sum = preSum*10+root.val;
        if (root.left == null && root.right == null){
            return sum;
        }else {
            return dfs(root.left,sum)+ dfs(root.right,sum);
        }

    }

//    private String toString(List<Integer> integers) {
//        if (integers == null){
//            return null;
//        }
//        StringBuffer buffer = new StringBuffer();
//        for (Integer integer: integers){
//            buffer.
//        }
//    }
}
