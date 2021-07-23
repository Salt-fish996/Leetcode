package LeetCode;

import java.util.*;

/**
 * @author hyy
 * @date 2019/11/22 12:59
 */
//推箱子,未通过
public class Leetcode1263 {
    static int minCount = Integer.MAX_VALUE;
    //检测在
    public boolean dfs(char[][] grid, int player_row, int player_col, int box_row, int box_col,int[][] state,int BI,int BJ){

       // System.out.println("dfs:player_row="+player_row + " player_col="+player_col + " box_row="+box_row+" box_col="+box_col);

        //如果越界，直接返回false
        if (box_row <0 || box_row >= grid.length || box_col < 0 || box_col >= grid[0].length){
            return false;
        }
        if (player_row <0 || player_row >= grid.length || player_col < 0 || player_col >= grid[0].length){
            return false;
        }
        //无论是人物所在位置还是人物要到达的位置是墙壁，直接返回false
        //并且不能够越过箱子
        if (grid[player_row][player_col] == '#' || grid[box_row][box_col] == '#' || (player_row == BI && player_col == BJ)){
            return false;
        }

        //如果已经到达要到达的点了，那么返回true
        if (player_row == box_row && player_col == box_col){
            return true;
        }


        state[player_row][player_col] = 1;
        //人物向四个方向出发
        boolean result = false;
        if (player_row + 1 < grid.length && grid[player_row+1][player_col] != '#'&&state[player_row + 1][player_col] != 1){
            result = dfs(grid,player_row+1,player_col,box_row,box_col,state,BI,BJ);
        }
        if (result){
            return true;
        }
        if (player_row -1 >= 0 &&grid[player_row-1][player_col] != '#'&&state[player_row - 1][player_col] != 1){
            result = dfs(grid,player_row-1,player_col,box_row,box_col,state,BI,BJ);
        }
        if (result){
            return true;
        }
        if (player_col + 1 < grid[0].length &&grid[player_row][player_col + 1] != '#'&&state[player_row ][player_col + 1] != 1){
            result = dfs(grid,player_row,player_col + 1,box_row,box_col,state,BI,BJ);
        }
        if (result){
            return true;
        }
        if (player_col - 1 >= 0 &&grid[player_row][player_col - 1] != '#'&&state[player_row][player_col - 1] != 1){
            result = dfs(grid,player_row,player_col - 1,box_row,box_col,state,BI,BJ);
        }

        return result;
    }

