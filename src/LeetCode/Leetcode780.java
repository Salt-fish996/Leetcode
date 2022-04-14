package src.LeetCode;

public class Leetcode780 {
    public boolean reachingPoints(int sx, int sy, int tx, int ty) {
        // dp[i][j]表示x=i，y=j的点是否可以到达
        // dp[i][j]=dp[i-j][j] || dp[i][j-i]
        if (tx < 0 || ty < 0) {
            return false;
        }
        if (tx == sx && sy==ty) {
            return true;
        }
        if (tx == 0 || ty == 0) {
            return false;
        }
        // 如果 tx > ty, 那么上一次的变化一定是从（tx-ty,ty)->(tx,ty)
        while (tx > 2*ty && tx > sx) {
            int n = (tx - sx) / ty;
            if (n > 2) {
                tx -= (n-2)*ty;
            } else {
                tx -= ty;
            }
        }
        // 如果 ty > tx，那么上一次的变化一定是从（tx,ty-tx)->(tx,ty)
        while (ty > 2*tx && ty > sy) {
            int n = (ty - sy) / tx ;
            if (n > 2) {
                ty -= (n-2)*tx;
            } else {
                ty -= tx;
            }
        }
        if (tx == sx && sy==ty) {
            return true;
        }
        if (reachingPoints(sx,sy,tx-ty,ty)) {
            return true;
        }
        if (reachingPoints(sx,sy,tx,ty-tx)) {
           return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Leetcode780 l = new Leetcode780();
        System.out.println(l.reachingPoints(1,6,11,10));
    }

}
