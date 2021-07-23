package LeetCode;

import java.util.Map;

/**
 * @author hyy
 * @date 2020/3/18 9:37
 * 矩形以列表 [x1, y1, x2, y2] 的形式表示，其中 (x1, y1) 为左下角的坐标，(x2, y2) 是右上角的坐标。
 *
 * 如果相交的面积为正，则称两矩形重叠。需要明确的是，只在角或边接触的两个矩形不构成重叠。
 *
 * 给出两个矩形，判断它们是否重叠并返回结果。
 */
public class Leetcode836 {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {

        //首先找出他们最小的横坐标，最大的横坐标，最小的纵坐标，最大的纵坐标
        int minRow1 = Integer.MAX_VALUE;
        int minRow2 = Integer.MAX_VALUE;
        int maxRow1 = Integer.MIN_VALUE;
        int maxRow2 = Integer.MIN_VALUE;
        int minCol1 = Integer.MAX_VALUE;
        int minCol2 = Integer.MAX_VALUE;
        int maxCol1 = Integer.MIN_VALUE;
        int maxCol2 = Integer.MIN_VALUE;
        minRow1 = Math.min(rec1[0], rec1[2]);
        minRow2 = Math.min(rec2[0], rec2[2]);
        maxRow1 = Math.max(rec1[0], rec1[2]);
        maxRow2 = Math.max(rec2[0], rec2[2]);
        minCol1 = Math.min(rec1[1], rec1[3]);
        minCol2 = Math.min(rec2[1], rec2[3]);
        maxCol1 = Math.max(rec1[1], rec1[3]);
        maxCol2 = Math.max(rec2[1], rec2[3]);

        //没有重叠的时候的所有情况
        //如果直接判断是不是有重叠会十分的麻烦，因此通过判断是不是没有重叠进而检查是否重叠
        if (maxRow1 <= minRow2 || maxRow2 <= minRow1) {
            return false;
        }
        return maxCol1 > minCol2 && maxCol2 > minCol1;
    }

}