    //计算找到箱子所需要的推动次数
    public void findBox(char[][] grid, int player_row, int player_col, int box_row, int box_col,int target_row,int target_col,int nowCounts,int[][] states){


        //用队列来做
        Queue<List<Integer>> queue = new LinkedList<>();
        //队列中存储人当前的坐标和箱子的坐标
        //再用一个队列在存储推动次数
        Queue<Integer> counts = new LinkedList<>();
        //初始化
        List<Integer> list = new ArrayList<>();
        list.add(player_row);
        list.add(player_col);
        list.add(box_row);
        list.add(box_col);
        queue.add(list);
        counts.add(0);

        while (!queue.isEmpty()){
            List<Integer> list1 = queue.poll();
            player_row = list1.get(0);
            player_col = list1.get(1);
            box_row = list1.get(2);
            box_col = list1.get(3);
            int count = counts.poll();
            //System.out.println("player_row="+player_row + " player_col="+player_col + " box_row="+box_row+" box_col="+box_col+" target_row="+target_row+" target_col="+target_col);


            if (box_row == target_row && box_col == target_col){
                minCount = count;
                return;
            }

            if (count >= 10){
                continue;
            }
            //把箱子往上推
            if (box_row - 1>=0 && grid[box_row - 1][box_col] !='#'&&dfs(grid,player_row,player_col,box_row + 1,box_col,new int[grid.length][grid[0].length],box_row,box_col)){
                System.out.println("从【"+box_row+","+box_col+"】向上推");
                ArrayList<Integer> list2 = new ArrayList<>();
                list2.add(box_row);
                list2.add(box_col);
                list2.add(box_row - 1);
                list2.add(box_col);
                counts.add(count + 1);
                queue.add(list2);
            }

            //把箱子往下推
            if (box_row + 1< grid.length && grid[box_row + 1][box_col] !='#'&&dfs(grid,player_row,player_col,box_row - 1,box_col,new int[grid.length][grid[0].length],box_row,box_col)){
                System.out.println("从【"+box_row+","+box_col+"】向下推");
                ArrayList<Integer> list2 = new ArrayList<>();
                list2.add(box_row);
                list2.add(box_col);
                list2.add(box_row + 1);
                list2.add(box_col);
                counts.add(count + 1);
                queue.add(list2);
            }

            //把箱子往左推
            if (box_col - 1>=0 && grid[box_row][box_col - 1] !='#'&&dfs(grid,player_row,player_col,box_row,box_col + 1,new int[grid.length][grid[0].length],box_row,box_col)){
                System.out.println("从【"+box_row+","+box_col+"】向左推");
                ArrayList<Integer> list2 = new ArrayList<>();
                list2.add(box_row);
                list2.add(box_col);
                list2.add(box_row);
                list2.add(box_col - 1);
                counts.add(count + 1);
                queue.add(list2);
            }
            //把箱子往右推
            if (box_col + 1<grid[0].length && grid[box_row][box_col + 1] !='#'&&dfs(grid,player_row,player_col,box_row,box_col - 1,new int[grid.length][grid[0].length],box_row,box_col)){
                System.out.println("从【"+box_row+","+box_col+"】向右推");
                ArrayList<Integer> list2 = new ArrayList<>();
                list2 = new ArrayList<>();
                list2.add(box_row);
                list2.add(box_col);
                list2.add(box_row);
                list2.add(box_col + 1);
                counts.add(count + 1);
                queue.add(list2);
            }
        }
//        //System.out.println("findBox:player_row="+player_row + " player_col="+player_col + " box_row="+box_row+" box_col="+box_col+" target_row="+target_row+" target_col="+target_col);
//        boolean up = false,down = false,left = false,right = false;
//        int[][] state = new int[grid.length][grid[0].length];
//        //如果推动箱子的次数已经大于了计算出来的最少次数了，那么就不用再计算了
//        if (nowCounts >= minCount){
//            return;
//        }
//        //如果箱子正好在目标点上方,并且玩家可以到达箱子上方的位置，那么直接返回1
//        if ((up = dfs(grid,player_row,player_col,box_row - 1,box_col,state)) && box_row == target_row - 1 && box_col == target_col){
//            minCount = Math.min(nowCounts+1, minCount);
//            return;
//        }
//
//        state = new int[grid.length][grid[0].length];
//        //如果箱子正好在目标点下方,并且玩家可以到达箱子下方的位置，那么直接返回1
//        if ( (down = dfs(grid,player_row,player_col,box_row + 1,box_col,state)) && box_row == target_row + 1 && box_col == target_col){
//            minCount = Math.min(nowCounts+1, minCount);
//            return;
//        }
//
//        state = new int[grid.length][grid[0].length];
//        //如果箱子正好在目标点左方,并且玩家可以到达箱子左方的位置，那么直接返回1
//        if ((left = dfs(grid,player_row,player_col,box_row,box_col - 1,state)) && box_row == target_row && box_col == target_col - 1){
//            minCount = Math.min(nowCounts+1, minCount);
//            return;
//        }
//
//        state = new int[grid.length][grid[0].length];
//        //如果箱子正好在目标点右方,并且玩家可以到达箱子右方的位置，那么直接返回1
//        if ((right = dfs(grid,player_row,player_col,box_row,box_col + 1,state)) && box_row == target_row && box_col == target_col + 1){
//            minCount = Math.min(nowCounts+1, minCount);
//            return;
//        }
//        //System.out.println("up="+up+" down="+down+" left="+left+" right="+right);
//        states[box_row][box_col] = 1;
//
//        //下面向四个方向推
//        if (box_row + 1 < grid.length && up && states[box_row + 1][box_col] != 1 && states[box_row + 1][box_col]!='#'){
//            //能够到上面
//            grid[box_row][box_col] = 'S';
//            grid[box_row + 1][box_col] = 'B';
//            grid[player_row][player_col] = '.';
//            findBox(grid,box_row,box_col,box_row + 1,box_col,target_row,target_col,nowCounts + 1,states);
//            grid[box_row][box_col] = 'B';
//            grid[box_row + 1][box_col] = '.';
//            grid[player_row][player_col] = 'S';
//        }
//
//        if (box_row - 1>=0&&down && states[box_row - 1][box_col] != 1 &&grid[box_row - 1][box_col] != '#'){
//            //能够到下面
//            grid[box_row][box_col] = 'S';
//            grid[box_row - 1][box_col] = 'B';
//            grid[player_row][player_col] = '.';
//            findBox(grid,box_row,box_col,box_row - 1,box_col,target_row,target_col,nowCounts + 1,states);
//            grid[box_row][box_col] = 'B';
//            grid[box_row - 1][box_col] = '.';
//            grid[player_row][player_col] = 'S';
//        }
//
//        if (box_col + 1 <grid[0].length &&left && states[box_row][box_col + 1] != 1 &&states[box_row][box_col + 1] !='#'){
//            //能够到左
//            grid[box_row][box_col] = 'S';
//            grid[box_row][box_col + 1] = 'B';
//            grid[player_row][player_col] = '.';
//            findBox(grid,box_row,box_col,box_row ,box_col +1,target_row,target_col,nowCounts + 1,states);
//            grid[box_row][box_col] = 'B';
//            grid[box_row][box_col + 1] = '.';
//            grid[player_row][player_col] = 'S';
//        }
//
//        if (box_col -1 >=0 && right && states[box_row][box_col - 1] != 1 &&grid[box_row][box_col - 1] !='#'){
//            //能够到右面
//            grid[box_row][box_col] = 'S';
//            grid[box_row][box_col - 1] = 'B';
//            grid[player_row][player_col] = '.';
//            findBox(grid,box_row,box_col,box_row ,box_col - 1,target_row,target_col,nowCounts + 1,states);
//            grid[box_row][box_col] = 'B';
//            grid[box_row][box_col - 1] = '.';
//            grid[player_row][player_col] = 'S';
//        }

    }
    public int minPushBox(char[][] grid) {

        int row = grid.length;
        int col = grid[0].length;
        //首先找出人物位置、箱子位置、目标位置
        int player_row = -1,player_col = -1,box_row = -1,box_col = -1,target_row = -1,target_col = -1;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 'S'){
                    player_row = i;
                    player_col = j;
                }else if (grid[i][j] == 'B'){
                    box_col = j;
                    box_row = i;
                }else if (grid[i][j] == 'T'){
                    target_row = i;
                    target_col = j;
                }
            }
        }
        int[][] state = new int[grid.length][grid[0].length];

        minCount = Integer.MAX_VALUE;
        findBox(grid,player_row,player_col,box_row,box_col,target_row,target_col,0,state);
        return minCount == Integer.MAX_VALUE?-1:minCount;
    }

    public static void main(String[] args) {
       Leetcode1263 leetcode1263 = new Leetcode1263();
       char[][] g = new char[6][9];
//       g[0] = new char[]{'#','#','#','#','#','#','#'};
//        g[1] = new char[]{'#','T','#','#','#','#','#'};
//        g[2] = new char[]{'#','.','.','B','.','#','#'};
//        g[3] = new char[]{'#','.','#','#','.','#','#'};
//        g[4] = new char[]{'#','.','.','.','S','#','#'};
//        g[5] = new char[]{'#','#','#','#','#','#','#'};
        g[0] = new char[]{'#','.','.','#','T','#','#','#','#'};
        g[1] = new char[]{'#','.','.','#','#','#','.','.','.'};
        g[2] = new char[]{'#','.','.','#','.','#','.','.','#'};
        g[3] = new char[]{'#','.','.','.','B','.','.','.','.'};
        g[4] = new char[]{'#','.','.','.','.','#','.','S','#'};
        g[5] = new char[]{'#','.','.','#','.','#','#','#','#'};
        long time = System.currentTimeMillis();
        System.out.println(leetcode1263.minPushBox(g)+" 时间："+(System.currentTimeMillis() - time));
//        Scanner in = new Scanner(System.in);
//        String s = "";
//        String temp = null;
//        while (!(temp = in.nextLine()).equals("0")){
//            s += temp;
//            temp = null;
//        }
//        s = s.replace(" ","");
//        String[] strings = s.split("]");
//        System.out.println(Arrays.toString(strings));
    }
}
