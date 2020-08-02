package jianzhiOffer;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 *滑动窗口的最大值
 * 给定一个数组和滑动窗口的大小，请找出所有滑动窗口里的最大值。如果数组
 * 为{2,3,4,2,6,2,5,1}，那么一共存在6个滑动窗口，它们的最大值分别为
 * {4,4,6,6,6,5}
 */
public class _59_1_滑动窗口的最大值 {

    public ArrayList<Integer> maxInWindows(int[] nums, int k) {
        ArrayList<Integer> ret = new ArrayList<>();
        if (k > nums.length || k < 1)
            return ret;
        PriorityQueue<Integer> heap = new PriorityQueue<>((o1, o2) -> o2 - o1);  /* 大顶堆 */
        for (int i = 0; i < k; i++)
            heap.add(nums[i]);
        ret.add(heap.peek());
        for (int i = 0, j = i + k; j < nums.length; i++, j++) {
            /* 维护一个大小为 k 的大顶堆 */
            heap.remove(nums[i]);
            heap.add(nums[j]);
            ret.add(heap.peek());
        }
        return ret;
    }
}
