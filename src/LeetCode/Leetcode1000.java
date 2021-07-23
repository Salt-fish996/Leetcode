package LeetCode;

/**
 * @author hyy
 * @date 2019/11/15 13:32
 */
public class Leetcode1000 {
//    static HashMap<String,Integer> hashMap = new HashMap<>();
//    //使用dp[i][j]来表示把i-j堆石头合成一堆的代价
//    public int mergeStones(int[] stones, int K) {
//
//
//        if (stones.length == 1){
//            return 0;
//        }
//        int n = stones.length;
//        if (stones.length < K){
//            return -1;
//        }
//        if ((stones.length - 1) % (K - 1) != 0){
//            return -1;
//        }
//        if (stones.length == K){
//            int sum = 0;
//            for (int i = 0; i < K; i++) {
//                sum += stones[i];
//            }
//            return sum;
//        }
//
//        //贪心算法，每次都找最小的组合
//        //使用hashMap记录最小值
//
//
//        if (hashMap.get(Arrays.toString(stones)) != null){
//            return hashMap.get(Arrays.toString(stones));
//        }
//        int max = Integer.MAX_VALUE;
//        int h = -1;
//        //贪心，找出最小值
//        for (int i = 0; i <= n - K; i++) {
//            int sum = 0;
//            for (int j = i; j < i + K; j++) {
//                sum += stones[j];
//            }
//            //创建新数组
//            int[] a = new int[n - K + 1];
//            int count = 0;
//
//            for (int ii = 0; ii <= n - K; ii++) {
//                if (count == i){
//                    a[ii] = sum;
//                    count += K;
//                }else {
//                    a[ii] = stones[count++];
//                }
//            }
//            int re =  sum + mergeStones(a,K);
//            max = Math.min(re,max);
//            System.out.println("max=" + re+"  i="+i);
//        }
//        hashMap.put(Arrays.toString(stones),max);
//        return max;
//    }



    //不是自己写的
    int inf=Integer.MAX_VALUE/8;
    int n,k,maxn=35;
    int[] sum=new int[maxn];
    Integer[][][] dp=new Integer[maxn][maxn][maxn];

    int dfs(int i,int j,int x){
        if (dp[i][j][x]!=null) return dp[i][j][x];
        if (x<=0) return inf;
        if (x==1){
            if (i==j) return dp[i][j][1]=0;
            if (j==i+k-1) return dp[i][j][1]=sum[j]-sum[i-1];

            return dp[i][j][1]=dfs(i,j,k)+sum[j]-sum[i-1];
        }
        {
            int ans=inf;
            for (int t=i;t<j;t++){
                ans=Math.min(ans,dfs(i,t,x-1)+dfs(t+1,j,1));
            }
            return dp[i][j][x]=ans;
        }
    }
    public int mergeStones(int[] stones, int K) {
        n=stones.length;
        k=K;

        if ((n-1)%(k-1)!=0) return -1;
        for (int i=1;i<=n;i++) {
            sum[i]=sum[i-1]+stones[i-1];
        }
        dfs(1,n,1);

        return dp[1][n][1];
    }

    public static void main(String[] args) {
        Leetcode1000 leetcode1000 = new Leetcode1000();
        int[] a = new int[]{29,59,31,7,51,99,47,40,24,20,98,41,42,81,92,55};
        System.out.println(leetcode1000.mergeStones(a,2));
    }
}
