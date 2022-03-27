package LeetCode;

import java.util.Arrays;

public class Leetcode2055 {
    public int[] platesBetweenCandles(String s, int[][] queries) {
        int l = queries.length;
        // 使用一个数组统计盘子的数，使用一个数组统计蜡烛的数目

        char[] arr = s.toCharArray();
        int  leng = arr.length;
        int[] pan = new int[leng];
        int[] left = new int[leng];
        int[] right = new int[leng];
        int ss = -1;
        int pp = 0;
        for (int i=0;i < leng; i++) {
            if (arr[i] == '|') {
                left[i] = i;
                ss = i;
            } else {
                if (ss != -1) {
                    left[i] = ss;
                } else {
                    left[i] = Integer.MIN_VALUE;
                }

                pp++;
            }
            pan[i] = pp;
        }
        ss = -1;
        for (int i = leng - 1; i >= 0; i--) {
            if (arr[i] == '|') {
                right[i] = i;
                ss = i;
            } else {
                if (ss == -1) {
                    right[i] = Integer.MAX_VALUE;
                } else {
                    right[i] = ss;
                }

            }
        }

        // 对于某一个从i->j的位置，盘子的数目在蜡烛之间数目的为
        int[] res = new int[queries.length];

        for (int i=0;i < l;i++) {
            int t = 0;
            int b = queries[i][0];
            int e = queries[i][1];

            if (right[b] < e && left[e] > b) {
                t = pan[left[e]] - pan[right[b]];
            }
            res[i] = t;
        }
        return res;
    }

    public int cal(String s) {
        char[] arr = s.toCharArray();
        int laMin = -1;
        int laMax = -1;
        int count = 0;
        for (int i=0;i < arr.length;i++) {
            if (arr[i] == '|') {
                if (laMin == -1){
                    laMin = i;
                } else {
                    count++;
                    laMax = i;
                }
            }
        }
        if (laMax > laMin) {
            return laMax - laMin - count;
        }
        return 0;
    }

    public static void main(String[] args) {
        Leetcode2055 l = new Leetcode2055();
        int[][] a = new int[2][2];
        a[0][0] = 2;
        a[0][1] = 5;
        a[1][0] = 5;
        a[1][1] = 9;
        System.out.println(Arrays.toString(Arrays.stream(l.platesBetweenCandles("**|**|***|", a)).toArray()));
    }
}
