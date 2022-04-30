package src.LeetCode;

public class Leetcode2075 {
    public String decodeCiphertext(String encodedText, int rows) {
        StringBuilder res = new StringBuilder();
        char[] arr = encodedText.toCharArray();
        int n = encodedText.length();
        // 一共占了多少列
        int col = (n + rows-1) / rows;
        for (int i = 0; i < col; i++) {
            int cursor = i;
            for (int j = 0; j < rows; j++) {
                if (j * col + cursor >= arr.length) {
                    break;
                }
                res.append(arr[j * col + cursor]);
                cursor++;
            }
        }
        int index = res.length();
        for (int i = res.length()-1; i >= 0; i--) {
            if (res.charAt(i) == ' ') {
                index = i;
            }else {
                break;
            }
        }
        return res.substring(0,index);
    }


    public static void main(String[] args) {
        Leetcode2075 l = new Leetcode2075();
        System.out.println(l.decodeCiphertext(" b  ac",2));
    }
}
