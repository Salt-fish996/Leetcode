package LeetCode;

import java.util.*;

/**
 * @author hyy
 * @date 2019/11/14 20:25
 */

//最大频率栈，通过1148ms
public class Leetcode895 {
    //使用栈来存储数据
    //使用一个queue来对应记录每个元素的个数，然后从大到小排序
    //使用一个hashMap记录对应数字的次数
    class FreqStack {

        HashMap<Integer,Integer> hashMap;
        Queue<Integer> pq;
        Stack<Integer> stack;
        public FreqStack() {

            hashMap = new HashMap<>();
            pq= new PriorityQueue<>((o1,o2)->{
                return (int)o2 - (int)o1;
            });
            stack = new Stack<>();
        }

        public void push(int x) {

            if (hashMap.get(x) == null){
                //如果当前没有这个元素，那么直接放入
                hashMap.put(x,1);
                stack.add(x);
                pq.add(1);
            }else {
                int before = hashMap.get(x);
                //如果已经存储了这个数
                hashMap.put(x,before + 1);
                //更新优先队列
                Queue<Integer> queue = new PriorityQueue<>();
                boolean flag = true;
                for (int m:pq
                     ) {
                    if (m == before && flag){
                        queue.add(m + 1);
                        flag = false;
                    }else {
                        queue.add(m);
                    }
                }
                pq.clear();
                pq.addAll(queue);
                stack.add(x);
            }
        }

        public int pop() {
            //使用一个临时栈
            Stack<Integer> stack1 = new Stack<>();
            int maxFrequency = pq.poll();
            int value = -1;
            while (!stack.isEmpty()){
                int m = stack.pop();
                if (hashMap.get(m) == maxFrequency){
                    hashMap.put(m,maxFrequency - 1);
                    value = m;
                    pq.add(maxFrequency - 1);
                    break;
                }else {
                    stack1.add(m);
                }
            }
            //把临时栈中的数放入原始栈中
            while (!stack1.isEmpty()){
                stack.add(stack1.pop());
            }
            return value;
        }
    }
}
