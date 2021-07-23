package LeetCode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

//解数独，通过
public class Leetcode37 {
    static char[] chars = new char[]{'0','1','2','3','4','5','6','7','8','9'};
    public boolean isValidSudoku(char[][] board) {

        int m = board.length;
        int n = board[0].length;
        Set<Character> set = new HashSet<>();//用于存储已经用过的数字
        //首先验证行
        for (int i = 0; i < m; i++) {
            set.clear();
            for (int j = 0; j < n; j++) {
                char c = board[i][j];
                if (set.contains(c)){
                    return false;
                }
                if (c>='1' && c<='9')
                    set.add(c);
            }
        }
        //验证列
        for (int i = 0; i < n; i++) {
            set.clear();
            for (int j = 0; j < m; j++) {
                char c = board[j][i];
                if (set.contains(c)){
                    return false;
                }
                if (c>='1' && c<='9')
                    set.add(c);
            }
        }

        //验证九宫格
        int mCount = m/3;
        int nCount = n/3;
        for (int i = 0; i < mCount; i++) {
            for (int j = 0; j < nCount; j++) {
                set.clear();
                for (int k = 0; k < 3; k++) {
                    for (int l = 0; l < 3; l++) {
                        char c = board[i*3 + k][j*3 + l];
                        if (set.contains(c)){
                            return false;
                        }
                        if (c>='1' && c<='9')
                            set.add(c);
                    }
                }
            }
        }
        return true;
    }
    public boolean dfs(char[][] board){
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == '.')//如果这意味还没有放数字
                {
                    Set<Character> set = new HashSet<>();//用于存放（row,low)所在的行列以及九宫格已经有过的数字
                    int row= i/3;
                    int low = j/3;
                    //九宫格
                    for (int k = 0; k < 3; k++) {
                        for (int l = 0; l < 3; l++) {
                            char c = board[3*row + k][low*3 + l];
                            if (c>='1' && c<='9') set.add(c);

                        }
                    }
                    //行
                    for (int k = 0; k < n; k++) {

                            char c = board[i][k];
                            if (c>='1' && c<='9') set.add(c);


                    }
                    //列
                    for (int k = 0; k < m; k++) {
                        char c = board[k][j];
                        if (c>='1' && c<='9') set.add(c);
                    }

                    //开始递归
                    for (int k = 1; k < 10; k++) {
                        if (!set.contains(chars[k])){
                            board[i][j] = chars[k];
                            if (isValidSudoku(board) && dfs(board)) return true;
                            board[i][j] = '.';
                        }
                    }
                    return false;


                }
            }
        }
        return true;
    }
    public void solveSudoku(char[][] board) {
        dfs(board);
    }

    public static void main(String[] args) {
        Leetcode37 leetcode37 = new Leetcode37();
        char[][] chars2 = new char[9][9];
        chars2[0] = "53..7....".toCharArray();
        chars2[1] = "6..195...".toCharArray();
        chars2[2]= ".98....6.".toCharArray();
        chars2[3] = "8...6...3".toCharArray();
        chars2[4] = "4..8.3..1".toCharArray();
        chars2[5] = "7...2...6".toCharArray();
        chars2[6] = ".6....28.".toCharArray();
        chars2[7] = "...419..5".toCharArray();
        chars2[8] = "....8..79".toCharArray();
        Scanner in = new Scanner(System.in);
        for (int i = 0; i < 9; i++) {
            chars2[i] = in.nextLine().toCharArray();
        }
        leetcode37.solveSudoku(chars2);
        for (int i = 0; i < chars2.length; i++) {
            System.out.println(Arrays.toString(chars2[i]));
        }
    }
}
