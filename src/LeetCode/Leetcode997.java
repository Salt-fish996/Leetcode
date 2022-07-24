package src.LeetCode;

public class Leetcode997 {
    public int findJudge(int N, int[][] trust) {

        if (N == 1 && trust.length == 0){
            return 1;
        }
        int[] chu = new int[N + 1];
        int[] ru = new int[N + 1];
        for (int i = 0; i < trust.length; i++) {
            chu[trust[i][0]]++;
            ru[trust[i][1]] ++;
        }
        for (int i = 0; i < N + 1; i++) {
            if (chu[i] == 0 &&ru[i] == 1){
                return i;
            }
        }
        return -1;
    }
}
