package DynamicAlgor;

public class MinCountCoins {
    //动态规划方式
    //最小硬币问题，假设有2,5,7三个硬币，f[x]=min{f[x-2]+1,f[x-5]+1,f[x-7]+1}
    public int dp(int[] A,int n){
        int[] f = new int[n+1];//定义f数组
        f[0] = 0;
        //依次求最小值
        for (int i = 1; i < n+1; i++) {
            f[i] = Integer.MAX_VALUE;
            for (int j = 0; j < A.length; j++) {
                //如果A={2,3,5}，这里相当于求f[i]=min{f[i-2],f[i-3],f[i-5]}
                if (i>=A[j] && f[i-A[j]] != Integer.MAX_VALUE){
                    f[i] = Math.min(f[i-A[j]]+1,f[i]);
                }
            }
        }

        if (f[n] == Integer.MAX_VALUE) return -1;

        return f[n];

    }

    //递归方式
    public int deverse(int[] A,int n){
        if (n<0) return Integer.MAX_VALUE;
        if (n ==0) return 0;
        int minDig = Integer.MAX_VALUE;
        for (int i = 0; i < A.length; i++) {
            int temp = deverse(A,n-A[i]);
            if (temp!=Integer.MAX_VALUE)
            minDig = Math.min(minDig,temp+1);
        }
        return minDig;
    }

    //优化后的递归（记忆搜索）
    public int deverseReform(int[] A,int n,int[] f){
        if (n<0) return Integer.MAX_VALUE;
        if (n ==0) return 0;
        int minDig = Integer.MAX_VALUE;
        for (int i = 0; i < A.length; i++) {
            if (n-A[i]>=0 && f[n-A[i]] != 0 ){
                if (f[n-A[i]]!=Integer.MAX_VALUE)
                minDig = Math.min(minDig,f[n-A[i]]+1);
            }else
            {
                int temp = deverseReform(A,n-A[i],f);
                if (temp != Integer.MAX_VALUE)
                minDig = Math.min(minDig,temp +1);
            }

        }

        f[n] = minDig;
        return minDig;
    }

    public static void main(String[] args) {
        int[] A = new int[]{2,5,7};
        int n = 354187111;
        //测试发现，尽管采用记忆搜索以后计算时间差不多，但是由于递归栈深度有限制，因此递归方式不能够计算很大的数字
        for (int i = 2;  ; i++) {
            n+=1;
            MinCountCoins minCountCoins = new MinCountCoins();
            long start = System.currentTimeMillis();
            System.out.println(n+"动态规划："+minCountCoins.dp(A,n)+"\n花费时间是="+(System.currentTimeMillis()-start));

//            int[] h = new int[n+1];
//            start = System.currentTimeMillis();
//            System.out.println(n+"优化递归："+minCountCoins.deverseReform(A,n,h)+"\n花费时间是="+(System.currentTimeMillis()-start));

        }


//        start = System.currentTimeMillis();
//        System.out.println("递归："+minCountCoins.deverse(A,n)+"\n花费时间是="+(System.currentTimeMillis()-start));
    }
}
