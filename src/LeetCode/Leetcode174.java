package src.LeetCode;

import java.util.ArrayList;


//这道题的动态规划思想很厉害，很有意思
public class Leetcode174 {
    int min = Integer.MIN_VALUE;
    public void dfs(int[][] arr, int x, int y,int minestLong,int now,int[][] minest){

        if ((Math.min(minestLong, now + arr[x][y]))<= minest[x][y] && minest[x][y] != 0) return;
        else {
            int h = Math.min(minestLong,now + arr[x][y]);
            if (h>minest[x][y])
            minest[x][y] = h;
        }
        if (x == arr.length -1 && y == arr[0].length-1){
            min = Math.max(min,Math.min(minestLong,now + arr[x][y]));
        }

        if (x+1<arr.length) {
            dfs(arr, x + 1,y, Math.min(minestLong,now+ arr[x][y]),now+arr[x][y], minest);
        }
        if (y+1<arr[0].length){

            dfs(arr, x , y+1, Math.min(minestLong,now + arr[x][y]),now+arr[x][y],minest);
        }
    }
    public int calculateMinimumHP(int[][] dungeon) {


        ArrayList<Integer> list = new ArrayList<>();
        //list.add(dungeon[0][0]);
        int[][] minset = new int[dungeon.length][dungeon[0].length];

        for (int i = 0; i < minset.length; i++) {
            for (int j = 0; j < minset.length; j++) {
                minset[i] [j] = Integer.MIN_VALUE;
            }
        }
        dfs(dungeon,0,0,0,0,minset);
        return Math.abs(min)+1;
    }


    //动态规划：
    //这里很巧妙，从最后一步向上进行搜索，因为到每一步的最小血线一定大于等于1
    //minSets[i-1][j]表示从右下角开始到[i-1][j]的最小血线，那么在[i][j]需要的最少血线至少为1
    //如果从最后一步到[i+1][j]和[i][j+1]的血线大于0，意味着上一步到这个点的学线最少为min{minsets[i+1][j],minsets[i][j+1]}
    //如果在[i][j]点的dungeon[i][j]>0时，意味着加血，那么上一步到这一步的血量最少为x = min(minsets[i][j+1],minsets[i+1][j])-dungeon[i][j]
    //如果x<0,以为着在这一点加的血已经满足了下面所需，因此到这一步的血量最少为1
    //如果x>0,就意味着血量不够，那么上一步到[i][j]的最少血量应该是x
    //综上minsets[i][j] = max{1,Math.min(minSets[i+1][j],minSets[i][j+1]) - dungeon[i][j]};
    public int calculateMinimumHP2(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;
        int[][] minSets = new int[m][n];
        minSets[m-1][n-1] = dungeon[m-1][n-1]>0?1:(1+Math.abs(dungeon[m-1][n-1]));
        for (int i = m-1; i >= 0; i--) {
            for (int j = n-1; j >= 0; j--) {
                if (i == m-1){
                    if (j+1<n){
                        minSets[i][j] = Math.max(1,minSets[i][j+1] - dungeon[i][j]);
                    }
                }else if (j == n - 1){
                    minSets[i][j] = Math.max(1,minSets[i+1][j] - dungeon[i][j]);
                }else {
                    minSets[i][j] = Math.max(1,Math.min(minSets[i+1][j],minSets[i][j+1]) - dungeon[i][j]);
                }
            }
        }
        return minSets[0][0];
    }
    public static void main(String[] args) {
        Leetcode174 leetcode174 = new Leetcode174();
        int[][] a = new int[3][3];
        a[0][0] = 1;
        a[0][1] = -3;
        a[0][2] = 3;
        a[1][0] = 0;

        a[1][1] = -2;
        a[1][2] = 0;
        a[2][0] = -3;
        a[2][1] = -3;
        a[2][2] = -3;
        int[][] b = new int[2][1];
        b[0][0] = 2;
        b[1][0] = 1;
        System.out.println(leetcode174.calculateMinimumHP2(a));
        System.out.println(leetcode174.calculateMinimumHP2(b));
    }


}
