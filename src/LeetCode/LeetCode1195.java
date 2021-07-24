package LeetCode;

public class LeetCode1195 {
    // 执行会超时，最好的办法就是采用类型go预压管道的方式
    public static class FizzBuzz {
        private int n;
        private volatile int now;
        private volatile int concurrentFlag = 1;

        public FizzBuzz(int n) {
            this.n = n;
            this.now = 1;

        }
        // 判断的顺序应该是 fizzBuzz->buzz->fizz->number

        // printFizz.run() outputs "fizz".
        public void fizz(Runnable printFizz) throws InterruptedException {
            while (this.now <= this.n) {
                while (this.concurrentFlag != 3) {
                    if (this.now > this.n) {
                        return;
                    }
                }
                if (this.now % 3 == 0) {
                    printFizz.run();
                    this.now++;
                    this.concurrentFlag = 1;
                    continue;
                }
                this.concurrentFlag = 4;
            }

        }

        // printBuzz.run() outputs "buzz".
        public void buzz(Runnable printBuzz) throws InterruptedException {
            while (this.now <= this.n) {
                while (this.concurrentFlag != 2) {
                    if (this.now > this.n) {
                        return;
                    }
                }
                if (this.now % 5 == 0) {
                    printBuzz.run();
                    this.now++;
                    this.concurrentFlag = 1;
                    continue;
                }
                this.concurrentFlag = 3;
            }
        }

        // printFizzBuzz.run() outputs "fizzbuzz".
        public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
            while (this.now <= this.n) {
                while (this.concurrentFlag != 1) {
                    if (this.now > this.n) {
                        return;
                    }
                }

                if (this.now % 3 == 0 && this.now % 5 == 0) {
                    printFizzBuzz.run();
                    this.now++;
                    this.concurrentFlag = 1;
                    continue;
                }
                this.concurrentFlag = 2;
            }
        }

        // printNumber.accept(x) outputs "x", where x is an integer.
        public void number(IntConsumer printNumber) throws InterruptedException {
            while (this.now <= this.n) {
                while (this.concurrentFlag != 4) {
                    if (this.now > this.n) {
                        return;
                    }
                }

                printNumber.accept(this.now);
                this.now++;
                this.concurrentFlag = 1;
            }
        }
    }

}
