package src.LeetCode;

/**
 * @author hyy
 * @date 2019/8/9 22:37
 */
public class Leetcode1114 {
    private static volatile int loca11 = 0;
    private static volatile int loca12 = 0;
    public void first(Runnable printFirst) throws InterruptedException {

        loca11++;
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
    }

    public void second(Runnable printSecond) throws InterruptedException {

        while(loca11 == 0);
        loca12 ++;
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
    }

    public void third(Runnable printThird) throws InterruptedException {

        while (loca12 == 0);
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}
