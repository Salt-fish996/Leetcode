package LeetCode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author hyy
 * @date 2019/12/3 13:15
 */
//根据中序遍历和后序遍历结果构造二叉树,通过
public class Leetcode106 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        //对于一个后序遍历序列，他的最后便利的一定是他的根节点
        //首先取出根节点的值，然后通过中序遍历，将遍历顺序分为左右子树两个子树的遍历结果，
        //左右子树分别的中序遍历结果出来以后，就可以将左右子树的后序遍历的结果也计算出来了
        int n = inorder.length;
        if (n == 0){
            return null;
        }
        //取出根节点
        int val = postorder[n - 1];
        TreeNode root = new TreeNode(val);
        //在中序遍历中找到左右子树的分界点
        int partitionMid = 0;
        int partitionPost = 0;
        Set<Integer> leftSet = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if (inorder[i] == val){
                partitionMid = i;
                break;
            }
            leftSet.add(inorder[i]);
        }
        int[] leftMid = Arrays.copyOfRange(inorder,0,partitionMid);
        int[] rightMid = Arrays.copyOfRange(inorder, Math.min((partitionMid + 1), n),n);
        int[] leftPost = new int[leftMid.length];
        int[] rightPost = new int[rightMid.length];
        int left = 0;
        int right = 0;
        for (int i = 0; i < n - 1; i++) {
            if (!leftSet.contains(postorder[i])){
                rightPost[right++] = postorder[i];
            }else {
                leftPost[left++] = postorder[i];
            }
        }
        root.left = buildTree(leftMid,leftPost);
        root.right = buildTree(rightMid,rightPost);
        return root;
    }

    public static void main(String[] args) {
        int[] a = new int[]{1,2,3,4,5,6};
        System.out.println(Arrays.toString(Arrays.copyOfRange(a, 1, 1)));
    }
}
