package LeetCode;

import java.util.*;

//克隆图，通过
public class Leetcode133 {
    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {}

        public Node(int _val,List<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    };


    /*分析：
    * 采用广度遍历的方式，对每一个结点的相邻进行复制，然后将已经复制了的结点加入到
    * Map<>中去，每次创建新节点的时候看map中是否已经有结点的拷贝，如果没有就进行拷贝冉爱华加入到
    * map中去，如果map中已经有了，那么就直接使用*/
    public Node cloneGraph(Node node) {

        Map<Node,Node> nodeMap = new HashMap<>();//用于存储已经拷贝了的结点，key=原始结点，value-拷贝结点
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        Node newNode = new Node(node.val,new ArrayList<>());//拷贝初始结点值
        nodeMap.put(node,newNode);
        while (! queue.isEmpty()){
            Node node1 = queue.poll();
            List<Node> list = node1.neighbors;//获取相邻结点
            Node copyNode = nodeMap.get(node1);//获取拷贝结点
            for (Node n:list
                 ) {
                Node node2 = null;
                if ((node2 = nodeMap.get(n))==null){//如果没有当前结点的拷贝
                    node2 = new Node(n.val,new ArrayList<>());
                    nodeMap.put(n,node2);
                    queue.add(n);
                }
                copyNode.neighbors.add(node2);
            }
        }
        return newNode;
    }

}
