package 慢慢刷.二叉树.填充每个节点的下一个右侧节点指针2;

import 慢慢刷.二叉树.Node;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 描述:
 *
 * @author chenjiehao
 * @create 2021-08-20
 */
public class Solution {

    public Node connect1(Node root) {
        if (root == null) {
            return null;
        }
        Node start = root;
        while (start != null){
            Node last = null;
            Node nextStart = null;
            for (Node p = start;p != null;p = p.next){
                if (p.left != null){
                    Node left = p.left;
                    if (nextStart == null){
                        nextStart = left;
                    }
                    if (last != null){
                        last.next = left;
                    }
                    last = left;
                }
                if (p.right != null){
                    Node right = p.right;
                    if (nextStart == null){
                        nextStart = right;
                    }
                    if (last != null){
                        last.next = right;
                    }
                    last = right;
                }
            }
            start = nextStart;
        }
        return root;

    }

    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        Deque<Node> deque = new LinkedList<>();

        deque.offerLast(root);
        while ( ! deque.isEmpty()){
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                Node node = deque.pollFirst();
                if (i<size-1){
                    node.next = deque.peekFirst();
                }
                if (node.left != null){
                    deque.offerLast(node.left);
                }
                if (node.right != null){
                    deque.offerLast(node.right);
                }
            }
        }
        return root;

    }
}
