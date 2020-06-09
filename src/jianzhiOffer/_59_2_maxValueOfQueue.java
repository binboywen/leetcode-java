package jianzhiOffer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 队列的最大值
 * 请定义一个队列并实现函数max得到队列里的最大值，
 * 要求max、push和pop的时间复杂度都是O(1)
 */
public class _59_2_maxValueOfQueue {
    public static class MyQueue{
        private Queue<Integer> queueData;
        private Queue<Integer> queueMax;

        public MyQueue(){
            this.queueData = new LinkedList<>();
            this.queueMax = new LinkedList<>();
        }

        public void push(int newNum){
            if(this.queueMax.isEmpty()){
                this.queueMax.add(newNum);
            }else if(newNum >= this.getMax()){
                this.queueMax.add(newNum);
            }
            this.queueData.add(newNum);
        }

        public int pop(){
            if(this.queueData.isEmpty()){
                throw new RuntimeException("Your stack is empty.");
            }
            int value = this.queueData.poll();
            if(value == this.getMax()){
                this.queueMax.poll();
            }
            return value;
        }

        public int getMax(){
            if(this.queueMax.isEmpty()){
                throw new RuntimeException("Your queue is empty.");
            }
            return this.queueMax.peek();
        }
    }

}
