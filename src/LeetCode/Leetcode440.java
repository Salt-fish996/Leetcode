package src.LeetCode;

// 超时
public class Leetcode440 {
    // 返回是否第一个值字典序大于第二个值
    public boolean compare(char[] i, char[] j) {
        int iL = i.length;
        int jL = j.length;

        for (int k = 0; k < iL && k < jL; k++) {
            if (i[k] > j[k]) {
                return true;
            } else if (i[k] < j[k]) {
                return false;
            }
        }
        return iL > jL;
    }
    // 交换
    public void swap(int[] s ,int i, int j) {
        int t = s[i];
        s[i] = s[j];
        s[j] = t;
    }
    // 调整堆
    public void adjust(int[] s, int i) {
        int max = i; // 记录最大的结点所在的位置
        char[] cur = Integer.toString(s[i]).toCharArray();
        // 比较左结点
        if (2*i + 1 < s.length && !this.compare(cur,Integer.toString(s[2*i + 1]).toCharArray())) {
            max = 2*i+1;
            cur =Integer.toString(s[2*i + 1]).toCharArray();
        }
        // 比较右节点
        if (2*i + 2 < s.length && !this.compare(cur,Integer.toString(s[2*i + 2]).toCharArray())) {
            max = 2*i +2;
        }
        if (max != i) {
            swap(s,max,i);
            adjust(s,max);
        }
    }
    public int findKthNumber(int n, int k) {
        // 使用堆排序，构造一个大小为k的大顶堆
        int[] heap = new int[k];
        int curCount = 0;
        // 当新增的元素值字典序小于最大的元素的时候，那么使用新增的元素替换掉堆顶元素，然后再调整堆
        for (int i = 1; i <= n; i++) {
            if (curCount == k) { // 堆满
                if (this.compare(Integer.toString(heap[0]).toCharArray(),Integer.toString(i).toCharArray())) {
                    heap[0] = i;
                    this.adjust(heap,0);
                }
            } else {
                heap[curCount] = i;
                curCount++;
                if (curCount == k) {
                    for (int j = k - 1; j >= 0; j--) {
                        adjust(heap,j);
                    }
                }
            }
        }
        return heap[0];
    }

    public static void main(String[] args) {
        Leetcode440 l = new Leetcode440();
        System.out.println(l.findKthNumber(1000000000,500));
    }
}
