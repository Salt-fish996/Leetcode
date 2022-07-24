package src.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//组合总和 III,通过
public class Leetcode216 {
    public void dp(int n, int begin, int k, List<List<Integer>> lists, List<Integer> list,int now, int sum){
        if (k == 0){
            if (sum == now){
                List<Integer> list1 = new ArrayList<>(list);
                lists.add(list1);
            }

        }else {
            for (int i = begin; i <= n; i++) {
                list.add(i);
                dp(n,i+1,k-1,lists,list,now + i,sum);
                list.remove(Integer.valueOf(i));
            }
        }
    }
    public List<List<Integer>> combine(int n, int k,int now, int sum) {

        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        dp(n,1,k,lists,list,0,sum);
        return lists;

    }
    public List<List<Integer>> combinationSum3(int k, int n) {

        return combine(9,k,0,n);
    }

    public static void main(String[] args) {
        Leetcode216 leetcode216 = new Leetcode216();
        List<List<Integer>> lists = leetcode216.combinationSum3(3,9);
        for (List<Integer> l:lists
        ) {
            System.out.println(Arrays.toString(l.toArray()));
        }
    }
}
