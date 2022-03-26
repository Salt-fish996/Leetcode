package src.LeetCode;

public class Leetcode172 {
    public int trailingZeroes(int n) {
        int ans = 0;
        for (int i = 5; i <= n; i += 5) {
            for (int x = i; x % 5 == 0; x /= 5) {
                ++ans;
            }
        }
        return ans;
    }

//    作者：LeetCode-Solution
//    链接：https://leetcode-cn.com/problems/factorial-trailing-zeroes/solution/jie-cheng-hou-de-ling-by-leetcode-soluti-1egk/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

    public static void main(String[] args) {
        Leetcode172 l = new Leetcode172();
        System.out.println(l.trailingZeroes(10000));
    }
}
