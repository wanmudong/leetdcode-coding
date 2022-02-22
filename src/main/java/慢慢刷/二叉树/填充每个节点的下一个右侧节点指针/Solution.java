package 慢慢刷.二叉树.填充每个节点的下一个右侧节点指针;

import 慢慢刷.二叉树.Node;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 描述:
 *
 * @author chenjiehao
 * @create 2021-08-19
 */
public class Solution {

    public Node connect1(Node root) {
        if (root == null){
            return null;
        }

        Node left = root;

        while ( left.left != null){
            Node head = left;
            while (head !=null){
                head.left.next = head.right;
                if (head.next != null){
                    head.right.next = head.next.left;
                }
                head = head.next;
            }
            left = left.left;
        }

        return root;
    }



    public Node connect(Node root) {
            BFS(root);
            return root;
    }

    private void BFS(Node root) {
        Deque<Node> deque = new LinkedList<>();
        if (root == null){
            return;
        }
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
    }
}
