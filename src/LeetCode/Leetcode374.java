package src.LeetCode;
//猜数字1，通过
public class Leetcode374 {
    private int guess(int n){
        int m = 6;
        if (m == n) return 0;
        if (m>n) return 1;
        return -1;

    }
    public int guessNumber(int n) {

        int begin = 1;
        int end = n;
        long half = ((long)begin + (long)end)/2;
        int temp = guess((int)half);
        while(temp != 0){
            //System.out.println(begin + "  "+end);
            if(temp == -1){
                end = (int)half;
            }else if(temp == 1){
                begin =(int)half;
            }
            if(end - begin <= 1){
                if(guess((begin)) == 0) return begin;
                if(guess(end) == 0) return end;
            }else{
                half = ((long)begin + (long)end)/2;
                temp = guess((int)half);

            }

        }
        return (int)half;
    }

    public static void main(String[] args) {
        Leetcode374 leetcode374 = new Leetcode374();
        System.out.println(leetcode374.guessNumber(10));
    }
}
