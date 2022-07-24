package src.LeetCode;

/**
 * @author hyy
 * @date 2019/11/18 14:26
 */
//通过，使用数组本身作为出现记录的工具
public class Leetcode41 {
    public int firstMissingPositive1(int[] nums) {
        //用字节存储，这个方法只能检测32以下的数字
        long state = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            if (nums[i]>0)
            state = state | (1 << nums[i]);
        }

        String s = Long.toBinaryString(state);

        System.out.println(s);
        int i = 0;
        for (i = 2;  s.length() - i >=0;i++) {
            if (s.charAt(s.length() - i) == '0'){
                return i - 1;
            }
        }
        return s.length();
    }

    //使用数组自身作为记录，首先将每个数字变成正整数(要先检查1的存在，然后把负数全部改成1，保证这时候数组中只剩下正整数)
    // 然后遍历数组，将nums[i]对应的下标标nums[i]上的数字改为负数，表明已经出现过，需要保证多次出现的数只改变一次其对应的下标
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;


        //查找一遍有没有1
        boolean flag = true;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 1){
                flag = false;
                break;
            }
        }
        if (flag){
            return 1;
        }

        //将所有的负数替换成1
        for (int i = 0; i < n; i++) {
            if (nums[i] <= 0){
                nums[i] = 1;
            }
        }

        //对于每一个数字i，改变nums[i-1]的符号，因为经过上面的步骤，所有的数都变成了正整数
        for (int i = 0; i < n; i++) {
            int x = Math.abs(nums[i]);
            //如果位置i上的数已经大于了数组的个数，那么返回
            if (x- 1 > n - 1){
                continue;
            }
            //如果nums[i]符合条件
            //保障多次出现的数只改变一次符号
            if (nums[x - 1] < 0){
                continue;
            }else {
                //改变符号，表示数字x已经出现过
                nums[x - 1] = -1*nums[x - 1];
            }
        }

        for (int i = 0; i < n; i++) {
            if (nums[i] > 0){
                return i + 1;
            }
        }
        return n + 1;
    }
    public static void main(String[] args) {
        Leetcode41 leetcode41 = new Leetcode41();
        System.out.println(leetcode41.firstMissingPositive(new int[]{99,94,96,92,5,91,89,57,85,66,63,84,81,79,61,74,78,77,30,64,13,58,18,70,69,51,12,32,34,9,43,39,8,1,38,49,27,21,45,47,44,53,52,48,19,50,59,3,40,31,82,23,56,37,41,16,28,22,33,65,42,54,20,29,25,10,26,4,60,67,83,62,71,24,35,72,55,75,0,2,46,15,80,6,36,14,73,76,86,88,7,17,87,68,90,95,93,97,98}));
    }
}
