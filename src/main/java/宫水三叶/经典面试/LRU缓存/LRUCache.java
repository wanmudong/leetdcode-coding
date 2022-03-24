package 宫水三叶.经典面试.LRU缓存;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chenjiehao
 * @create 2022-03-02
 */
public class LRUCache {

    Map<Integer,Node> map = new HashMap<>();
    Node head = new Node();
    Node tail = new Node();
    int max = 0;


    /**
     * 分析: 我们必然有一个map,能够完成get操作.
     * 但如何让我们在get操作后的位置的移动能够n(1)呢
     * 我们发现每次移动必然是移动到最前端,那么我们只要保留最前端.
     * 即移动操作仅影响当前节点与最前端即可
     * 这样的话,LRU的顺序本身应该通过什么保证?
     * 数组?每次移动消耗大.链表?每次移动损耗小,考虑到当前场景,需要双向链表感知前后节点.
     * 那map与链表如何关联?map 的key存储设置的key,map的value存储链表的节点,节点包含key value
     * @param capacity
     */
    public LRUCache(int capacity) {
        max = capacity;
    }

    /**
     * 返回对应的key,并将键值对移动到最前位置
     * @param key
     * @return
     */
    public int get(int key) {
        if (map.containsKey(key)){
            Node node = map.get(key);
            resort(node);
            return node.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)){
            Node node = map.get(key);
            node.value = value;
            resort(node);
            map.put(key,node);
        }else {
            if (map.size() == 0){

                Node node = new Node(key, value);
                node.pre = head;
                head.next = node;

                node.next = tail;
                tail.pre = node;

                map.put(key,node);
                return;
            }
            if (map.size() == max){
                Node node = tail.pre;
                relation(node.pre, tail);
                node.next = null;
                node.pre = null;
                map.remove(node.key);
            }
            Node node = new Node(key, value);

            Node next = head.next;

            node.pre = head;
            node.next = next;

            head.next = node;
            next.pre = node;

            map.put(key,node);
        }
    }

    private void resort(Node node){
        Node pre = node.pre;
        Node next = node.next;
        relation(pre, next);
        Node head_next = head.next;
        relation(head, node);
        relation(node, head_next);
    }

    private void relation(Node pre, Node next){
        if (pre == null || next == null){
            return;
        }
        pre.next = next;
        next.pre = pre;
    }


    static class Node{
        Node pre;
        Node next;
        Integer key;
        Integer value;

        public Node(Integer key, Integer value) {
            this.key = key;
            this.value = value;
        }

        public Node() {

        }
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1,1);
        lruCache.put(2,2);
        System.out.println(lruCache.get(1));
        lruCache.put(3,3);
        System.out.println(lruCache.get(2));
        lruCache.put(4,4);
        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(3));
        System.out.println(lruCache.get(4));
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */