package LeetCode;

/**
 * @author hyy
 * @date 2019/11/28 13:39
 */
public class Leetcode801 {
//    static int minCount = Integer.MAX_VALUE;
//    void swap(int[] a, int[] b, int i){
//        int temp = a[i];
//        a[i] = b[i];
//        b[i] = temp;
//    }
//    public void dfs(int[] a, int[] b, int index, int count, int n){
//        if (count > minCount){
//            return;
//        }
//
//        if (index == n - 1){
//            if (a[index] > a[index - 1] && b[index] > b[index - 1]){
//                minCount = Math.min(minCount,count);
//                return;
//            }else if (a[index] > b[index - 1] && a[index - 1] < b[index]){
//                minCount = Math.min(minCount,count + 1);
//                return;
//            }
//
//        }
//
//        if (index - 2 > 0 && (a[index - 1] <= a[index - 2] || b[index - 1] <= b[index - 2])){
//            return;
//        }
//
//        int temp = index;
//        for (int i = index; i < n - 1; i++) {
//            if (a[i] < a[i + 1] && b[i] < b[i + 1]){
//                temp++;
//            }else {
//                break;
//            }
//        }
//
//
//        //如果已经要个递增了，直接返回
//        if (temp == n){
//            minCount = Math.min(minCount,count);
//            return;
//        }
//
//
//        //对于每一位与两种选择，交换，或者不交换
//        if (index == 0){
//            //对于位置0的元素，可以选择不交换
//            dfs(a,b,1,0,n);
//            //交换
//            swap(a,b,index);
//            dfs(a,b,1,1,n);
//            swap(a,b,index);
//        }else {
//            //如果比前面的小，那么必须交换
//            if (a[index] <= a[index - 1]){
//                if (a[index] > b[index - 1] && b[index] > a[index - 1]){
//                    swap(a,b,index);
//                    dfs(a,b,index + 1,count + 1,n);
//                    swap(a,b,index);
//                }
//
//            }else if (a[index] > a[index - 1]){
//
//                if (a[index] > b[index - 1] && b[index] > a[index - 1]){
//                    swap(a,b,index);
//                    dfs(a,b,index + 1,count + 1,n);
//                    swap(a,b,index);
//                }
//
//                if (b[index] > b[index - 1]){
//                    dfs(a,b,index + 1,count,n);
//                }
//
//            }
//        }
//    }
//    public int minSwap(int[] A, int[] B) {
//
//        minCount = Integer.MAX_VALUE;
//        dfs(A,B,0,0,A.length);
//        return minCount;
//    }


    //动态规划
    //使用dp[i][0]表示用a[i]作为第i个位置数字的最少操作次数
    //使用dp[i][1]表示用b[i]作为第i个数字的最少操作次数
    //通过
    public int minSwap(int[] A, int[] B) {

        int n = A.length;
        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = 1;

        for (int i = 1; i < n; i++) {
            dp[i][0] = Integer.MAX_VALUE;
            dp[i][1] = Integer.MAX_VALUE;
            //如果a[i]>a[i-1]&&b[i]>b[i-1]
            if (A[i] > A[i - 1] && B[i] > B[i - 1]){
                dp[i][0] = Math.min((dp[i - 1][0]),dp[i][0]);
                dp[i][1] = Math.min(dp[i - 1][1] == Integer.MAX_VALUE?Integer.MAX_VALUE:(dp[i - 1][1] + 1),dp[i][1]);
            }

            if (A[i] > B[i - 1] && B[i] > A[i - 1]){
                dp[i][0] = Math.min((dp[i - 1][1]),dp[i][0]);
                dp[i][1] = Math.min(dp[i - 1][0] == Integer.MAX_VALUE?Integer.MAX_VALUE:(dp[i - 1][0] + 1),dp[i][1]);
            }

        }

//        for (int i = 0; i < n; i++) {
//            System.out.println(Arrays.toString(dp[i]));
//        }
        return Math.min(dp[n - 1][0],dp[n - 1][1]);
    }
    public static void main(String[] args) {
        Leetcode801 leetcode801 = new Leetcode801();
//        int[] a = new int[1000];
//        for (int i = 0; i <1000; i++) {
//            a[i] = (int) ((Math.pow(2,16)) * Math.random() + 1);
//        }
//        int[] b = new int[1000];
//        for (int i = 0; i <1000; i++) {
//            b[i] = (int) ((Math.pow(2,16)) * Math.random() + 1);
//        }
        int[] a = new int[]{3,3,8,6,10};
        int[] b = new int[]{1,7,4,9,8};
        System.out.println(leetcode801.minSwap(a,b));
    }
}
