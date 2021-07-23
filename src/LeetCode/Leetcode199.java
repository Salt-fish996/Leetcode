package LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Leetcode199 {
    public List<Integer> rightSideView(TreeNode root) {

        ArrayList<Integer> list = new ArrayList<>();
        if (root == null) return list;

        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<Integer> levels = new LinkedList<>();
        queue1.add(root);
        levels.add(0);
        int count = 1;
        int now = 0;
        int last = root.val;

        while (!queue1.isEmpty()){
            TreeNode t = queue1.poll();
            int level = levels.poll();

            if (level != now){
                now =level;
                list.add(last);
                count++;
            }

            last = t.val;

            if (t.left != null){
                queue1.add(t.left);
                levels.add(count);
            }
            if (t.right != null){
                queue1.add(t.right);
                levels.add(count);
            }
        }

        list.add(last);
        return list;

    }
}
