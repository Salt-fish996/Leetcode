package LeetCode;

public class Leetcode312 {
//    //时间复杂度过高，未通过
//    static HashMap<String,Integer> map = new HashMap<>();
//    public int maxString(String nums){
//        if (nums.length() == 0) return 0;
//        if (nums.length()== 1) return nums.charAt(0) - '0';
//        if (map.get(nums)!=null) return map.get(nums);
//        int max = 0;
//        for (int i = 0; i < nums.length(); i++) {
//            int count = 0;
//            int i2 = Integer.parseInt("" + nums.charAt(i + 1));
//            int i3 = Integer.parseInt("" + nums.charAt(i));
//            if (i == 0 ){
//
//                max = Math.max(Integer.parseInt("" + nums.charAt(i)) * Integer.parseInt("" + nums.charAt(i + 1)) + maxString(nums.substring(1,nums.length())),max);
//            }else if (i == nums.length() -1){
//                max = Math.max(Integer.parseInt("" + nums.charAt(i)) *Integer.parseInt(""+nums.charAt(i-1)) + maxString(nums.substring(0,nums.length()-1)),max);
//            }else {
//                max = Math.max(Integer.parseInt("" + nums.charAt(i + 1)) * Integer.parseInt("" + nums.charAt(i)) *Integer.parseInt(""+nums.charAt(i-1)) + maxString(nums.substring(0,i)+nums.substring(i+1,nums.length())),max);
//            }
//        }
//        map.put(nums,max);
//        return max;
//    }
//    public int maxCoins(int[] nums) {
//
//
//        //System.out.println((Arrays.toString(nums)));
//        return maxString(Arrays.toString(nums).replace("[","").replace("]","").replace(",","").replace(" ",""));
//    }


//    public int dfs(int[] nums, HashMap<String,Integer> hashMap){
//
//        if (nums.length == 0){
//            return 0;
//        }
//        if (nums.length == 1){
//            return nums[0];
//        }
//
//        String s = Arrays.toString(nums);
//        //如果已经计算过了，那么直接返回
//        if (hashMap.get(s) != null){
//            return hashMap.get(s);
//        }
//        //遍历
//        int max = 0;
//        for (int i = 0; i < nums.length; i++) {
//            int[] temp = new int[nums.length - 1];
//            int numsCount = 0;
//            for (int j = 0; j < nums.length - 1; j++) {
//                if (numsCount == i){
//                    numsCount++;
//                }
//                    temp[j] = nums[numsCount];
//
//                numsCount++;
//            }
//            if ( i == 0){
//                max = Math.max(max,dfs(temp,hashMap)+nums[i] * nums[i + 1]);
//            }else if (i == nums.length - 1){
//                max = Math.max(max,dfs(temp,hashMap)+nums[i] * nums[i - 1]);
//            }else {
//                max = Math.max(max,dfs(temp,hashMap)+nums[i + 1]*nums[i] * nums[i - 1]);
//            }
//            hashMap.put(Arrays.toString(nums),max);
//        }
//        return max;
//    }
//    public int maxCoins(int[] nums) {
//
//        //使用记忆回溯法，使用hashMap来记录每一个数组对应的最大值
//        //nums={x1,x2,x3...xn},那么maxValue(1,n)=max{x1*x2+max{2,n}...}
//        if (nums.length == 0){
//            return 0;
//        }
//        HashMap<String,Integer> hashMap = new HashMap<>();
//        int a = dfs(nums,hashMap);
//
//        return a;
//    }


    //动态规划，参考别人的
    //dp[i][j]表示从i到j位置的最大值
    //dp[i][j]=max{dp[i][m-1]+nums[i]*nums[m]*nums[m]+dp[m+1][j]}
    public int maxCoins(int[] nums) {

        int m = nums.length;
        if (m == 0){
            return 0;
        }

        if (m == 1){
            return nums[0];
        }
        //在新的数组中添加首尾两个0
        int[] digital = new int[m + 2];
        digital[0] = 1;
        digital[m+1] = 1;
        for (int i = 0; i < m; i++) {
            digital[i + 1] = nums[i];
        }
        int n = m +2 ;
        int[][] dp = new int[m + 2][m + 2];
        for (int len = 2; len < n; ++len) {
            for (int i = 0; i < n - len; ++i) {
                int j = i + len;
                for (int k = i + 1; k < j; ++k) {
                    //对于第k个球最后爆
                    dp[i][j] = Math.max(dp[i][j], digital[i] *  digital[k] *  digital[j] + dp[i][k] + dp[k][j]);
                }
            }
        }
        return dp[0][n - 1];
    }
    public static void main(String[] args) {
        Leetcode312 leetcode312 = new Leetcode312();

        //int[] a = new int[]{8,2,6,8,9,8,1,4,1,5,3,0,7,7,0,4,2,2,5};

        int[] a = new int[]{3,1,5,8};

        long start = System.currentTimeMillis();
        System.out.println(leetcode312.maxCoins(a));
        System.out.println(System.currentTimeMillis()-start);
    }
}
