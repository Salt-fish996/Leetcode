package src.LeetCode;

import java.util.*;

public class Leetcode337 {
    static HashMap<TreeNode,Integer> map = new HashMap<>();
    public int rob(TreeNode root) {
        return dfs(root,map);
    }

    public int dfs(TreeNode root, HashMap<TreeNode,Integer> map){
        if (root == null) return 0;

        //不包含根节点的值
        int right = 0;
        int left = 0;
        if (map.containsKey(root.right)) {
            right = map.get(root.right);
        }else {
            right = dfs(root.right,map);
            if (root.right != null)
            map.put(root.right,right);
        }

        if (map.get(root.left)!=null) {
            left = map.get(root.left);
        }else {
            left = dfs(root.left,map);
            if (root.left != null)
            map.put(root.left,left);
        }
        int noRoot = left + right;

        //包含根节点的值
        left = 0;
        if (root.left != null){
            if (root.left.left != null){
                if (map.containsKey(root.left.left)){
                    left += map.get(root.left.left);
                }else {
                    int temp = dfs(root.left.left,map);
                    map.put(root.left.left,temp);
                    left += temp;
                }
            }

            if (root.left.right != null){
                if (map.containsKey(root.left.right)){
                    left += map.get(root.left.right);
                }else {
                    int temp = dfs(root.left.right,map);
                    map.put(root.left.right,temp);
                    left += temp;
                }
            }
        }

        right = 0;
        if (root.right != null){
            if (root.right.left != null){
                if (map.containsKey(root.right.left)){
                    right += map.get(root.right.left);
                }else {
                    int temp = dfs(root.right.left,map);
                    map.put(root.right.left,temp);
                    right += temp;
                }
            }

            if (root.right.right != null){
                if (map.containsKey(root.right.right)){
                    right += map.get(root.right.right);
                }else {
                    int temp = dfs(root.right.right,map);
                    map.put(root.right.right,temp);
                    right += temp;
                }
            }
        }

        return Math.max(root.val + left +right,noRoot);
    }










//    static int[] big = null;
//    public int sum(ArrayList<Integer> arr, int now){
//
//        if (now > arr.size()-1) return 0;
//        int max = 0;
//        if (big[now] == 0){
//            for (int i = now+2; i < arr.size(); i++) {
//                int h = sum(arr,i);
//                if (h>max) max = h;
//            }
//        }else {
//            return arr.get(now) + big[now];
//        }
//        big[now] = max;
//        return arr.get(now) + max;
//
//    }
//    public int rob(TreeNode root) {
//
//        int sum = 0;
//        Stack<Integer> stack = new Stack<>();
//        TreeNode temp = root.left;
//        ArrayList<Integer> list = new ArrayList<>();
//        while (temp != null){
//            stack.push(temp.val);
//            if (temp.left != null){
//                temp = temp.left;
//            }else {
//                temp = temp.right;
//            }
//        }
//        while (!stack.isEmpty()){
//            list.add(stack.pop());
//        }
//        list.add(root.val);
//        temp = root.right;
//        while (temp!=null){
//            list.add(temp.val);
//            if (temp.left != null){
//                temp = temp.left;
//            }else {
//                temp = temp.right;
//            }
//        }
//
//        big = new int[list.size()];
//        return Math.max(Math.max(sum(list,0),sum(list,1)),sum(list,1));
//    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(3);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(3);
        TreeNode t5 = new TreeNode(1);
        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t3.right = t5;
        Leetcode337 leetcode337 = new Leetcode337();
    System.out.println(leetcode337.rob(t1));

        System.out.println(map.values());
        Set<TreeNode> treeNodes = map.keySet();
        int count = 0;
        for (TreeNode t:treeNodes
             ) {
            System.out.println(t.val+" = ");
        }


    }
}
