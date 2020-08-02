package jianzhiOffer;

/**
 * 数组中的逆序对
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则
 * 这两个数字组成一个逆序对，输入一个数组，求出这个数组中的逆序对总数。
 * 归并排序可解决逆序对问题
 */
public class _51_数组中的逆序对 {
    private long cnt = 0L;

    public int InversePairs(int [] nums){
        mergeSort(nums, 0, nums.length - 1);
        return (int)this.cnt % 1000000007;
    }

    private void mergeSort(int [] nums, int l,int r){
        if(r == l)
            return;
        int mid = l + ((r - l) >> 1);
        mergeSort(nums,l,mid);
        mergeSort(nums,mid+1,r);
        merge(nums,l,mid,r);
    }

    private void merge(int [] nums, int l, int m, int r) {
        int [] help = new int[r - l + 1];
        int i = 0;
        int p1 = l;
        int p2 = m + 1;
        while (p1 <= m && p2 <= r) {
            if(nums[p1] <= nums[p2]){
                help[i++] = nums[p1++];
            }else{
                help[i++] = nums[p2++];
                cnt = (cnt + m - p1 + 1) % 1000000007;
            }
        }
        while (p1 <= m) {
            help[i++] = nums[p1++];
        }
        while (p2 <= r) {
            help[i++] = nums[p2++];
        }
        for (i = 0; i < help.length; i++) {
            nums[l + i] = help[i];
        }
    }
}
