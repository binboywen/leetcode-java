package jianzhiOffer;

/**
 * 把一个数组最开始的若干个元素搬到数组的末尾，
 * 我们称之为数组的旋转。输入一个非递减排序的数组的一个旋转，
 * 输出旋转数组的最小元素。
 * 1,2,3,4->2,3,4,1
 */
public class _11_旋转数组的最小数字 {
    /**
     * 将旋转数组对半分可以得到一个包含最小元素的新旋转数组，
     * 以及一个非递减排序的数组。新的旋转数组的数组元素是原数组的一半，
     * 从而将问题规模减少了一半，这种折半性质的算法的时间复杂度为 O(logN)
     */
    public static int minNumberInRotateArray(int[] nums) {
        if (nums.length == 0)
            return 0;
        int L = 0;
        int H = nums.length - 1;
        while (L < H) {
            int m = L + (H - L) / 2;
            if(nums[m] < nums[H])
                H = m;
            else
                L = m + 1;
        }
        return nums[L];
    }

    /**
     * 如果数组元素允许重复，会出现一个特殊的情况：nums[l] == nums[m] == nums[h]，
     * 此时无法确定解在哪个区间，需要切换到顺序查找。
     * 例如对于数组 {1,1,1,0,1}，l、m 和 h 指向的数都为 1，
     * 此时无法知道最小数字 0 在哪个区间。
     */
    public static int minNumberInRotateArray_2(int [] nums){
        if(nums.length == 0)
            return 0;
        int L = 0;
        int H = nums.length - 1;
        while(L < H){
            int m = L + (H - L) /2;
            if(nums[L] == nums[m] && nums[m] == nums[H])
                return minNumber(nums,L,H);
            else if(nums[m] <= nums[H])
                H = m;
            else
                L = m+1;
        }
        return nums[L];
    }

    public static int minNumber(int [] nums, int L, int H){
        for(int i = L; i < H; i++){
            if(nums[i] > nums[i + 1])
                return nums[i + 1];
        }
        return nums[L];
    }

}
