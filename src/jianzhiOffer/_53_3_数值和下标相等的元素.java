package jianzhiOffer;

/**
 * 数组中数值和下标相等的元素
 * 假设一个单调递增的数组里的每一个元素都是整数并且是唯一的，
 * 请找出数组中任意一个数值等于其下标的元素。
 */
public class _53_3_数值和下标相等的元素 {
    /**
     * 暴力解法为O(N)
     * 由于数组是递增的，因此可以利用二分方法求解
     */
    public static int GetNumberSameAsIndex(int [] numbers)
    {
        if(numbers == null || numbers.length <= 0)
            return -1;
        int length = numbers.length;
        int left = 0;
        int right = length - 1;
        while(left <= right){
            int middle = left + (right - left) >> 1;
            if(numbers[middle] == middle)
                return middle;
            if(numbers[middle] > middle)
                right = middle - 1;
            else
                left = middle + 1;
        }
        return -1;
    }
}
