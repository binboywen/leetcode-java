package jianzhiOffer;

import java.util.Stack;

/**
 * 输入两个整数序列，
 * 第一个序列表示栈的压入顺序，
 * 请判断第二个序列是否为该栈的弹出顺序。
 * 假设压入栈的所有数字均不相等。
 * 例如序列 1,2,3,4,5 是某栈的压入顺序，
 * 序列 4,5,3,2,1 是该压栈序列对应的一个弹出序列，
 * 但 4,3,5,1,2 就不可能是该压栈序列的弹出序列。
 */
public class _31_栈的压入弹出序列 {
    /**
     如果下一个弹出的数字刚好是栈顶数字，那么直接弹出；
     如果下一个弹出的数字不在栈顶，则把压栈序列中还没有入栈的
     数字压入辅助栈，直到把下一个需要弹出的数字压入栈顶为止，
     如果所有数字都已经压入栈后仍然没有找到下一个弹出的数字，
     那么该序列不可能是一个弹出序列
     */
    //使用一个栈来模拟压入弹出操作。
    public boolean IsPopOrder(int[] pushSequence, int[] popSequence) {
        int n = pushSequence.length;
        Stack<Integer> stack = new Stack<>();
        for (int pushIndex = 0, popIndex = 0; pushIndex < n; pushIndex++) {
            stack.push(pushSequence[pushIndex]);
            while (popIndex < n && !stack.isEmpty()
                    && stack.peek() == popSequence[popIndex]) {
                stack.pop();
                popIndex++;
            }
        }
        return stack.isEmpty();
    }
}
