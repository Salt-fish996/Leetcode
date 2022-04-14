package src.LeetCode;
import java.util.*;

public class Leetcode307 {
    // 全通过测试用例但是超时
    class NumArray1 {

        int[] arr;
        int[] sums;
        int[] update;
        public NumArray1(int[] nums) {
            this.arr = nums;
            this.sums = new int[nums.length];
            this.update = new int[nums.length];
            int sum = 0;
            for (int i=0; i< nums.length;i++) {
                sum += nums[i];
                sums[i] = sum;
            }
        }

        public void update(int index, int val) {
            // 获取当前值与更新值的差
            int curValue = val - this.arr[index];
            arr[index] = val;
            this.update[index] += curValue;
        }

        public int sumRange(int left, int right) {
            int c = 0;
            for (int i = left; i <= right; i++) {
                c += this.update[i];
            }
            if (left > 0) {
                return this.sums[right] - this.sums[left-1] + c;
            }
            return this.sums[right] + c;
        }
    }

    class NumArray {
        private int[] sum; // sum[i] 表示第 i 个块的元素和
        private int size; // 块的大小
        private int[] nums;

        public NumArray(int[] nums) {
            this.nums = nums;
            int n = nums.length;
            size = (int) Math.sqrt(n);
            sum = new int[(n + size - 1) / size]; // n/size 向上取整
            for (int i = 0; i < n; i++) {
                sum[i / size] += nums[i];
            }
        }

        public void update(int index, int val) {
            sum[index / size] += val - nums[index];
            nums[index] = val;
        }

        public int sumRange(int left, int right) {
            int b1 = left / size, i1 = left % size, b2 = right / size, i2 = right % size;
            if (b1 == b2) { // 区间 [left, right] 在同一块中
                int sum = 0;
                for (int j = i1; j <= i2; j++) {
                    sum += nums[b1 * size + j];
                }
                return sum;
            }
            int sum1 = 0;
            for (int j = i1; j < size; j++) {
                sum1 += nums[b1 * size + j];
            }
            int sum2 = 0;
            for (int j = 0; j <= i2; j++) {
                sum2 += nums[b2 * size + j];
            }
            int sum3 = 0;
            for (int j = b1 + 1; j < b2; j++) {
                sum3 += sum[j];
            }
            return sum1 + sum2 + sum3;
        }
    }
//
//    作者：LeetCode-Solution
//    链接：https://leetcode-cn.com/problems/range-sum-query-mutable/solution/qu-yu-he-jian-suo-shu-zu-ke-xiu-gai-by-l-76xj/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。


}
