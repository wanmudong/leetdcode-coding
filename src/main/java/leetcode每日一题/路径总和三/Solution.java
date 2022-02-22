package leetcode每日一题.路径总和三;

import 慢慢刷.二叉树.TreeNode;

/**
 * 描述:
 *
 * @author chenjiehao
 * @create 2021-09-28
 */
public class Solution {
    int rootSum;
    public int pathSum(TreeNode root, int targetSum) {
        rootSum = targetSum;
        return  pathSum0(root,targetSum);
    }

    public int pathSum0(TreeNode root, int targetSum) {
        if (root == null){
            return 0;
        }
        if (targetSum == root.val){
            return 1+pathSum0(root.left,rootSum) + pathSum0(root.right,rootSum);
        }
        return pathSum0(root.left,targetSum - root.val)
                + pathSum0(root.left,rootSum)
                + pathSum0(root.right,targetSum - root.val)
                + pathSum0(root.right,rootSum);
    }
}
