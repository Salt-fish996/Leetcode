package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。通过
public class Leetcode77 {
    public void dp(int n, int begin, int k, List<List<Integer>> lists, List<Integer> list){
        if (k == 0){
            List<Integer> list1 = new ArrayList<>(list);
            lists.add(list1);
        }else {
            for (int i = begin; i <= n; i++) {
                list.add(i);
                dp(n,i+1,k-1,lists,list);
                list.remove(Integer.valueOf(i));
            }
        }
    }
    public List<List<Integer>> combine(int n, int k) {

        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        dp(n,1,k,lists,list);
        return lists;

    }


    public static void main(String[] args) {
        Leetcode77 leetcode77 = new Leetcode77();
        List<List<Integer>> lists = leetcode77.combine(4,3);
        for (List<Integer> l:lists
             ) {
            System.out.println(Arrays.toString(l.toArray()));
        }
    }
}
