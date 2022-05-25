package src.LeetCode;

import java.util.Arrays;

public class Leetcodeoffer66 {
    public int[] constructArr(int[] a) {
        if (a.length <= 1) {
            return a;
        }
        int[] res = new int[a.length];
        int[] br = new int[a.length];
        int[] af = new int[a.length];
        br[0] = a[0];
        af[a.length - 1] = a[a.length-1];
        for (int i = 1; i < a.length; i++) {
            br[i] = br[i-1]*a[i];
        }
        for (int i = a.length-2;i >= 0; i--) {
            af[i] = af[i+1]*a[i];
        }
        Arrays.fill(res, 1);
        res[0] = af[1];
        res[a.length-1] = br[a.length-2];
        for (int i = 1; i < a.length-1; i++) {
           res[i] = br[i-1]*af[i+1];
        }
        return res;
    }

    public static void main(String[] args) {
        Leetcodeoffer66 l = new Leetcodeoffer66();
        System.out.println(Arrays.toString(l.constructArr(new int[]{1, 2, 3, 4, 5})));
    }
}
