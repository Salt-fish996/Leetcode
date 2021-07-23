import sun.nio.ch.ThreadPool;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.*;

public class test {

    static int n = 20 * 100000;

    public void t2(){

    }

        public void print(int row, int col) {
            int[][] digit = new int[row][col];
            for(int i = 0; i < 6; i++){
                for(int j = 0; j < 11; j++){
                    if(i + j == 5 || j - i == 5){
                        digit[i][j]=1;
                    }else {
                        if(i > 0 && j > 0 && j < 10){ digit[i][j]=digit[i-1][j-1]+digit[i-1][j+1];}
                    }

                    if(digit[i][j] == 0){ System.out.print(" ");}
                    else System.out.print(digit[i][j]);
                    System.out.print(" ");
                }
                System.out.println();
            }
        }


        public List<Integer> findDisppearedNums(int[] arr) {

        List<Integer> list = new ArrayList<>();
        //定义一个boolean数组b,arr中出现的数字是i，那么就让b[i]=false,表示数字已经出现过了
            boolean[] flag = new boolean[arr.length + 1];
            for (int value : arr) {
                flag[value] = true;
            }

            for (int i = 1; i < flag.length; i++) {
                if (!flag[i]) {
                    list.add(i);
                }
            }

            return list;
        }



public void cal(int[] arr) {
        if (arr.length == 0) {
            return;
        }
        //如果只是一个0，那么直接输出
    if (arr.length == 1 && arr[0] == 0) {
        System.out.println(1);
    }
    //记录进位
    int preSit = 0;
    //最后一位加1如果小于10，那么只需要将数组最后一位加1输出
    if (arr[arr.length - 1] + 1 < 10) {
        for (int i = 0; i < arr.length - 1; i++) {
            System.out.print(arr[i] + " ");
        }
        //输出最后一位
        System.out.println(arr[arr.length - 1]);
        return;
    }
    //最后一位有进位的话，执行下面操作
    //使用栈来进行值记录
    Stack<Integer> s = new Stack<>();
    preSit = (arr[arr.length - 1] + 1) /10;
    s.push((arr[arr.length - 1] + 1) % 10);
    //从数组最后第二位开始计算
    for (int i = arr.length - 2; i >= 0; i--) {
        s.push((arr[i] + preSit) % 10);
        preSit = (arr[i] + preSit) / 10;
    }
    //处理第一位进位
    if (preSit != 0) {
        s.push(preSit);
    }
    while (!s.isEmpty()) {
        int temp = s.pop();
        System.out.print(temp + " ");

    }
}


















    public static void main(String[] args) throws IOException {

//        SocketClient client = new SocketClient(8888);
//
//        client.send();
//        test t = new test();
//        int[] a = new int[]{1,9,8,9};
//        t.cal(a);
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5,5,1, TimeUnit.SECONDS,new LinkedBlockingDeque<>(),Executors.defaultThreadFactory());
        for (int i = 0; i < 17; i++) {
            threadPoolExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("ces");
                }
            });

        }
        threadPoolExecutor.shutdown();

    }
}
