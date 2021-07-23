package Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ScanTree {
    //递归中序遍历
    public void midScanIt(TreeNode node){
        if (node == null){
            return;
        }
        midScanIt(node.leftChild);
        System.out.print(node.val+" ");
        midScanIt(node.rightChild);
    }

    //递归前序遍历
    public void preScanIt(TreeNode node){
        if (node == null){
            return;
        }
        System.out.print(node.val+" ");
        preScanIt(node.leftChild);
        preScanIt(node.rightChild);
    }

    //递归后续遍历
    public void nextScanIt(TreeNode node){
        if (node == null){
            return;
        }
        nextScanIt(node.leftChild);
        nextScanIt(node.rightChild);
        System.out.print(node.val+" ");
    }

    //非递归前序遍历
    public void preScan(TreeNode node){
        Stack<TreeNode> stack = new Stack<>();
        stack.add(node);
        while (!stack.isEmpty()){
            TreeNode temp = stack.pop();
            System.out.print(temp.val+" ");//每次访问结点的左右结点前需要先将结点的值输出（或者存储到最后的结果中）
            if (temp.rightChild != null){
                stack.add(temp.rightChild);
            }
            if (temp.leftChild != null){
                stack.add(temp.leftChild);
            }
        }
    }

    //非递归中序遍历
    public void midScan(TreeNode node){
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = node;

        while (!stack.isEmpty() || p != null){
            if(p != null){//先访问所有的左结点
                stack.add(p);
                p = p.leftChild;
            }else {
                p = stack.pop();//如果左结点为空，或者已经将左结点遍历完了，那么将结点值输出
                System.out.print(p.val+" ");
                p = p.rightChild;//然后访问右节点
            }
        }
    }

    //非递归后序遍历
    public void nextScan(TreeNode node){
        //标记是从左子树还是右子树返回
        Stack<Boolean> flag = new Stack<>();
        //存储结点
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = node;
        while (!stack.isEmpty() || p != null){
            if (p != null){
                stack.add(p);
                p = p.leftChild;
                flag.add(false);//标记在左子树
            }else {
                if (flag.pop()){//从右子树返回，也就是上一个结点是将要访问结点的右子树
                    p = stack.pop();
                    System.out.print(p.val+" ");
                    p = null;//这里最好的方式就是设置为0，因为以p为节点的子树已经遍历完成，而这颗树并不知道是上一个结点的左子树还是右子树
                }else {//从左子树返回，左子树返回的时候不能输出结点，要先访问他的右孩子
                    p = stack.peek();
                    p = p.rightChild;
                    flag.add(true);
                }
            }
        }
    }

    //层次遍历
    public void levelScan(TreeNode node){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()){
            TreeNode temp = queue.poll();
            System.out.print(temp.val + " ");
            if (temp.leftChild != null){//如果左孩子不为空，加入队列
                queue.add(temp.leftChild);
            }
            if (temp.rightChild != null){//如果哟孩子不为空，加入队列
                queue.add(temp.rightChild);
            }

        }
    }


    public static void main(String[] args) {
        ScanTree scanTree = new ScanTree();
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(6);
        TreeNode t7 = new TreeNode(7);
        TreeNode t8 = new TreeNode(8);
        TreeNode t9 = new TreeNode(9);
        TreeNode t10 = new TreeNode(10);
        TreeNode t11 = new TreeNode(11);
        t1.leftChild = t2;
        t1.rightChild = t5;
        t2.leftChild = t3;
        t3.leftChild = t8;
        t8.rightChild = t9;
        t3.rightChild = t4;
        t4.leftChild = t10;
        t4.rightChild = t11;
        t5.rightChild = t6;
        t6.leftChild = t7;
        System.out.println("递归前序遍历：");
        scanTree.preScanIt(t1);
        System.out.println("\n非递归前序遍历：");
        scanTree.preScan(t1);
        System.out.println("\n递归中序遍历：");
        scanTree.midScanIt(t1);
        System.out.println("\n非递归中序遍历：");
        scanTree.midScan(t1);
        System.out.println("\n递归后序遍历:");
        scanTree.nextScanIt(t1);
        System.out.println("\n非递归后序遍历:");
        scanTree.nextScan(t1);
        System.out.println("\n层次遍历:");
        scanTree.levelScan(t1);

    }
}
