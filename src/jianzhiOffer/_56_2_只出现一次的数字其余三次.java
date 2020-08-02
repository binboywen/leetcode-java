package jianzhiOffer;

/**
 * 数组中唯一只出现一次的数字
 * 在一个数组中除一个数字只出现一次之外，其他数字都出现了三次。
 * 找出那个只出现一次的数字
 */
public class _56_2_只出现一次的数字其余三次 {
    /**
     * 三个相同的数字的异或结果还是该数字。尽管我们这里不能应用
     * 异或运算，我们还是可以沿用位运算的思路。如果一个数字出现三次
     * 那么它的二进制表示的每一位(0或者1)也出现三次。如果把所有出现
     * 三次的数字的二进制表示的每一位都分别加起来，那么每一位的和都能
     * 被3整除，那么那个只出现一次的数字二进制表示中对应的那一位是0
     * ；否则就是1;
     */
    public static int FindNumsAppearOnce_(int [] nums ){
        if(nums == null || nums.length <= 0)
            throw new RuntimeException("Invalid input");
        int [] bitSum = new int[32];
        for(int i = 0;i < nums.length; ++i){
            int bitMask = 1;
            for(int j = 31 ; j >= 0; --j){
                int bit = nums[i] & bitMask;
                if(bit != 0)
                    bitSum[j] += 1;
                bitMask = bitMask << 1;
            }
        }
        int result = 0;
        for(int i = 0; i < 32; ++i){
            result = result << 1;
            result += bitSum[i] % 3;
        }
        return result;
    }
    public int singleNumber(int[] nums) {
        int ones = 0, twos = 0;
        for(int num : nums){
            ones = ones ^ num & ~twos;
            twos = twos ^ num & ~ones;
        }
        return ones;
    }
}
