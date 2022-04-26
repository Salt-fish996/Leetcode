package src.LeetCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Leetcode1239 {
    public int maxLength(List<String> arr) {
        return dfs(arr,0,new HashSet<>());
    }

    public int dfs(List<String> arr ,int index, Set<Character> set) {
        if (index == arr.size()) {
            return 0;
        }
        char[] arrs = arr.get(index).toCharArray();
        Set<Character> l = new HashSet<>();
        boolean has = false;
        for (int i = 0; i < arrs.length; i++) {
            if (!set.contains(arrs[i]) && !l.contains(arrs[i])) {
                l.add(arrs[i]);
            } else {
                has = true;
            }
        }
        if (has) {
            return dfs(arr,index+1,set);
        } else {
            int max = dfs(arr,index+1,set);
            set.addAll(l);
            max = Math.max(max,dfs(arr,index+1,set)+arrs.length);
            l.forEach(set::remove);
            return max;
        }
    }
}
