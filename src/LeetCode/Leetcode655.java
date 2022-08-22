package src.LeetCode;

import com.sun.org.apache.bcel.internal.generic.LUSHR;

import java.util.ArrayList;
import java.util.List;

public class Leetcode655 {
    public List<List<String>> printTree(TreeNode root) {
        int deep = dfs(root);
        int n = (int)(Math.pow(2,deep)-1);
        List<List<String>> list = new ArrayList<>();
        for (int i = 0; i < deep; i++) {
            List<String> t = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                t.add("");
            }
            list.add(t);
        }
        dfsCal(root,0,(n-1)/2,deep-1,list);
        return list;
    }

    public int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(dfs(root.left),dfs(root.right))+1;
    }

    public void dfsCal(TreeNode root, int x, int y,int deep,List<List<String>> list) {
        if (root == null) {
            return;
        }
        list.get(x).set(y,Integer.toString(root.val));
            dfsCal(root.left,x+1,y-(int)(Math.pow(2,deep-x-1)),deep,list);
            dfsCal(root.right,x+1,y+(int)Math.pow(2,deep-x-1),deep,list);
    }

    public static void main(String[] args) {
        Leetcode655 l = new Leetcode655();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        System.out.println(l.printTree(root));
    }
}
