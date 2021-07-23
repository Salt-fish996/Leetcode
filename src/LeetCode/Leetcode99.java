package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hyy
 * @date 2020/3/16 10:24
 */
//恢复二叉搜索树
public class Leetcode99 {

    //中序遍历
    public void inOrder(TreeNode root, List<TreeNode> list) {
        if (root == null) {
            return;
        }
        //遍历左子树
        inOrder(root.left, list);
        list.add(root);
        //遍历右子树
        inOrder(root.right, list);
    }
    //两个节点被错误的交换，
    public void recoverTree(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        inOrder(root, list);
        //中序遍历应该是严格递增的，当发现list中有不符合的结点的时候，将他们的值交换
        TreeNode first = null;
        TreeNode two = null;
        int left = 0;
        int right = list.size() - 1;
        for (int i = 1; i < list.size(); i++) {
            if (list.get(left).val > list.get(i).val) {
                break;
            }
            left = i;
        }
        for (int i = list.size() - 2; i >= 0 ; i--) {
            if (list.get(right).val < list.get(i).val) {
                break;
            }
            right = i;
        }

        int temp = list.get(left).val;
        list.get(left).val = list.get(right).val;
        list.get(right).val = temp;
    }
}
