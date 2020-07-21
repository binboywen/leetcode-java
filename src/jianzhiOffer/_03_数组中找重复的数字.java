package jianzhiOffer;

import java.util.Arrays;

/**
 * 在一个长度为 n 的数组里的所有数字都在 0 到 n-1 的范围内。
 * 数组中某些数字是重复的，但不知道有几个数字是重复的，
 * 也不知道每个数字重复几次。请找出数组中任意一个重复的数字。
 * Input: {2, 3, 1, 0, 2, 5}
 * Output: 2
 */

public class _03_数组中找重复的数字 {
    /**
     * 对于这种数组元素在 [0, n-1] 范围内的问题，可以将值为 i 的元素调整到第 i 个位置上进行求解。
     * 以 (2, 3, 1, 0, 2, 5) 为例，遍历到位置 4 时，该位置上的数为 2，
     * 但是第 2 个位置上已经有一个 2 的值了，因此可以知道 2 重复
     * 可以改变数组结构的情况下才用交换的方式找到重复的数字
     * 每个数字最多只要交换两次就能找到属于它自己的位置
     * 时间复杂度O(n) 空间复杂度O(1)
     */
    public static boolean duplicate(int [] nums,int length,int[] duplication){
        if (nums == null || length <=0 ){
            return false;
        }
        for(int i = 0; i < length; i++){
            while(nums[i] != i){
                if (nums[i] == nums[nums[i]]){
                    duplication[0] = nums[i];
                    return true;
                }
                swap(nums, i, nums[i]);
            }
        }
        return false;
    }
    private static void swap(int [] nums,int i ,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    /**
     * 现要求不能改变原来的数组
     * 则采用二分法进行查找，并统计在1~m中的数字的数目
     * 如果1`m的数字数目超过m那么这一半的区间里一定包含重复的数字，否则，另一半区间
     * 一定包含重复的数字
     * 时间复杂度O(n log n) 空间O(1) 超过时间限制
     */
    public static int duplicate_2(int [] nums,int length){
        int start = 0;
        int end = length - 1;
        while(end >= start){
            int middle = start + ((end - start) >> 1);
            int count = countRange(nums,start,middle);
            if(end == start){
                if(count > 1) return start;
                else return -1;
            }
            if(count > (middle - start + 1)){
                end = middle;
            }else if(count == (middle - start + 1) && countRange(nums, middle + 1, end) == (end - middle)){
                if(countRange(nums, end, end) > 1){
                    return end;
                }
                else end = end - 1;
            }else {
                start = middle + 1;
            }
        }
        return -1;
    }

    public static int countRange(int [] numbers,int from, int to){
        int count = 0;
        for (int i = 0; i < numbers.length; i++){
            if (numbers[i] <= to && numbers[i] >= from){
                count++;
            }
        }
        return count;
    }
    //方法3：在对应位置上＋length
    public boolean duplicate_3(int numbers[],int length,int [] duplication){
        for(int i = 0; i < length; i++){
            int index = numbers[i];
            if(index >= length){
                index -= length;
            }
            if(numbers[index] >= length){
                duplication[0] = index;
                return true;
            }
            numbers[index] += length;
        }
        return false;
    }
    //方法4 hashset if(!hashset.add(num[i])) return num[i]
    public static void main(String [] args){
        int [] arr = {0,1,2,0,4,5,6,7,8,9};
        int out = duplicate_2(arr,arr.length);
        System.out.println(out);
    }
}
