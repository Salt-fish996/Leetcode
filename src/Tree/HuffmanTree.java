package Tree;

import java.util.*;

//哈弗曼树
public class HuffmanTree {
    TreeNode head = null;
    public HuffmanTree(PriorityQueue<TreeNode> queue){
        while (queue.size()>1){//每次选出值最小的两个
            TreeNode node1 = queue.poll();
            TreeNode node2 = queue.poll();
            TreeNode newNode = new TreeNode(node1.val + node2.val);//创建新节点
            newNode.leftChild = node1;
            newNode.rightChild = node2;
            queue.add(newNode);
        }
        head = queue.poll();
    }

//    public int count(){//计算带权路径长度
//        Queue<TreeNode> queue = new LinkedList<>();
//        queue.add(head);
//        Queue<Integer> level = new LinkedList<>();
//        level.add(1);
//        StringBuilder s = new StringBuilder();
//        int lastlevel = 1;
//        int count = 0;
//        while (!queue.isEmpty()){
//            TreeNode temp = queue.poll();
//            int l = level.poll();
//
//            if (l != lastlevel){
//                lastlevel = l;
//                count += temp.val*(l - 1);
//            }
//            if (temp.leftChild != null){
//                queue.add(temp.leftChild);
//                level.add(l + 1);
//            }
//            if (temp.rightChild != null){
//                queue.add(temp.rightChild);
//                level.add(l + 1);
//            }
//
//        }
//        return count;
//    }


    public String toString(){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(head);
        Queue<Integer> level = new LinkedList<>();
        level.add(1);
        StringBuilder s = new StringBuilder();
        int lastlevel = 1;
        while (!queue.isEmpty()){
            TreeNode temp = queue.poll();
            int l = level.poll();

            if (l != lastlevel){
                lastlevel = l;
                s.append("\n");
            }
            s.append(temp.val+" ");
            if (temp.leftChild != null){
                queue.add(temp.leftChild);
                level.add(l + 1);
            }
            if (temp.rightChild != null){
                queue.add(temp.rightChild);
                level.add(l + 1);
            }

        }
        return s.toString();
    }


    public static void main(String[] args) {

        PriorityQueue<TreeNode> queue = new PriorityQueue<>((o1, o2) -> o1.val - o2.val);
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            TreeNode node = new TreeNode(in.nextInt());
            queue.add(node);
        }
        HuffmanTree huffmanTree = new HuffmanTree(queue);
        System.out.println(huffmanTree.toString());
    }
}
