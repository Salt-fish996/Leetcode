package LeetCode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author hyy
 * @date 2019/8/6 21:17
 */
public class Leetcode144 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new LinkedList<>();
     /*   Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()){
            TreeNode treeNode = stack.pop();
            list.add(treeNode.val);
            while (treeNode.left != null){
                stack.add(treeNode.left);
            }
            while (treeNode.right != null){
                stack.add(treeNode.right);
            }
        }*/
     serarch(root,list);
        return list;
    }
    public void serarch(TreeNode node, List<Integer> list){
        if (node == null){
            return;
        }
        list.add(node.val);
        serarch(node.left,list);
        serarch(node.right,list);

    }
}
