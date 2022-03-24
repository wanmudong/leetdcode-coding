package 代码随想录.动态规划.打家劫舍.打家劫舍三;

import 慢慢刷.二叉树.TreeNode;

import java.util.*;

/**
 * @author chenjiehao
 * @create 2022-03-15
 */
public class Solution {
    public int rob(TreeNode root) {

        List<TreeNode> list = travel(root);

        Map<TreeNode, Integer> map = new HashMap<>();
        map.put(null, 0);
        for (int i = list.size() - 1; i >= 0; i--) {
            TreeNode treeNode = list.get(i);
            int pre = 0;
            int sub = 0;
            if (treeNode.left!= null) {
                pre +=(map.get(treeNode.left.left) + map.get(treeNode.left.right));
                sub+= map.get(treeNode.left);
            }
            if (treeNode.right!= null) {
                pre +=(map.get(treeNode.right.left) + map.get(treeNode.right.right));
                sub+= map.get(treeNode.right);
            }
            int max = Math.max(treeNode.val + pre, sub);
            map.put(treeNode, max);
            System.out.println("i: "+ i+" max:"+max);
        }

        return map.get(root);
    }

    private List<TreeNode> travel(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        List<TreeNode> temp = new ArrayList<>();
        while (!queue.isEmpty()){
            while (!queue.isEmpty()){
                temp.add(queue.poll());
            }
            for (TreeNode treeNode : temp) {
                if (treeNode == null){
                    continue;
                }
                list.add(treeNode);
                System.out.println(treeNode.val);
                System.out.println();
                queue.add(treeNode.left);
                queue.add(treeNode.right);
            }
            temp.clear();
        }
        return list;
    }
}
