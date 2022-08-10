package src.LeetCode;

public class Leetcode640 {
    public String solveEquation(String equation) {
        int xCount = 0;
        int right = 0;
        StringBuilder s = new StringBuilder();
        boolean left = true;
        equation += "=";
        for (int i = 0; i < equation.length(); i++) {
            char t = equation.charAt(i);
            if (t == '-' || t == '+' || t == '=') {
                if(!s.toString().equals("")) {
                    if (s.toString().contains("x")) {
                        String xx = s.toString().replace("x", "");
                        if (xx.equals("") || xx.equals("+")) {
                            xx = "1";
                        } else if (xx.equals("-")) {
                            xx = "-1";
                        }
                        int x = Integer.parseInt(xx);
                        if (left) {
                            xCount += x;
                        } else {
                            xCount -= x;
                        }
                    } else {
                        if (left) {
                            right -= Integer.parseInt(s.toString());
                        } else {
                            right += Integer.parseInt(s.toString());
                        }
                    }
                    s.delete(0,s.length());
                    if (t == '=') {
                        left = false;
                    } else {
                        s.append(t);
                    }
                }else {
                    s.append(t);
                }
            }else {
                s.append(t);
            }
        }

        if (xCount != 0) {
            return "x="+right/xCount;
        }
        if (right == 0) {
            return "Infinite solutions";
        }
        return "No solution";
    }

    public static void main(String[] args) {
        Leetcode640 l = new Leetcode640();
        System.out.println(l.solveEquation("-x=1"));
    }
}
