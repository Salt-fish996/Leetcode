package src.LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hyy
 * @date 2019/9/10 18:44
 */
public class Leetcode114 {
    public void flattenByIter(TreeNode treeNode, List<TreeNode> l){
        if (treeNode == null) return;

        System.out.println("结点："+treeNode.val);
        l.add(treeNode);

        TreeNode tempright = treeNode.right;
        TreeNode templrft = treeNode.left;
        treeNode.right = null;
        treeNode.left = null;

        flattenByIter(templrft,l);
        flattenByIter(tempright,l);
    }
    public void flatten(TreeNode root) {
        TreeNode temp = root;
        TreeNode tempright = root.right;
        TreeNode templeft  = root.left;
        root.left = null;
        root.right = null;
        List<TreeNode> l = new ArrayList<>();
        flattenByIter(templeft,l);
        flattenByIter(tempright,l);

        for (int i = 0; i < l.size(); i++) {
            temp.right = l.get(i);
            temp = temp.right;
        }
        return;
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(6);
        t1.left = t2;
        t1.right = t5;
        t2.left = t3;
        t2.right = t4;
        t5.right = t6;
        Leetcode114 leetcode114 = new Leetcode114();
        leetcode114.flatten(t1);

    }
}
