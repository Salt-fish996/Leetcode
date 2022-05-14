package src.LeetCode;

import java.util.*;

public class Leetcode691 {
    // 超时
    int min = 15;
    public int minStickers2(String[] stickers, String target) {
        // 统计target中的单词数目
        Map<Character,Integer> targetVoMap = new HashMap<>();
        char[] targetCharArray = target.toCharArray();
        Set<Character> set = new HashSet<>();
        Set<Character> set2 = new HashSet<>();
        for (int i = 0; i < targetCharArray.length; i++) {
            targetVoMap.put(targetCharArray[i],targetVoMap.getOrDefault(targetCharArray[i],0)+1);
            set.add(targetCharArray[i]);
            set2.add(targetCharArray[i]);
        }

        // 统计单词对应的字母数量
        List<Map<Character,Integer>> stickerLists = new ArrayList<>();
        boolean has = false;
        for (int i = 0; i < stickers.length; i++) {
            char[] sticker = stickers[i].toCharArray();
            Map<Character,Integer> map = new HashMap<>();
            for (int j = 0; j < sticker.length; j++) {
                if (set2.contains(sticker[j])) {
                    has = true;
                    set.remove(sticker[j]);
                    map.put(sticker[j],map.getOrDefault(sticker[j],0)+1);
                }
            }
            if (has) {
                stickerLists.add(map);
            }
        }

        if (set.size() > 0) {
            return -1;
        }
        this.min = Math.min(this.min,minStickDfs(stickerLists,targetVoMap,0,targetVoMap.size()));
        return this.min;
    }

    public int minStickDfs(List<Map<Character,Integer>> stickerLists,Map<Character,Integer> targetMap,int count,int noZeroCount) {
        if (count >= this.min) {
            return Integer.MAX_VALUE;
        }
        if (noZeroCount == 0) {
            return count;
        }

        for (int i = 0; i < stickerLists.size(); i++) {
            int t = noZeroCount;
            for (Map.Entry<Character, Integer> characterIntegerEntry : stickerLists.get(i).entrySet()) {
                if (targetMap.containsKey(characterIntegerEntry.getKey())) {
                   int v = targetMap.get(characterIntegerEntry.getKey());
                   int newV = v - characterIntegerEntry.getValue();
                   if (v > 0 && newV <= 0) {
                       noZeroCount--;
                   }
                   targetMap.put(characterIntegerEntry.getKey(),newV);
                }
            }
            this.min = Math.min(this.min,minStickDfs(stickerLists,targetMap,count+1,noZeroCount));
            // 恢复
            noZeroCount = t;
            for (Map.Entry<Character, Integer> characterIntegerEntry : stickerLists.get(i).entrySet()) {
                if (targetMap.containsKey(characterIntegerEntry.getKey())) {
                    int v = targetMap.get(characterIntegerEntry.getKey());
                    int newV = v + characterIntegerEntry.getValue();
                    targetMap.put(characterIntegerEntry.getKey(),newV);
                }
            }
        }
        return this.min;
    }


    Map<String, Integer> memo = new HashMap<>();
    int[][] dict;
    int n;


    public int minStickers(String[] stickers, String target) {
        n = stickers.length;
        dict = new int[n][26];
        for (int i = 0; i < n; i++) {
            for (char c : stickers[i].toCharArray()) dict[i][c - 'a']++;
        }
        memo.put("", 0);
        return dfs(target);
    }

    private int dfs(String target) {
        if (memo.containsKey(target)) return memo.get(target);
        int ans = Integer.MAX_VALUE;
        int[] cnt = new int[26];
        //统计当前target中字符的出现次数
        for (char c : target.toCharArray()) cnt[c - 'a']++;
        for (int i = 0; i < n; i++) {
            if (dict[i][target.charAt(0) - 'a'] == 0) continue;
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < 26; j++) {
                if (cnt[j] > 0) {
                    //dict[i]中有哪些字符可以对当前的target字符串有贡献，移除掉这部分贡献，拼接剩下的字符
                    //举例 thahat->aeht->th->""
                    for (int k = 0; k < Math.max(0, cnt[j] - dict[i][j]); k++) {
                        sb.append((char) ('a' + j));
                    }
                }
            }
            int t = dfs(sb.toString());
            if (t != -1) ans = Math.min(ans, t + 1);
        }
        memo.put(target, ans == Integer.MAX_VALUE ? -1 : ans);
        return memo.get(target);
    }

    public static void main(String[] args) {
        Leetcode691 l = new Leetcode691();
        System.out.println(l.minStickers(new String[]{"notice","possible"},"basicbasic"));
    }
}
