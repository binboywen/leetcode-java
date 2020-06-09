package jianzhiOffer;

/**
 * 0到n-1中缺失的数字
 * 一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且
 * 每个数字都在范围0到n-1之内，在0到n-1内的n个数字中有且只有一个
 * 数字不在该数组中，请找出这个数字。
 * 可以采用基于二分的方法解决
 */
public class _53_2_getMissingNumber {
    /**
     * 如果中间元素的值和下标相等，那么下一轮只需要查找右边；
     * 如果不相等，并且它前面一个元素和它的下标相等，那么中间
     * 元素正好就是第一个值和小标不相等元素，它的下标就是在数组中
     * 不存在的数字。如果中间元素的值和下标不相等，且它前面一个元素和
     * 它的下标不相等，这意味着下一轮查找只需要在左半边查找即可。
     */
    public static int GetMissingNumber(int[] numbers){

        if(numbers == null || numbers.length <= 0)
            return -1;
        int length = numbers.length;
        int left = 0;
        int right = length - 1;
        while(left <= right){
            int middle = left +  (right - left) >> 1;
            if(numbers[middle]!=middle){
                if(middle == 0 || numbers[middle - 1] == middle - 1)
                    return middle;
                right = middle - 1;
            }else{
                left = middle + 1;
            }

        }
        if(left == length)
            return length;
        return -1;
    }
}
