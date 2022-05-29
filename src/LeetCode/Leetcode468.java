package src.LeetCode;

public class Leetcode468 {
    public String validIPAddress(String queryIP) {
        // 判断ipv4
        if (queryIP.contains(".")) {
            if (checkIpv4(queryIP)) {
               return "IPv4";
            } else {
                return "Neither";
            }
        }
        if (checkIpv6(queryIP)) {
            return "IPv6";
        }
        return "Neither";
    }

    public boolean checkIpv4(String ip) {
        String[] ss = ip.split("\\.");
        if (ss.length != 4 || ip.endsWith(".")) {
            return false;
        }
        for (int i = 0; i < 4; i++) {
            if ((ss[i].length() > 1 && !ss[i].startsWith("0")) || ss[i].length() == 1) {
                try {
                    int num = Integer.parseInt(ss[i]);
                    if (num > 255) {
                        return false;
                    }
                } catch (Exception e) {
                    return false;
                }
            } else {
                return false;
            }
        }
        return true;
    }

    public boolean checkIpv6(String ip) {
        String[] ss = ip.split(":");
        if (ss.length != 8 || ip.endsWith(":")) {
            return false;
        }
        for (int i = 0; i < 8; i++) {
            if (ss[i].length() <1 || ss[i].length() >4) {
                return false;
            }
            char[] arr = ss[i].toCharArray();
            for (int j = 0; j < arr.length; j++) {
                if (arr[j] >= '0'&& arr[j] <= '9') {
                    continue;
                }
                if (arr[j] >= 'a' && arr[j] <= 'f' ) {
                    continue;
                }
                if (arr[j] >= 'A' && arr[j] <= 'F') {
                    continue;
                }
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Leetcode468 l = new Leetcode468();
        System.out.println(l.validIPAddress( "2001:0db8:85a3:0:0:8A2E:0370:7334:"));
    }
}
