package src.LeetCode;

public class LeetCode1736 {
    public String maximumTime(String time) {
        String res = "";
        // 时间一共是4位数，前两位表示是小时：当第一位是0或者1的时候，第二位是9；当第一位是2的时候，第二位是3；当第二位小于3的时候，第一位是2，当第二位大于4的时候，第一位是1
        // 对于分钟数来说，当第一位是0-5的时候，第二位都是9；当第一位是6的时候，第二位是0；当第二位是0的时候，第一位是6；其余的都是5
        String[] times = time.split(":");
        // 判断小时
        char first = times[0].charAt(0);
        char second = times[0].charAt(1);
        if (first == '?') {
            if (second == '?') {
                res = "23";
            } else if (second <= '3') {
                res = "2" + second;
            } else {
                res = "1" + second;
            }
        } else {
            if (second == '?' ) {
                if (first == '2') {
                    res = first + "3";
                } else {
                    res = first + "9";
                }
            } else {
                res = first + "" + second;
            }
        }

        // 判断分钟
        first = times[1].charAt(0);
        second = times[1].charAt(1);
        if (first == '?') {
           first = '5';
        }
        if (second == '?') {
            second = '9';
        }
        res += ":"+first+second;
        return res;
    }

    public static void main(String[] args) {
        LeetCode1736 l = new LeetCode1736();
        System.out.println(l.maximumTime("2?:?0"));
    }
}
