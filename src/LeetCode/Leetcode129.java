package LeetCode;

public class Leetcode129 {
    /**
     * 给定一个二叉树，它的每个结点都存放一个 0-9 的数字，每条从根到叶子节点的路径都代表一个数字。
     *
     * 例如，从根到叶子节点路径 1->2->3 代表数字 123。
     *
     * 计算从根到叶子节点生成的所有数字之和。
     *
     * 说明: 叶子节点是指没有子节点的节点。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/sum-root-to-leaf-numbers
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/
    static int SUM = 0;
    public void sum(TreeNode root, int s){
        if (root.left == null &&root.right == null){
            SUM += s*10+root.val;
            return;
        }
        if (root.left != null)
        sum(root.left,s*10+root.val);
        if (root.right != null)
        sum(root.right,s*10 +root.val);
    }
    public int sumNumbers(TreeNode root) {

        SUM = 0;//必须要重置为0，不然Leetcode官方多次调用导致SUM累加
        if (root == null) return 0;
        sum(root,0);
        return SUM;
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(4);
        TreeNode t2 = new TreeNode(9);
        TreeNode t3 = new TreeNode(0);
        TreeNode t4 = new TreeNode(5);
        TreeNode t5 = new TreeNode(1);
        t1.right = t3;
        t1.left = t2;
        t2.left = t4;
        t2.right = t5;
        Leetcode129 leetcode129 = new Leetcode129();
        System.out.println(leetcode129.sumNumbers(t1));
    }
}
