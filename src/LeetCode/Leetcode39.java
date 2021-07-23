package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode39 {
    /*
    * 思路：
    * 对于每选定一个数，那么可以遍历它后面的
    * 然后直到找到一个等于目标值的数组*/
    public void findSum(int[] arr, int now, List<Integer> list, int target,List<List<Integer>> lists){
        if (target == arr[now]){
            list.add(arr[now]);
            List<Integer> list1 = new ArrayList<>();
            list1.addAll(list);
            lists.add(list1);
            list.remove(list.size()-1);
            return;
        }
        if (arr[now] > target) return;
        //now表示现在已经遍历到的数所在的位置
        list.add(arr[now]);
        for (int i = now; i < arr.length; i++) {
            findSum(arr,i,list,target-arr[now],lists);
        }
        list.remove(list.size()-1);
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);

        List<List<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < candidates.length; i++) {
            findSum(candidates,i,new ArrayList<>(),target,lists);
        }

        return lists;
    }

    public static void main(String[] args) {
        int[] a = new int[]{2,3,5};
        Leetcode39 leetcode39 = new Leetcode39();
        System.out.println(leetcode39.combinationSum(a,8));

    }
}
