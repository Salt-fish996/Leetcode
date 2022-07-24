package src.LeetCode;

import java.util.Arrays;

public class Leetcode105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        if (preorder.length ==  0) return null;
        TreeNode node = new TreeNode(preorder[0]);

        if (preorder.length == 1){
            return node;
        }
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == preorder[0])//区分左右子树
            {
                node.left = buildTree(Arrays.copyOfRange(preorder,1,1+i),Arrays.copyOfRange(inorder,0,i));
                node.right = buildTree(Arrays.copyOfRange(preorder,1+i,preorder.length),Arrays.copyOfRange(inorder,i+1,inorder.length));
            }
        }
        return node;
    }


    public static void main(String[] args) {
        Leetcode105 leetcode105 = new Leetcode105();
        int[] pre = new int[]{3,9,20,15,7};
        int[] ino = new int[]{9,3,15,20,7};
        TreeNode node = leetcode105.buildTree(pre,ino);
    }
}
