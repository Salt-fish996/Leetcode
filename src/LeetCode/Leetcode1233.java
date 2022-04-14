package src.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode1233 {
    public List<String> removeSubfolders(String[] folder) {
        Arrays.sort(folder);
        List<String> res = new ArrayList<>();
        if (folder.length == 0) {
            return res;
        }
        String s = folder[0];
        res.add(s);
        for (int i = 1; i < folder.length; i++) {
            if (!folder[i].startsWith(s+"/")) {
                res.add(folder[i]);
                s = folder[i];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Leetcode1233 l = new Leetcode1233();
        System.out.println(l.removeSubfolders(new String[]{"/a","/a/b","/c/d","/c/d/e","/c/f"}));
    }
}
