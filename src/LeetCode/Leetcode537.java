package src.LeetCode;

public class Leetcode537 {
    public String complexNumberMultiply(String num1, String num2) {
        String[] n1 = num1.replace("i","").split("\\+");
        String[] n2 = num2.replace("i","").split("\\+");

        int[] n11 = new int[2];
        int[] n22 = new int[2];
        n11[0] = Integer.parseInt(n1[0]);
        n22[0] = Integer.parseInt(n2[0]);

        n11[1] = Integer.parseInt(n1[1]);
        n22[1] = Integer.parseInt(n2[1]);

        int res = 0;
        // 实数部分
        res = n11[0]*n22[0]-n11[1]*n22[1];
        return res+"+"+(n11[0]*n22[1]+n11[1]*n22[0])+"i";
    }

    public static void main(String[] args) {
        Leetcode537 l = new Leetcode537();
        System.out.println(l.complexNumberMultiply("1+-1i","1+-1i"));
    }
}
