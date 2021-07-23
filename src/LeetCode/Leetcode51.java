package LeetCode;

import java.util.*;

//n皇后问题,通过
public class Leetcode51 {

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
    public void dfs(String[][] strings,int row,Set<Integer> set,List<List<String>> lists){
        int n = strings.length;//行数
        if (row == n){//如果已经放到了最后一行
            List<String> list = new ArrayList<>();
            for (int i = 0; i < strings.length; i++) {
                //list.add(Arrays.toString(strings[i]).replace("[","").replace(",","").replace("]","").replace(" ",""));
                list.add(Arrays.toString(strings[i]));

            }
            lists.add(list);
        }else {
            for (int i = 0; i < n; i++) {
                if (!set.contains(i)){
                    strings[row][i] = "Q";
                    if (isSuccess(strings,row,i)){//如果可以摆放，那么摆放下一行
                        set.add(i);
                        dfs(strings,row+1,set,lists);
                        set.remove(i);
                    }
                    strings[row][i] = ".";
                }
            }
        }
    }
    public List<List<String>> solveNQueens(int n) {

        List<List<String>> lists = new ArrayList<>();
        Set<Integer> set = new HashSet<>();//用于记录已经放过皇后的位置，这样可以保证行不会冲突，那么只需要检测斜对角线以及列了
        String[][] strings = new String[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                strings[i][j] = ".";
            }
        }
        dfs(strings,0,set,lists);
        return lists;
    }


    public static void main(String[] args) {
        Leetcode51 leetcode51 = new Leetcode51();
        List<List<String>> lists = leetcode51.solveNQueens(15);
        for (List<String> list: lists
             ) {
            for (String s:list
                 ) {
                System.out.println(s.toString());
            }
            System.out.println("\n");
        }
        System.out.println(lists.size());
    }
}
