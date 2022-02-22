package 慢慢刷.二叉树.二叉搜索树迭代器;

import 慢慢刷.二叉树.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述:
 *
 * @author chenjiehao
 * @create 2021-08-21
 */
public class BSTIterator {
    List<Integer> list = new ArrayList<>();
    Integer cur = 0;


    public BSTIterator(TreeNode root) {
        bfs(root);
    }

    private void bfs(TreeNode root) {
        if (root == null){
            return;
        }
        bfs(root.left);
        list.add(root.val);
        bfs(root.right);
    }

    public int next() {
        Integer integer = list.get(cur);
        cur++;
        return integer;
    }

    public boolean hasNext() {
        if (cur<list.size()){
            return true;
        }
        return false;
    }
}
