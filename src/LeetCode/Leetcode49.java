package LeetCode;

import java.util.*;

public class Leetcode49 {
    /**
     * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
     *
     * 示例:
     *
     * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
     * 输出:
     * [
     *   ["ate","eat","tea"],
     *   ["nat","tan"],
     *   ["bat"]
     * ]
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/group-anagrams
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/
    public List<List<String>> groupAnagrams(String[] strs) {

        String[] strings = strs.clone();
        //System.out.println(strings == strs);
        Map<String,List<String>> map = new HashMap();
        for (int i = 0; i < strings.length; i++) {
            char[] chars = strings[i].toCharArray();
            Arrays.sort(chars);

            strings[i] =  Arrays.toString(chars);
            //System.out.println(strings[i]);
            if (map.get(strings[i])!=null){
                map.get(strings[i]).add(strs[i]);
            }else{
                List<String> list = new ArrayList<>();
                list.add(strs[i]);
                map.put(strings[i],list);
            }
        }

        List<List<String>> lists = new ArrayList<>();
        lists.addAll(map.values());
        return lists;
    }

    public static void main(String[] args) {
        Leetcode49 leetcode49 = new Leetcode49();
        String[] strings = new String[]{"eat","tea","tan","ate","nat","bat"};
        System.out.println(leetcode49.groupAnagrams(strings));;
    }
}
