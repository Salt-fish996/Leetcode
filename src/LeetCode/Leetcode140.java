package src.LeetCode;

import java.util.*;

//单词划分，使用记忆搜索即可完成
public class Leetcode140 {
    //map表示从i开始可以的所有字符串
    //dfs返回从i开始的所有字符串组成
    public List<String> dfs(String s, int index, List<String> wordDict, HashMap<Integer, List<String>> map) {

        List<String> list = new ArrayList<>();//用于记录从index开始的所有划分
        //如果已经划分完了
        if (index == s.length()){
            return list;
        }
        //如果已经计算过了从index开始的划分
        if (map.get(index) != null){
            return map.get(index);
        }
        //进行划分
        for (String str:wordDict
             ) {
            //遍历字典，找出从index匹配的单词
            int n = str.length();
            if (index + n <= s.length() && s.substring(index, index + n).equals(str)){
                //temp用于记录从index+n开始的所有组合
                List<String> temp = dfs(s,index + n, wordDict,map);
                //将从index+n开始的所有单词划分加入map，即使返回的组合是空也要加入
                map.put(index + n, temp);
                //将返回的所有划分加上前缀加入到list中返回
                for (String str1:temp
                     ) {
                    list.add(str + " "+str1);
                }
                //这里需要注意，如果返回的列表为空表示从index+n开始可能没有能够划分的字符串，
                //但还有一种情况是index+n已经是字符串s的最后一位的坐标+1了，这样的话需要将str加入list返回
                if (temp.size() == 0 && index + n >= s.length()) {
                    list.add(str);
                }
            }
        }
        return list;
    }
    public List<String> wordBreak(String s, List<String> wordDict) {

        List<String> list = new ArrayList<>();
        HashMap<Integer,List<String>> hashMap = new HashMap<>();
        return dfs(s,0,wordDict,hashMap);
    }
    public static void main(String[] args) {
        Leetcode140 leetcode140 = new Leetcode140();
//        String[] s = new String[]{ "a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"};
//        List<String> list = new ArrayList<String>(Arrays.asList(s));
//        List<String> re = leetcode140.wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",list);

        String[] s = new String[]{ "cat", "cats", "and", "sand", "dog"};
        List<String> list = new ArrayList<String>(Arrays.asList(s));
        List<String> re = leetcode140.wordBreak("catsanddog",list);

        System.out.println(Arrays.toString(re.toArray()));
    }
}
