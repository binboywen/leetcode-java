package jianzhiOffer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 队列的最大值
 * 请定义一个队列并实现函数max得到队列里的最大值，
 * 要求max、push和pop的时间复杂度都是O(1)
 * https://leetcode-cn.com/problems/dui-lie-de-zui-da-zhi-lcof/solution/mian-shi-ti-59-ii-javashi-xian-yuan-li-he-mian-shi/
 */
public class _59_2_队列的最大值 {
    public static class MyQueue {
        private Queue<Integer> queueData;
        private LinkedList<Integer> queueMax;

        public MyQueue() {
            queueData = new LinkedList<>();
            queueMax = new LinkedList<>();
        }

        public int max_value() {
            return queueMax.size() == 0 ? -1 : queueMax.getFirst();
        }

        public void push_back(int value) {
            queueData.add(value);
            while (queueMax.size() != 0 && queueMax.getLast() < value) {
                queueMax.removeLast();
            }
            queueMax.add(value);
        }

        public int pop_front() {
            if (queueMax.size() != 0 && queueData.peek().equals(queueMax.getFirst())) {
                queueMax.removeFirst();
            }
            return queueData.size() == 0 ? -1 : queueData.poll();
        }
    }

}
