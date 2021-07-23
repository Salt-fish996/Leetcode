package LeetCode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author hyy
 * @date 2019/8/3 20:44
 */

public class Leetcode102 {
    /*
    * 这道题可以通过深度遍历而不是广度遍历来进行，
    * 在广度遍历进行递归查找的时候传入一个结点当前所在的层数，
    * 如果侍第一次访问到这个层次的值，那么就新建表存储该层次的值
    * 否则直接加入*/


      public static class TreeNode {
          int val;
          TreeNode left;
         TreeNode right;
      TreeNode(int x) { val = x; }
      }

    public List<List<Integer>> levelOrder(TreeNode root) {

          List<List<Integer>> result = new LinkedList<>();//结果
        TreeNode t = new TreeNode(-999);
        if (root == null)
        {
            return result;

        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<Integer> list1 = new LinkedList<>();
        list1.add(root.val);
        queue.add(t);
        result.add(list1);
        List<Integer> resultTemp = new LinkedList<>();
        while (!queue.isEmpty()){
            TreeNode temp = queue.poll();
            if (temp == t) {
                queue.add(t);
                if (queue.peek()==null||queue.peek()==t)break;
                result.add(resultTemp);
                resultTemp = new LinkedList<>();
            }else {
                TreeNode tempChildren = null;
                if ((tempChildren=temp.left)!=null){
                    queue.add(tempChildren);
                    resultTemp.add(tempChildren.val);
                }
                if ((tempChildren=temp.right)!=null){
                    queue.add(tempChildren);
                    resultTemp.add(tempChildren.val);
                }
            }
        }
        return result;

    }

    public static void main(String[] args) {
        TreeNode t = new TreeNode(20);
        TreeNode t1 = new TreeNode(10);
        TreeNode t2 = new TreeNode(5);
        TreeNode t3 = new TreeNode(5);

        t.left = t1;
        t1.left = t2;
        t.right = t3;
        Leetcode102 leetcode102 = new Leetcode102();
        System.out.println(leetcode102.levelOrder(t));
    }
}
