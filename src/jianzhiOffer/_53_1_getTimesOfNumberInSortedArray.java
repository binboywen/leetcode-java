package jianzhiOffer;

/**
 * 数字在排序数组中出现的次数
 */
public class _53_1_getTimesOfNumberInSortedArray {
    public int GetNumberOfK(int [] nums, int k){
        int first = binarySearch(nums, k);
        int last = binarySearch(nums, k + 1);
        return (first == nums.length || nums[first] != k) ? 0 : last - first;
    }

    private int binarySearch(int [] nums, int k){
        int l = 0;
        int h = nums.length;
        while(l < h){
            int m = l + (h - l) / 2;
            if(nums[m] >= k)
                h = m;
            else
                l = m + 1;
        }
        return l;
    }
}
