package WangyiRecruit;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Wangyi2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            int p = in.nextInt();
            int q = in.nextInt();
            int count = 0;
            Queue<Integer> queue = new LinkedList<>();
            queue.add(a);
            queue.add(b);
            queue.add(p);
            queue.add(q);
            queue.add(count);
            while (true){
                a = queue.poll();
                b = queue.poll();
                p = queue.poll();
                q = queue.poll();
                count = queue.poll();
                if (a >= b){
                    System.out.println(count);
                    break;
                }
                queue.add(a+p);
                queue.add(b);
                queue.add(p);
                queue.add(q);
                queue.add(count+1);
                queue.add(a);
                queue.add(b);
                queue.add(p*q);
                queue.add(q);
                queue.add(count+1);
            }
        }
    }
}
