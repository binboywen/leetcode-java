package jianzhiOffer;

/**
 * 连续子数组的最大和
 * {6, -3, -2, 7, -15, 1, 2, 2}，
 * 连续子数组的最大和为 8（从第 0 个开始，到第 3 个为止）。
 */
public class _42_FindGreatestSumOfSubArray {

    public int FindGreatestSumOfSubArray(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int greatestSum = Integer.MIN_VALUE;
        int sum = 0;
        for (int val : nums) {
            sum = sum <= 0 ? val : sum + val;
            greatestSum = Math.max(greatestSum, sum);
        }
        return greatestSum;
    }
}
