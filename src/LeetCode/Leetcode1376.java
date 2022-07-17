package src.LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Leetcode1376 {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        // 使用map来记录员工的下属
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < manager.length; i++) {
            if (manager[i] == -1) {
                continue;
            }
            List<Integer> subEmployee = map.getOrDefault(manager[i],new ArrayList<>());
            subEmployee.add(i);
            map.put(manager[i],subEmployee);
        }
        return dfs(map,headID,informTime);
    }

    public int dfs(Map<Integer,List<Integer>> map,int headerId,int[] informTime) {
        if (!map.containsKey(headerId)) {
            return 0;
        }
        List<Integer> l = map.get(headerId);
        int res = 0;
        for (int i = 0; i < l.size(); i++) {
            res = Math.max(res,dfs(map,l.get(i),informTime));
        }
        return res+informTime[headerId];
    }

    public static void main(String[] args) {
        Leetcode1376 l = new Leetcode1376();
        System.out.println(l.numOfMinutes(7,6,new int[]{1,2,3,4,5,6,-1},new int[]{0,6,5,4,3,2,1}));
    }

}
