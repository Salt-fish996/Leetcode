package src.LeetCode;

public class Leetcode2043 {
    class Bank {
        long[] balance;
        public Bank(long[] balance) {
           this.balance = balance;
        }

        public boolean transfer(int account1, int account2, long money) {
            if (account1 <= 0 || account1 > this.balance.length || account2 <= 0 || account2 > this.balance.length) {
                return false;
            }
            if (this.balance[account1 - 1] >= money) {
                this.balance[account2 - 1] += money;
                this.balance[account1 - 1] -= money;
                return true;
            }
            return false;
        }

        public boolean deposit(int account, long money) {
            if (account <= 0 || account > this.balance.length) {
                return false;
            }
            this.balance[account - 1] += money;
            return true;
        }

        public boolean withdraw(int account, long money) {
            if (account <= 0 || account > this.balance.length || this.balance[account - 1] < money) {
                return false;
            }
            this.balance[account - 1] -= money;
            return true;
        }
    }
}
