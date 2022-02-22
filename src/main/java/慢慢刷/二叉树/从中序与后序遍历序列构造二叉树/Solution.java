package 慢慢刷.二叉树.从中序与后序遍历序列构造二叉树;

import 慢慢刷.二叉树.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 描述:
 *
 * @author chenjiehao
 * @create 2021-08-13
 */
public class Solution {
    Map<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildTree(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1);
    }

    private TreeNode buildTree(int[] inorder, int[] postorder, int start_inorder, int end_inorder, int start_postorder, int end_postorder) {
        if (end_inorder < start_inorder || end_postorder < start_postorder) {
            return null;
        }
        int root = postorder[end_postorder];
        int index = map.get(root);
//        for (int i = start_inorder; i <= end_inorder; i++) {
//            if (root == inorder[i]) {
//                index = i;
//            }
//        }
        int leftLength = index - start_inorder;
        TreeNode left = buildTree(inorder, postorder, start_inorder, index - 1, start_postorder, start_postorder + leftLength - 1);
        TreeNode right = buildTree(inorder, postorder, index + 1, end_inorder, start_postorder + leftLength, end_postorder - 1);

        return new TreeNode(root, left, right);
    }
}
