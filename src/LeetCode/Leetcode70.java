package LeetCode;

/**
 * @author hyy
 * @date 2019/9/11 21:41
 */
public class Leetcode70 {
    public int climbStairs(int n) {
        int[] a = new int[n+1];
        for (int i = 0; i < n+1; i++) {
            a[i] = 0;
        }
        if (n == 1) return 1;
        if (n == 2) return 2;
        a[1] = 1;
        a[2] = 2;

        return  clib(n,a);
    }
    public int clib(int n, int[] array){
//        if(n == 1) return 1;
//        if(n == 2) return 2;
        int n1 = 0;
        int n2 = 0;
        if(array[n-1] != 0)
            n1 = array[n-1];
        else {
            n1 = clib(n-1,array);
        }
        if(array[n-2] != 0) n2 = array[n-2];
        else {
            n2 = clib(n-2,array);
        }
        array[n] = n1+n2;
        return n1 + n2;
    }

    public static void main(String[] args) {
        Leetcode70 l = new Leetcode70();
        System.out.println(l.climbStairs(46));
    }
}
