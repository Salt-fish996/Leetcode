package LeetCode;

import com.sun.org.apache.regexp.internal.RE;
import org.omg.CORBA.ARG_IN;

/**
 * @author hyy
 * @date 2020/3/18 10:12
 * 在二维平面上计算出两个由直线构成的矩形重叠后形成的总面积。
 */
public class Leetcode223 {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {

        //两个矩形重叠的部分只可能是矩形，因此只需要找出重叠部分矩形的面积就可以了
        int area = 0;
        //计算两个矩形的面积
        area += (C - A) * (D - B);
        area += (G - E) * (H - F);
        //判断有没有重合，如果没有重合， 那么直接返回
        //没有重叠的时候的所有情况
        //如果直接判断是不是有重叠会十分的麻烦，因此通过判断是不是没有重叠进而检查是否重叠
        if (C <= E || A >= G || B >= H || D <= F) {
            return area;
        }
        //计算重叠部分的面积
        //计算重叠部分的长
        int longth = Math.min(C, G) - Math.max(E, A);
        //计算重叠部分的宽
        int width = Math.min(H, D) - Math.max(B, F);
        return area - (longth * width);
    }
}
