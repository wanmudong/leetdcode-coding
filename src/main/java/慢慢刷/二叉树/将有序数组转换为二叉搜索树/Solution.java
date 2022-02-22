package 慢慢刷.二叉树.将有序数组转换为二叉搜索树;

import 慢慢刷.二叉树.TreeNode;

/**
 * 描述:
 *
 * @author chenjiehao
 * @create 2021-08-18
 */
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return bfs(nums,0,nums.length-1);
    }

    private TreeNode bfs(int[] nums, int left, int right) {
        if (left>right){
            return null;
        }
        int mid = (left + right) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = bfs(nums,left,mid -1);
        root.right = bfs(nums,mid + 1,right);
        return root;
    }
}