package src.LeetCode;

import java.util.HashMap;

/**
 * @author hyy
 * @date 2019/8/8 20:45
 */
class LRUCache {
    private  int capacity;
    class Node{
        //双向链表
        private int key;
        private int val;
        private Node next;
        private Node pre;

        public Node(int key,int h){
            this.val = h;
            this.key = key;
        }
        public Node(){

        }

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public Node getPre() {
            return pre;
        }

        public void setPre(Node pre) {
            this.pre = pre;
        }
    }
    HashMap<Integer,Node> hashMap = new HashMap<>();


    Node head = null;
    Node tail = null;


    public LRUCache(int capacity) {
        tail = new Node();
        head = new Node();
        tail.next = head;
        head.pre = tail;
        head.next = tail;
        tail.pre =head;
        this.capacity = capacity;

    }

    public int get(int key) {
        Node temp = hashMap.get(key);
        if (temp == null) return -1;//如果没有找到，返回-1

        //如果找到了，就把他取下来，然后加入到第一个节点
        Node pre = temp.pre;
        Node next = temp.next;
        //让当前结点的前面的结点指向后面的结点,后面结点的pre指向当前结点的钱一个节点
        pre.next = next;
        next.pre = pre;
        add(temp);
        return temp.val;
    }

    public void put(int key, int value) {
        Node temp = hashMap.get(key);
        if (temp != null){
            temp.val = value;
        }else {
            if (hashMap.size() >= capacity){
                delete();
            }
            temp = new Node(key,value);
            add(temp);
            hashMap.put(key,temp);
        }

    }
    public void delete(){
        Node temp = tail.pre;//获取最后一个节点
        hashMap.remove(temp.key);
        Node pre = temp.pre;
        pre.next = tail;
        tail.pre = pre;
    }

    public void add(Node node){
        Node temp = head.next;
        head.next = node;
        temp.pre = node;
        node.pre = head;
        node.next = temp;
    }

    public static void main(String[] args) {
        LRUCache  cache = new LRUCache(2);
        cache.put(2, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));       // 返回  1
        cache.put(3, 3);    // 该操作会使得密钥 2 作废
        System.out.println(cache.get(2));      // 返回 -1 (未找到)
        cache.put(4, 4);    // 该操作会使得密钥 1 作废
        System.out.println(cache.get(1));       // 返回 -1 (未找到)
        System.out.println(cache.get(3));      // 返回  3
        System.out.println(cache.get(4));

    }
}