package src.LeetCode;

/**
 * @author hyy
 * @date 2019/8/11 20:44
 */
public class Leetcode11 {
    /**
     * 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
     *
     * 说明：你不能倾斜容器，且 n 的值至少为 2。
     *
     *
     *
     * 图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
     *
     *  
     *
     * 示例:
     *
     * 输入: [1,8,6,2,5,4,8,3,7]
     * 输出: 49
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/container-with-most-water
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/
    public int maxArea(int[] height) {

        int result = 0;
        int begin = 0;
        int end = height.length-1;

        while( begin < end){
            int h = Math.min(height[begin], height[end]);
            result = Math.max(result, h * (end - begin));
            if(height[begin] < height[end]) ++begin;
            else --end;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] a = new int[]{76,155,15,188,180,154,84,34,187,142,22,5,27,183,111,128,50,58,2,112,179,2,100,111,115,76,134,120,118,103,31,146,58,198,134,38,104,170,25,92,112,199,49,140,135,160,20,185,171,23,98,150,177,198,61,92,26,147,164,144,51,196,42,109,194,177,100,99,99,125,143,12,76,192,152,11,152,124,197,123,147,95,73,124,45,86,168,24,34,133,120,85,81,163,146,75,92,198,126,191};
        Leetcode11 leetcode11 = new Leetcode11();
        System.out.println(leetcode11.maxArea(a));
    }
}
