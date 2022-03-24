package 宫水三叶.经典面试.LFU缓存;

import 宫水三叶.经典面试.LRU缓存.LRUCache;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chenjiehao
 * @create 2022-03-04
 */
public class LFUCache {

    Map<Integer, Node> map = new HashMap<>();
    Map<Integer, Node> timeMap = new HashMap<>();
    Node head = new Node();
    Node tail = new Node();
    int max = 0;

    public LFUCache(int capacity) {
        max = capacity;
    }

    public int get(int key) {
        if (map.containsKey(key)){
            Node node = map.get(key);
            node.time++;
            resort(node);
            return node.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (max == 0){
            return;
        }
        if (map.containsKey(key)){
            Node node = map.get(key);
            node.value = value;
            node.time++;
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
                timeMap.put(1,node);
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

            Node pre = tail.pre;
            relation(pre, node);
            relation(node, tail);
            resort(node);

            map.put(key,node);
        }
    }



    static class Node{
        Node pre;
        Node next;
        Integer key;
        Integer value;
        Integer time;

        public Node(Integer key, Integer value) {
            this.key = key;
            this.value = value;
            this.time = 1;
        }

        public Node() {

        }
    }



    private void resort(Node node){

        Node pre = node.pre;

        int count = 0;
        while (pre.time != null && node.time>=pre.time){
            pre = pre.pre;
            count++;
        }
        if (count > 0) {
            Node next = node.next;
            Node pre1 = node.pre;

            Node next1 = pre.next;

            relation(pre1, next);
            relation(pre, node);
            relation(node, next1);
        }
    }

    private void relation(Node pre, Node next){
        if (pre == null || next == null){
            return;
        }
        pre.next = next;
        next.pre = pre;
    }


    public static void main(String[] args) {
        LFUCache lruCache = new LFUCache(2);
        lruCache.put(1,1);
        lruCache.put(2,2);
        System.out.println(lruCache.get(1));
        lruCache.put(3,3);
        System.out.println(lruCache.get(2));
        System.out.println(lruCache.get(3));
        lruCache.put(4,4);
        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(3));
        System.out.println(lruCache.get(4));
    }
}