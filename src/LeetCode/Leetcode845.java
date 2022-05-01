package src.LeetCode;

public class Leetcode845 {
    public int longestMountain(int[] arr) {
        int incrLen = 1; // 记录增加的
        int descLen = 0; // 记录减少的
        int max = 0;
        boolean beforeIncr = false; // 前面是不是加
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[i-1]) {
                if (!beforeIncr) {
                    incrLen = 1;
                }
                descLen = 0;
                incrLen++;
                beforeIncr = true;
            } else if (arr[i] < arr[i-1]) {
                descLen++;
                beforeIncr = false;
            }else {
                descLen = 0;
                beforeIncr = false;
                incrLen = 0;
            }
            max = Math.max(max,incrLen > 1 && descLen > 0?incrLen+descLen:0);
        }
        return max;
    }

    public static void main(String[] args) {
        Leetcode845 l = new Leetcode845();
        System.out.println(l.longestMountain(new int[]{0,2,0,2,1,2,3,4,4,1}));
    }
}
