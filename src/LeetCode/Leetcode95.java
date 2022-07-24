package src.LeetCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author hyy
 * @date 2019/12/2 13:16
 */
//通过
public class Leetcode95 {
    /**
     * @param root1 需要拷贝的目标结点
     * @param root2 拷贝后的新树的结点*/
    private void copyTree(TreeNode root1,TreeNode root2){
        //如果已经拷贝到最后了，那么返回
        if (root1.left != null){
            TreeNode node = new TreeNode(root1.left.val);
            root2.left = node;
            copyTree(root1.left,node);
        }

        if (root1.right != null){
            TreeNode node = new TreeNode(root1.right.val);
            root2.right = node;
            copyTree(root1.right,node);
        }
    }

    //这是生成所有的树
    public List<TreeNode> generateTreesAll(Set<Integer> set){
        if (set.isEmpty()){
            return null;
        }
        List<TreeNode> list = new ArrayList<>();

        for (Integer i:set
             ) {
            TreeNode rootLeft = new TreeNode(i);
            HashSet<Integer> hashSet = new HashSet<>(set);
            hashSet.remove(i);

            if (hashSet.isEmpty()){
                list.add(rootLeft);
                break;
            }
            //以一部分作为左结点，另一部分作为右节点

            Set<Integer> set1 = new HashSet<>();
            Set<Integer> set2 = new HashSet<>(hashSet);



            List<TreeNode> nodes2 = generateTrees(set2);
            for (TreeNode t2:nodes2
            ) {
                rootLeft.left = t2;
                list.add(rootLeft);
                rootLeft = new TreeNode(i);
            }

            List<TreeNode> nodes1 = null;


            for (Integer integer:hashSet
                 ) {
                set2.remove(integer);
                set1.add(integer);
                nodes1 = generateTrees(set1);
                nodes2 = generateTrees(set2);
                if (nodes2 == null){
                    for (TreeNode t2:nodes1
                    ) {
                        rootLeft.right = t2;
                        list.add(rootLeft);
                        rootLeft = new TreeNode(i);
                    }
                    continue;
                }
                for (TreeNode t1 :nodes1
                        ) {
                    for (TreeNode t2:nodes2
                         ) {
                        rootLeft.right = t1;
                        rootLeft.left = t2;
                        list.add(rootLeft);
                        rootLeft = new TreeNode(i);
                    }
                }
            }
            set.add(i);
        }
        return list;
    }


    //生成搜索树
    public List<TreeNode> generateTrees(Set<Integer> set){
        if (set.isEmpty()){
            return null;
        }
        List<TreeNode> list = new ArrayList<>();

        for (Integer i:set
        ) {
            TreeNode root = new TreeNode(i);
            HashSet<Integer> hashSet = new HashSet<>(set);
            hashSet.remove(i);

            if (hashSet.isEmpty()){
                list.add(root);
                break;
            }
            //以一部分作为左结点，另一部分作为右节点

            Set<Integer> setLeft = new HashSet<>();
            Set<Integer> setRight = new HashSet<>();
            for (Integer val:hashSet
                 ) {
                if (val < i){
                    setLeft.add(val);
                }else if (val > i){
                    setRight.add(val);
                }
            }

            List<TreeNode> leftChildren = generateTrees(setLeft);
            List<TreeNode> rightChildren = generateTrees(setRight);

            //如果左孩子为空
            if (leftChildren == null){
                for (TreeNode n :rightChildren) {
                    root.right = n;
                    list.add(root);
                    root = new TreeNode(i);
                }
            }
            //如果右孩子为空
            else if (rightChildren == null){
                for (TreeNode n:leftChildren
                     ) {
                    root.left = n;
                    list.add(root);
                    root = new TreeNode(i);
                }
            }

            else
            //如果左右孩子都不为空
            {
                for (TreeNode n1:leftChildren
                     ) {
                    for (TreeNode n2:rightChildren
                         ) {
                        TreeNode left = new TreeNode(n1.val);
                        TreeNode right  = new TreeNode(n2.val);
                        copyTree(n1,left);
                        copyTree(n2,right);
                        root.left = left;
                        root.right = right;
                        list.add(root);
                        root = new TreeNode(i);
                    }
                }
            }
        }
        return list;
    }

    public List<TreeNode> generateTrees(int n) {
        if (n == 0){
            ArrayList<TreeNode> treeNodes = new ArrayList<>();
            return treeNodes;
        }
        //创建一个set用于记录已使用的数字
        Set<Integer> set = new HashSet<>();
        for (int i = 1; i <= n; i++) {
            set.add(i);
        }

        return generateTrees(set);
    }

    public static void main(String[] args) {
        Leetcode95 leetcode95 = new Leetcode95();
        List<TreeNode> nodes = leetcode95.generateTrees(3);
        System.out.println(nodes.size());
    }
}
