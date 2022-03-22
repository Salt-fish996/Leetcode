package src.LeetCode;

public class Leetcode551 {
    public boolean checkRecord(String s) {
        int a = 0,l = 0;
        char[] chars = s.toCharArray();

        for (int i = 0; i < s.length(); i++) {
            switch (chars[i]) {
                case 'A':
                    a++;
                    l = 0;
                    break;
                case 'L':
                    l++;
                    if (l >= 3) {
                        return false;
                    }
                    break;
                case 'P':
                    l=0;
            }
        }
        return a <2;
    }
}
