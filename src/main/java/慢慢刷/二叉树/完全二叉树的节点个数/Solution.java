package 慢慢刷.二叉树.完全二叉树的节点个数;

import 慢慢刷.二叉树.TreeNode;

/**
 * 描述:
 *
 * @author chenjiehao
 * @create 2021-08-21
 */
public class Solution {

    public int countNodes1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        TreeNode node = root;
        int level = 0;
        while (node.left != null) {
            level++;
            node = node.left;
        }
        int low = 1 << level;
        int high = (1 << (level + 1)) - 1;

        while (low < high){
            int mid = (high -low+1)/2+low;
            if (exists(mid, level , root)){
                low = mid;
            }else {
                high = mid-1;
            }
        }
        return low;
    }

    private boolean exists(int mid, int level, TreeNode root) {
        int bits = 1<<(level-1);
        TreeNode node  = root;
        while (node != null &&bits>0){
            if ((bits & mid) == 0){
                node = node.left;
            }else {
                node = node.right;
            }
            bits>>=1;
        }
        return node != null;
    }


    ////////////////////////////////////////////////
    int sum = 0;

    public int countNodes(TreeNode root) {
        if (root == null) {
            return sum;
        }
        dfs(root);
        return sum;
    }

    private void dfs(TreeNode root) {
        sum++;
        if (root.left != null) {
            dfs(root.left);
        }
        if (root.right != null) {
            dfs(root.right);
        }
    }
}
