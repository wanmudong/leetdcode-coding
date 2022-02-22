package 慢慢刷.二叉树.二叉树的所有路径;

import 慢慢刷.二叉树.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 描述:
 *
 * @author chenjiehao
 * @create 2021-08-21
 */
public class Solution {
    List<String> res = new ArrayList<>();    // 存储结果
    LinkedList<String> path = new LinkedList<>();  // 存储单个路径

    public List<String> binaryTreePaths(TreeNode root) {
        traverse(root);
        return res;
    }

    // 二叉树的遍历框架
    public void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        // 前序遍历位置
        path.add(String.valueOf(root.val));
        // 到叶子节点就返回
        if (root.left == null && root.right == null) {
            // 添加到结果中
            res.add(String.join("->", path));
        }
        traverse(root.left);
        traverse(root.right);
        path.removeLast();
    }

}
