package LeetCode;

import java.util.*;

public class Leetcode52 {
    static int count = 0;
    public boolean isSuccess(String[][] strings,int row,int low){
        int m = strings.length;
        int n = strings[0].length;
        //检测列
        for (int i = 0; i < row; i++) {
            if (strings[i][low].equals("Q")){//如果有冲突，那么直接返回不可以
                return false;
            }
        }

        //检测左上
        for (int i = row - 1,j = low - 1; i >= 0 && j>=0; i--,j--) {
            if (strings[i][j].equals("Q")){//如果左上有皇后，那么返回失败
                return false;
            }
        }
        //检测右上
        for (int i = row - 1, j = low + 1 ; i >=0 && j<n ; i--,j++) {
            if (strings[i][j].equals("Q")){
                return false;
            }
        }
        return true;
    }
    public void dfs(String[][] strings, int row, Set<Integer> set){
        int n = strings.length;//行数
        if (row == n){//如果已经放到了最后一行
            count++;
        }else {
            for (int i = 0; i < n; i++) {
                if (!set.contains(i)){
                    strings[row][i] = "Q";
                    if (isSuccess(strings,row,i)){//如果可以摆放，那么摆放下一行
                        set.add(i);
                        dfs(strings,row+1,set);
                        set.remove(i);
                    }
                    strings[row][i] = ".";
                }
            }
        }
    }
    public int totalNQueens(int n) {
        count = 0;

        Set<Integer> set = new HashSet<>();//用于记录已经放过皇后的位置，这样可以保证行不会冲突，那么只需要检测斜对角线以及列了
        String[][] strings = new String[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                strings[i][j] = ".";
            }
        }
        dfs(strings,0,set);
        return count;
    }

    public static void main(String[] args) {
        Leetcode52 leetcode52 = new Leetcode52();
        System.out.println(leetcode52.totalNQueens(1));
    }
}
