package src.LeetCode;

import java.util.*;

public class Leetcode1161 {
    //bfs
    public int maxLevelSum(TreeNode root) {

        Queue<TreeNode> queue1 = new LinkedList<>();//存储结点
        Queue<Integer>  levels = new LinkedList<>();//存储层数
        TreeMap<Integer,Integer> sums = new TreeMap<>();
        queue1.add(root);
        levels.add(1);
        while (!queue1.isEmpty()){
            int level = levels.poll();
            TreeNode node = queue1.poll();

            if (sums.get(level) == null){
                sums.put(level,node.val);
            }else {
                sums.put(level,sums.get(level) + node.val);
            }
            if (node.left != null){
                queue1.add(node.left);
                levels.add(level + 1);
            }

            if (node.right != null){
                queue1.add(node.right);
                levels.add(level + 1);
            }
        }

        int max = 0;
        for (Integer s:sums.values()
             ) {
            max = Math.max(s,max);
        }
        for (Integer s:sums.keySet()
             ) {
            if (sums.get(s) == max) return s;
        }
return -1;
    }
}
