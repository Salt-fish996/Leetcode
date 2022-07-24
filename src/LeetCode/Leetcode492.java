package src.LeetCode;

import java.util.Arrays;

public class Leetcode492 {
    public int[] constructRectangle(int area) {
        int l ,w= 0;
        // 要计算面积为area的 [w,l]，那么就是计算在area的公因数中差别最小的数
        // 那么直接开根号，因为 l > w，那么一定有w<根号area
        double s = Math.sqrt(area);
        // 从s开始往遍历能整除的第一个数就是w的值
        for(int i = (int)s; i >= 1; i--) {
            if( area % i == 0 ) {
                w = i;
                break;
            }
        }
        l = area / w;
        return new int[]{l,w};
    }

    public static void main(String[] args) {
        Leetcode492 l = new Leetcode492();
        System.out.println(Arrays.toString(Arrays.stream(l.constructRectangle(4)).toArray()));
    }
}
