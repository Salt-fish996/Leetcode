package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class Leetcode113 {
    public void sumPath(TreeNode root,int sum,List<List<Integer>> lists,List<Integer> list){
        if (root == null ) return;
        if (root.left == null && root.right == null && sum == root.val ){
            List<Integer> list1 = new ArrayList<>(list);
            list1.add(sum);
            lists.add(list1);
            return;
        }

        if (root.left != null ){
            List<Integer> list1 = new ArrayList<>(list);
            list1.add(root.val);
            sumPath(root.left,sum-root.val,lists,list1);
        }
        if (root.right != null ){
            List<Integer> list1 = new ArrayList<>(list);
            list1.add(root.val);
            sumPath(root.right,sum-root.val,lists,list1);
        }
    }
    public List<List<Integer>> pathSum(TreeNode root, int sum) {

        List<List<Integer>> lists = new ArrayList<>();
        sumPath(root,sum,lists,new ArrayList<>());
        return lists;
    }
}
