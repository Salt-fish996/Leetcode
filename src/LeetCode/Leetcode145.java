package LeetCode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author hyy
 * @date 2019/8/6 21:08
 */
public class Leetcode145 {
    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null){
            return null;
        }
        List<Integer> list = new LinkedList<>();
        serarch(root,list);
        return list;

    }
    public void serarch(TreeNode node, List<Integer> list){
        if (node == null){
            return;
        }
        serarch(node.left,list);
        serarch(node.right,list);
        list.add(node.val);
    }
}
