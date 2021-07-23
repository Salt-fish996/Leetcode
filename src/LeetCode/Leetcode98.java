package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hyy
 * @date 2019/9/12 8:42
 */
public class Leetcode98 {

    //中序遍历
    public void midCheck(TreeNode root, List<Integer> array){
        if (root == null) return;
        midCheck(root.left,array);
        array.add(root.val);
        midCheck(root.right,array);
    }
    public boolean isValidBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        midCheck(root,list);
        for (int i = 0; i < list.size()-1; i++) {
            if (list.get(i+1) < list.get(i)) return false;
        }
        return true;
    }
}
