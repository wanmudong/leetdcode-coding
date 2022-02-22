package 慢慢刷.二叉树.验证二叉搜索树;

import 慢慢刷.二叉树.TreeNode;

import java.util.*;

/**
 * 描述:
 *
 * @author chenjiehao
 * @create 2021-08-07
 */

// 思路,中序遍历,判读遍历后的数据是否为升序
public class Solution {
    Queue<TreeNode> stack = new LinkedList<TreeNode>();
    public boolean isValidBST(TreeNode root) {
        if (root == null){
            return true;
        }
        travel(root);
        TreeNode last = stack.poll();
        while (!stack.isEmpty()){
           TreeNode now = stack.poll();
           if (now.val<last.val){
               return  false;
           }
           last = now;
       }
        return true;

    }

    public void travel(TreeNode root){

        if (root == null){
            return ;
        }

        travel(root.left);
        stack.add(root);
        travel(root.right);
    }
}
