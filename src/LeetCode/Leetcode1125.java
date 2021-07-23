package LeetCode;

import java.util.*;

/**
 * @author hyy
 * @date 2019/11/28 10:32
 */
//最小必要团队,通过
public class Leetcode1125 {
    static List<Integer> lResult = null;
    static int minCount = Integer.MAX_VALUE;
    public void dfs(String[] req_skills, List<List<String>> people, int index, List<Integer> integers, Set<String> hasContain, HashMap<String,List<Integer>> hashMap){
        //integers表示已经包含的人物
        //hasContain表示已经包含的
        //index表示已经到req_skills的第几个位置了

        //如果当前的people人数已经大于要选择的了，那么直接返回，进行剪枝
        if (integers.size() >= minCount){
            return;
        }

        //进行当前状态的检查
        for (int i = index; i < req_skills.length; i++) {
            if (hasContain.contains(req_skills[i])){
                index++;
            }else break;
        }

        //如果匹配完成了
        if (index == req_skills.length){
            minCount = integers.size();
            lResult = new ArrayList<>(integers);
            return;
        }

        //取得所有能够匹配当前字符串的人
        List<Integer> list = hashMap.get(req_skills[index]);
        //递归
        for (Integer i:list
             ) {
            integers.add(i);
            Set<String> strings = new HashSet<>(hasContain);
            strings.addAll(people.get(i));
            dfs(req_skills,people,index + 1,integers,strings,hashMap);
            integers.remove(i);
        }

    }
    public int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {

        lResult = null;
        minCount =Integer.MAX_VALUE;
        //使用hashMap<String,List>来记录每一个技能的人员
        HashMap<String,List<Integer>> recordPeopleOfSkill = new HashMap<>();
        //使用peopleList记录当前的人
        List<Integer> peopleList = new ArrayList<>();
        //使用set记录当前状态
        Set<String> strings = new HashSet<>();
        //初始化
        for (int i = 0; i < people.size(); i++) {
            List<String> list = people.get(i);
            for (String s:list
                 ) {
                if (recordPeopleOfSkill.get(s) == null){
                    List<Integer> list2 = new ArrayList<>();
                    list2.add(i);
                    recordPeopleOfSkill.put(s,list2);
                }else {
                    List<Integer> list1 = recordPeopleOfSkill.get(s);
                    list1.add(i);
                    recordPeopleOfSkill.put(s, list1);
                }
            }
        }
        dfs(req_skills,people,0,peopleList,strings,recordPeopleOfSkill);

        if (lResult == null){
            return null;
        }
        else {
            int[] result = new int[lResult.size()];
            for (int i = 0; i < lResult.size(); i++) {
                result[i] = lResult.get(i);
            }
            return result;
        }
    }


    public static void main(String[] args) {
        Leetcode1125 leetcode1125 = new Leetcode1125();
        List<List<String>> lists = new ArrayList<>();
        List<String> list = new ArrayList<>();
        list.add("algorithms");
        list.add("math");
        list.add("java");
        lists.add(list);
        list = new ArrayList<>();
        list.add("algorithms");
        list.add("math");
        list.add("reactjs");
        lists.add(list);
        list = new ArrayList<>();
        list.add("java");
        list.add("csharp");
        list.add("aws");
        lists.add(list);
        list = new ArrayList<>();
        list.add("reactjs");
        list.add("csharp");
        lists.add(list);
        list = new ArrayList<>();
        list.add("math");
        list.add("csharp");
        lists.add(list);
        list = new ArrayList<>();
        list.add("aws");
        list.add("java");
        lists.add(list);
        String[] strings = new String[]{"algorithms","math","java","reactjs","csharp","aws"};
        System.out.println(Arrays.toString(leetcode1125.smallestSufficientTeam(strings, lists)));

    }
}
