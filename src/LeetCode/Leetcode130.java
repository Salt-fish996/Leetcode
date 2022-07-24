package src.LeetCode;

/**
 * @author hyy
 * @date 2019/8/9 20:49
 */
public class Leetcode130 {
    public void solve(char[][] board) {
        if (board.length>0) {
            int longth = board.length;//长度
            int width = board[0].length;//宽度
            System.out.println(longth+"  "+width);

            //首先查找所有边上的0
            for (int i = 0; i < width; i++) {
                if (board[0][i] == 'O') {//&& (longth<=1 ||board[1][i] == '0')){
                    board[0][i] = '1';//表示已经访问过
                    DFS(board, 0, i,width,longth);

                }
            }
            for (int i = 0; i < longth ; i++) {
                if (board[i][0] == 'O'){ //&& (width<=1 || board[i][1] == '0')){
                    board[i][0] = '1';
                    DFS(board,i,0,width,longth);
                }
            }
            for (int i = 0; i < longth ; i++) {
                if (board[i][width-1] == 'O'){
                    board[i][width-1] = '1';
                    DFS(board,i,width-1,width,longth);
                }
            }
            for (int i = 0; i < width; i++) {
                if (board[longth-1][i] == 'O'){
                    board[longth-1][i] = '1';
                    DFS(board, longth-1, i,width,longth);
                }
            }
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    if (board[i][j] == '1'){
                        board[i][j] = 'O';
                    }else if (board[i][j] == 'O'){
                        board[i][j] = 'X';
                    }
                }
            }
        }
    }
    public void DFS(char[][] board,int x, int y,int width,int longth){
        if (x - 1 >=0 && board[x-1][y] == 'O' && board[x-1][y] != '1'){
            board[x-1][y] = '1';
            DFS(board,x-1,y,width,longth);
        }

        if (x + 1 < longth && board[x+1][y] == 'O' && board[x+1][y] != '1'){
            board[x+1][y] = '1';
            DFS(board,x+1,y,width,longth);
        }
        if (y - 1 >= 0 && board[x][y-1] == 'O' && board[x][y-1] != '1'){
            board[x][y-1] = '1';
            DFS(board,x,y-1,width,longth);
        }
        if (y + 1 < width && board[x][y+1] == 'O' && board[x][y+1] != '1'){
            board[x][y+1] = '1';
            DFS(board,x,y+1,width,longth);
        }
    }

    public static void main(String[] args) {
        char[][] chars = new char[][]{{'X','O','X','O','X','O'},{'O','X','O','X','O','X'},{'X','O','X','O','X','O'},{'O','X','O','X','O','X'}};
        //char[][] chars = new char[][]{{'O'}};
        Leetcode130 leetcode130 = new Leetcode130();
        leetcode130.solve(chars);
        for (int i = 0; i < chars.length; i++) {
            for (int j = 0; j < chars[0].length; j++) {
                System.out.print(chars[i][j]+"  ");
            }
            System.out.println();
        }
    }
}
