package src.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;

public class Leetcode173 {
    class BSTIterator {

        public ArrayList<Integer> generateArray(TreeNode root) {
            ArrayList<Integer> res = new ArrayList<>();
            if (root == null) {
                return null;
            }
            ArrayList<Integer> left = generateArray(root.left);
            ArrayList<Integer> right = generateArray(root.right);
            if (left != null) {
                res = left;
            }
            res.add(root.val);
            if (right != null) {
                res.addAll(right);
            }
            return res;
        }
        Object[] array;
        int index = 0;
        public BSTIterator(TreeNode root) {
            this.array = this.generateArray(root).toArray();
            System.out.println(Arrays.toString(this.array));
        }

        public int next() {
            int v = (int)this.array[this.index];
            this.index++;
            return v;
        }

        public boolean hasNext() {
            return this.array.length > this.index;
        }
    }
}
