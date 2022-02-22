package 慢慢刷.二叉树.二叉树的序列化与反序列化;

import 慢慢刷.二叉树.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 描述:
 *
 * @author chenjiehao
 * @create 2021-08-21
 */
public class Codec {

   List<String> list = new LinkedList<>();
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        dfs(root);
        return String.join(",",list);
    }

    private void dfs(TreeNode root) {
        if (root == null){
            list.add("Null");
        }else {
            list.add(String.valueOf(root.val));
            dfs(root.left);
            dfs(root.right);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] strings = data.split(",");
        List<String> dataList = new LinkedList<String>(Arrays.asList(strings));
        return dfs(dataList);
    }

    private TreeNode dfs(List<String> strings) {
        if (strings.get(0).equals("Null")) {
            strings.remove(0);
            return null;
        }

        TreeNode root = new TreeNode(Integer.valueOf(strings.get(0)));
        strings.remove(0);
        root.left = dfs(strings);
        root.right = dfs(strings);

        return root;
    }
}
