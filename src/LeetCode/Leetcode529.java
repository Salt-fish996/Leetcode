package LeetCode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author hyy
 * @date 2019/12/3 12:17
 */

//扫雷游戏，通过，53.98%
public class Leetcode529 {
    static int[][] dir = new int[][]{{1,0},{-1,0},{0,1},{0,-1},{1,1},{1,-1},{-1,1},{-1,-1}};
    //检查(x,y)的8个方向的位置，返回周边的地雷数
    private int check(char[][] boards,int x,int y,Queue<Integer> queueX,Queue<Integer> queueY,int[][] states){
        int m = boards.length;
        int n = boards[0].length;
        int count = 0;
        for (int i = 0; i < 8; i++) {
            if (x + dir[i][0] >= 0 && x + dir[i][0] < m && y + dir[i][1] >= 0 && y + dir[i][1] < n){

             if (boards[x + dir[i][0]][y + dir[i][1]] == 'M'){
                count++;
                }
            }
        }
        if (count == 0){
            for (int i = 0; i < 8; i++) {
                if (x + dir[i][0] >= 0 && x + dir[i][0] < m && y + dir[i][1] >= 0 && y + dir[i][1] < n){
                    if (boards[x + dir[i][0]][y + dir[i][1]] == 'E' && states[x + dir[i][0]][y + dir[i][1]] == 0){
                        states[x + dir[i][0]][y + dir[i][1]] = 1;
                        queueX.add(x + dir[i][0]);
                        queueY.add(y + dir[i][1]);
                    }
                }
            }
        }
        return count;
    }

    //使用广度遍历
    public char[][] updateBoard(char[][] board, int[] click) {

        int m = board.length;
        int n = board[0].length;
        //记录横坐标
        Queue<Integer> queueX = new LinkedList<>();
        //记录纵坐标
        Queue<Integer> queueY = new LinkedList<>();
        //初始点击点入队
        queueX.add(click[0]);
        queueY.add(click[1]);
        //检查点击位置，如果第一次就点击到了雷，那么直接修改后返回
        if (board[click[0]][click[1]] == 'M'){
            board[click[0]][click[1]] = 'X';
            return board;
        }
        int[][] states = new int[m][n];
        states[click[0]][click[1]] = 1;

        while (!queueX.isEmpty() && !queueY.isEmpty()){
            //取出点(x,y)
            int x = queueX.poll();
            int y = queueY.poll();
            //对于一个点来说，要检查他的上下左右以及斜对角线有没有地雷，如果有地雷，那么计算以后将数字写入该位置
            int count = check(board,x,y,queueX,queueY,states);
            //如果周围没有地雷
            if (count == 0){
                board[x][y] = 'B';
            }else {
                board[x][y] = (char) ('0' + count);
            }

        }
        return board;
    }

    public static void main(String[] args) {
        Leetcode529 leetcode529 = new Leetcode529();
        char[][] a = new char[][]{{'E', 'E', 'E', 'E', 'E'},
                {'E', 'E', 'M', 'E', 'E'},
                {'E', 'E', 'E', 'E', 'E'},
                {'E', 'E', 'E', 'E', 'E'}};
        leetcode529.updateBoard(a,new int[]{3,0});
        for (int i = 0; i < a.length; i++) {
            System.out.println(Arrays.toString(a[i]));
        }
    }
}
