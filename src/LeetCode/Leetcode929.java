package src.LeetCode;

import java.util.HashSet;
import java.util.Set;

public class Leetcode929 {
    public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();
        int res = 0;
        for (int i = 0; i < emails.length; i++) {
           String[] s = emails[i] .split("@");
           s[0] = s[0].replace(".","").split("\\+")[0];
           String address = s[0]+"@"+s[1];
           if (!set.contains(address)) {
               res+=1;
               set.add(address);
           }
        }
        return res;
    }
}
