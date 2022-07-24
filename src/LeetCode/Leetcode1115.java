package src.LeetCode;

/**
 * @author hyy
 * @date 2019/8/9 22:57
 */
public class Leetcode1115 {
    private int n;
    private static volatile int local1 = 0;



    public  void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            while(local1 == 1);
            // printFoo.run() outputs "foo". Do not change or remove this line.
            printFoo.run();
            local1 = 1;
        }
    }

    public  void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            while(local1 == 0);
            // printBar.run() outputs "bar". Do not change or remove this line.
            printBar.run();
            local1 = 0;
        }
    }
}
