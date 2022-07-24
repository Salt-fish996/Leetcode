package src.LeetCode;

import java.util.ArrayList;
import java.util.List;

public class Leetcode230 {
    /**给定一个二叉搜索树，编写一个函数 kthSmallest 来查找其中第 k 个最小的元素。

     说明：
     你可以假设 k 总是有效的，1 ≤ k ≤ 二叉搜索树元素个数。

     示例 1:

     输入: root = [3,1,4,null,2], k = 1
     3
     / \
     1   4
     \
        2
     输出: 1
     */
    public void dp(TreeNode root, List<Integer> list){
        if (root == null) return;
        dp(root.left,list);
        list.add(root.val);
        dp(root.right,list);
    }
    public int kthSmallest(TreeNode root, int k) {

        ArrayList<Integer> list = new ArrayList<>();
        dp(root,list);
        return list.get(k);
    }


}
