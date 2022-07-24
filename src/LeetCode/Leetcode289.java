package src.LeetCode;

import java.util.Arrays;

public class Leetcode289 {
    public int find(int[][] arr,int x,int y){
        int count = 0;
        if (x-1 >=0 && y-1 >=0){
            if (arr[x-1][y-1] == 1) count++;
        }
        if (y-1>=0){
            if (arr[x][y-1] == 1) count++;
        }
        if (x+1<arr.length && y-1>=0){
            if (arr[x+1][y-1] == 1) count++;
        }
        if (x+1<arr.length){
            if (arr[x+1][y] == 1) count++;
        }
        if (x+1<arr.length &&y+1<arr[0].length){
            if (arr[x+1][y+1] == 1) count++;
        }
        if (y+1<arr[0].length){
            if (arr[x][y+1] == 1) count++;
        }
        if (x-1>=0 && y+1<arr[0].length){
            if (arr[x-1][y+1] == 1) count++;
        }
        if (x-1>=0){
            if (arr[x-1][y] == 1) count++;
        }
        return count;
    }
    public void gameOfLife(int[][] board) {

        int[][] arr = new int[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                arr[i][j] = board[i][j];
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int temp = find(arr,i,j);
                if (temp <2) board[i][j] = 0;
                else if ((temp == 2|| temp == 3) && arr[i][j] == 1) board[i][j] = 1;
                else if (arr[i][j] == 1 &&temp >3) board[i][j] = 0;
                else if (arr[i][j] == 0 && temp == 3) board[i][j] =1;
            }
        }

    }
}
