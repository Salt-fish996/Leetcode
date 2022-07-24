package src.LeetCode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

//复制带随机指针的链表，通过
public class Leetcode138 {

    class Node {
        public int val;
        public Node next;
        public Node random;

        public Node() {}

        public Node(int _val,Node _next,Node _random) {
            val = _val;
            next = _next;
            random = _random;
        }
    };

    //和133题大致思路相同，用hashMap存储已经拷贝过的点
    public Node copyRandomList(Node head) {

        if (head == null) return null;
        Map<Node,Node> nodeNodeMap = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(head);
        Node newNode = new Node(head.val,null,null);
        nodeNodeMap.put(head,newNode);

        while (! queue.isEmpty()){
            Node now = queue.poll();
            //取得当前结点的拷贝
            newNode = nodeNodeMap.get(now);
            Node temp = null;
            //先复制下一个结点
            if ((temp = nodeNodeMap.get(now.next)) == null){
                if (now.next != null){
                    temp = new Node(now.next.val,null,null);
                    nodeNodeMap.put(now.next,temp);
                    queue.add(now.next);
                }
            }
            newNode.next = temp;

            //复制随机结点
            if ((temp = nodeNodeMap.get(now.random)) == null){
                if (now.random != null){
                    temp = new Node(now.random.val,null,null);
                    nodeNodeMap.put(now.random,temp);
                    queue.add(now.random);
                }
            }
            newNode.random = temp;
        }
        return nodeNodeMap.get(head);
    }
}
