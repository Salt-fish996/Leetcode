package src.LeetCode;

import java.util.HashMap;
import java.util.Map;

public class Leetcode460 {
    class LFUCache {
        // 记录结点的前后结点，以出现的count从大到小排序
        class Node {
            Node pre;
            Node next;
            int value;
            int key;
            int useCount; // 次数

            Node(int key,int v) {
                this.value = v;
                this.useCount = 1;
                this.key = key;
            }
        }
        int count = 0; // 记录已经存放的数目
        int capacity =0; // 容量
        Node head = null;
        Node tail = null;
        // 使用一个map来记录次数
        Map<Integer,Node> map = null;
        public LFUCache(int capacity) {
           this.capacity = capacity;
           this.map = new HashMap<>();
        }

        public int get(int key) {
            // 查看map里面有没有对应的key,没有直接返回-1
            if (!this.map.containsKey(key)) {
                return -1;
            }
            // 存在key，那么将key对应的使用次数加一,并改变结点在双向链表中的位置
            Node n = this.map.get(key);
            n.useCount++;
            changeSit(n);
            return n.value;
        }

        public void put(int key, int value) {
            if (this.capacity == 0) {
                return;
            }
            // 没有数据
            if (head == null) {
                Node n = new Node(key,value);
                head = n;
                tail = n;
                this.map.put(key,n);
                this.count++;
            } else {
                // 如果存在对应的值，那么变更value
                if (this.map.containsKey(key)) {
                    this.map.get(key).value = value;
                    this.map.get(key).useCount++;
                    changeSit(this.map.get(key));
                    return;
                }
                // 容量未满
                if (this.count < this.capacity) {
                        // 不存在值，那么就插入并查找对应的位置
                        Node n = new Node(key,value);
                        n.pre = tail;
                        tail.next = n;
                        tail = n;
                        changeSit(n);
                        this.map.put(key,n);
                    this.count++;
                } else {
                    Node n = new Node(key,value);
                    // 容量已经满了，那么删除最后的结点，然后再排序
                    this.map.remove(tail.key);
                    if (tail.pre == null) {
                        // 只有一个结点，那么直接赋值
                        tail = n;
                        head = n;
                    } else {
                        // 删除掉最后一个结点进行排序
                        tail.pre.next = n;
                        n.pre = tail.pre;
                        tail = n;
                        changeSit(n);
                    }
                    this.map.put(key,n);
                }
            }
        }

        // 凭借 useCount 改变位置
        public void changeSit(Node n) {
            // 往前找结点，找到不小于当前使用次数的结点
            if (n.pre == null) {
                return;
            }
            Node now = n.pre;
            Node pre = null;
            while (now != null) {
                if (now.useCount <= n.useCount) {
                    // 遍历到的结点小于当前的使用次数，那么记录下来
                    pre = now;
                } else {
                    // 如果存在了大于当前结点使用次数的结点，那么退出
                    break;
                }
                now = now.pre;
            }

            if (pre == null) {
                // 没有小于当前结点使用次数的结点
                return;
            } else {
                if (tail == n) {
                    tail = n.pre;
                }
                // 将结点n放在pre之前
                // 将n的前后结点连接
                Node nPre = n.pre;
                Node nNext = n.next;
                n.pre.next = nNext;
                if (nNext != null) {
                    nNext.pre = nPre;
                }
                // 将n放在pre之前
                Node prePre = pre.pre;
                Node preNext = pre.next;
                if (prePre == null) {
                    head = n;
                } else {
                    prePre.next = n;
                }
                n.next = pre;
                n.pre = prePre;
                pre.pre = n;
            }
        }
    }

    public static void main(String[] args) {
        Leetcode460.LFUCache l = new Leetcode460().new LFUCache(2);
        l.put(2,1);
//        System.out.println(l.get(1));
        l.put(1,1);
//        System.out.println(l.get(2));
        l.put(2,3);
//        System.out.println(l.get(1));
//        System.out.println(l.get(2));
        l.put(4,1);
        System.out.println(l.get(1));
        System.out.println(l.get(2));

    }
}
