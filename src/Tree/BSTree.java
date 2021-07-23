package Tree;

import java.util.Scanner;

//二叉排序树
public class BSTree {
    private TreeNode head = null;

    private void insert(TreeNode node,TreeNode node1){
            if (node.val == node1.val){
                return;
            }
            if (node.val < node1.val){
                if (node.rightChild != null)
                insert(node.rightChild,node1);
                else node.rightChild = node1;
            }else {
                if (node.leftChild != null)
                insert(node.leftChild,node1);
                else node.leftChild = node1;
            }
    }
    public void insertNode(TreeNode node){
        if (head == null) head = node;
        else
       insert(head,node);
    }
    private String midScan(TreeNode node){
        if (node == null) return "";
        return midScan(node.leftChild) + " "+node.val+" "+midScan(node.rightChild);
    }

    public String toString(){
        return midScan(head);
    }

    private boolean find(TreeNode node,int val){
        if (node == null) return false;
        if (node.val == val) return true;
        if (node.val < val) return find(node.rightChild,val);
        else return find(node.leftChild,val);
    }
    public boolean contain(int val){
        return find(head,val);
    }

    public static void main(String[] args) {
        BSTree bsTree = new BSTree();
        Scanner in = new Scanner(System.in);
        for (int i = 0; i < 10; i++) {
            TreeNode treeNode = new TreeNode(in.nextInt());
            bsTree.insertNode(treeNode);
        }
        System.out.println(bsTree.toString());
    }
}
