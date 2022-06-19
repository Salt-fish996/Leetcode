package src.LeetCode;

public class Leetcode2224 {
    public int convertTime(String current, String correct) {
        if (current.equals(correct)) {
            return 0;
        }
        // 计算两个时间的差值，将时间转为分钟数
        int currentInt = 0;
        int correctInt = 0;
        String[] cus = current.split(":");
        String[] cos = correct.split(":");
        currentInt = (cus[0].charAt(0)-'0')*10*60 + ((cus[0].charAt(1)-'0')*60) + ((cus[1].charAt(0)-'a')*10)+(cus[1].charAt(1)-'0');
        correctInt = (cos[0].charAt(0)-'0')*10*60 + ((cos[0].charAt(1)-'0')*60) + ((cos[1].charAt(0)-'a')*10)+(cos[1].charAt(1)-'0');
        int c = 0;
        if (currentInt < correctInt) {
            c = correctInt-currentInt;
        } else {
            c = correctInt + 24*60*60-currentInt;
        }

        int res = 0;
        while (c >0) {
            if (c >= 60) {
                res += c /60;
                c = c % 60;
            } else if (c >= 15) {
                res += c /15;
                c = c % 15;
            } else if (c >= 5) {
                res += c /5;
                c = c % 5;
            } else {
                res += c;
                c = 0;
            }
        }
        return res;
    }
}
