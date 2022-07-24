package src.LeetCode;

public class Leetcode42 {
    /**给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。



     上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢 Marcos 贡献此图。

     示例:

     输入: [0,1,0,2,1,0,1,3,2,1,2,1]
     输出: 6

     来源：力扣（LeetCode）
     链接：https://leetcode-cn.com/problems/trapping-rain-water
     著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/

    //采用对每个值进行左右遍历以查找他得leftMax和rightMax
    public int trap(int[] height) {
        int n = height.length;
        int sum = 0;
        //最简单的想法，遍历从i开始的左边和右边，找到左边的最大值和右边的最大值，他们两个之间的最小值减去i这个位置上的高度就是这个点能够容纳的雨水的量
        for (int i = 1; i < n-1; i++) {//0和n-1位置无论如何都不能给容纳雨水，因此不必计算
            int leftMax = 0;
            int rightMax = 0;
            for (int j = i; j < n; j++) {//计算右边最大值
                rightMax = Math.max(rightMax,height[j]);
            }
            for (int j = i; j >= 0; j--) {//计算左边最大值
                leftMax = Math.max(leftMax,height[j]);
            }
            sum += Math.min(leftMax,rightMax) - height[i];
        }

        return sum;
    }

    //首先对leftMax和rightMax进行存储
    public int trapByPreScan(int[] heights){
        int n = heights.length;
        int sum = 0;
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];
        int maxleft = 0;
        for (int i = 0; i < n; i++) {
            maxleft = Math.max(heights[i],maxleft);
            leftMax[i] = maxleft;
        }

        int maxRight = 0;
        for (int i = n-1; i >= 0; i--) {
            maxRight = Math.max(maxRight,heights[i]);
            rightMax[i] = maxRight;
        }

        for (int i = 0; i < n; i++) {
            sum += Math.min(leftMax[i],rightMax[i]) - heights[i];
        }

        return sum;
    }

    public static void main(String[] args) {
        Leetcode42 leetcode42 = new Leetcode42();
        int[] heights = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(leetcode42.trap(heights));
        System.out.println(leetcode42.trap(heights));
    }
}
