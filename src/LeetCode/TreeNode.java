package src.LeetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author hyy
 * @date 2019/8/6 21:08
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    TreeNode(int x) { val = x; }

    public TreeNode GenerateTree(Integer[] nodes) {
        List<TreeNode> list = new ArrayList<>();
        for (int i = 0; i < nodes.length; i++) {
            if (nodes[i] != null) {
                list.add(new TreeNode(nodes[i]));
            } else {
                list.add(null);
            }
        }
        for (int i = 0; i < nodes.length; i++) {
            TreeNode n = list.get(i);
            if (n != null && 2 * i < nodes.length) {
                n.left = (list.get(2*i));
            }
            if (n != null && 2*i + 1 < nodes.length) {
                n.right = (list.get(2*i+1));
            }
        }
        return list.get(0);
    }
}
