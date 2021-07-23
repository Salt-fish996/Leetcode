package LeetCode;

import java.util.*;

/**
 * @author hyy
 * @date 2019/12/3 13:35
 */
//删点成林,通过
public class Leetcode1110 {
    public List<TreeNode> delNodes(TreeNode root, Set<Integer> delNode, TreeNode father) {

        //对于要删除的每一个点，在删除他之前需要将他的父节点指向改为null
        //然后将对其儿子节点进行递归操作

        if (root == null){
            return new ArrayList<>();
        }
        List<TreeNode> result = new ArrayList<>();
        List<TreeNode> left = delNodes(root.left,delNode,root);
        List<TreeNode> right = delNodes(root.right,delNode,root);

        //如果root在删除列表当中
        //将其父节点指向设置为空
        if (delNode.contains(root.val)){
            if (father != null){
                if (father.right == root){
                    father.right = null;
                }else {
                    father.left = null;
                }
            }
        }else {
            //如果root不再被删除之列，那么可能需要将left和right合并
            right.remove(root.right);
            left.remove(root.left);
            result.add(root);
        }
        result.addAll(left);
        result.addAll(right);
        return result;

    }

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {

        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < to_delete.length; i++) {
            set.add(to_delete[i]);
        }
        return delNodes(root,set,null);
    }
}
