package jianzhiOffer;

/**
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如：{1,2,3,2,2,2,5,4,2}，2的次数为5超过数组长度9的一半，因此
 * 输出2.
 * 对于数组的特性：数组中有一个数字出现的次数超过了数组长度的一半。
 * 如果把这个数组进行排序，那么排序之后位于数组中间的数字一定就是那个
 * 出现次数超过数组长度一半的数字。也就是说，这个数字就是中位数，即
 * 长度为n的数组中第n/2大的数字。
 */
public class _39_theNumOverHalfLengthOfArray {
    /**
     *在随机快速排序算法中，我们现在数组中随机选择一个数字，然后调整数组中
     * 数字的顺序，使得比选中的数字小的数字都排在它的左边，比选中的数字大的
     * 数字排在它的右边。如果这个选中的数字的下标刚好是n/2，那么这个数字就是
     * 数组中的中位数；如果它的下标大于n/2那么中位数应该位于它的左边，我们可以
     * 接着在它的左边部分的数组中查找；如果它的下标小于n/2那么中位数应该位于它的
     * 右边，我们可以接着在它的右边部分数组中查找。
     */
    public int moreThanHalfNum(int [] numbers){
        if(numbers==null || numbers.length == 0)
            return -1;
        int middle = numbers.length >> 1;
        int start = 0;
        int end = numbers.length - 1;
        int index = Partition(numbers, numbers.length,start,end);
        while(index != middle){
            if(index > middle){
                end = index -1 ;
                index = Partition(numbers, numbers.length,start,end);
            }
            else{
                start = index + 1;
                index = Partition(numbers,numbers.length,start,end);
            }
        }
        int result = numbers[middle];
        if(!CheakMoreThanHalf(numbers,result))
            result = 0;
        return result;
    }

    public boolean CheakMoreThanHalf(int [] numbers, int number){
        int times = 0;
        for(int i = 0; i < numbers.length; ++i){
            if (numbers[i] == number) {
                times++;
            }
        }
        boolean isMoreThanHalf = true;
        if(times * 2 <= numbers.length)
            isMoreThanHalf = false;
        return isMoreThanHalf;
    }

    public int Partition(int [] data, int length, int start, int end){
        if(data == null || length == 0 || start < 0 || end >= length)
            throw new RuntimeException("Invalid Parameters");
        int index = (int) (Math.random() * (end - start + 1));
        swap(data, start + index, end);
        int small = start - 1;
        for(index = start; index < end; ++index){
            if(data[index] < data[end]){
                ++small;
                if(small != index)
                    swap(data,index,small);
            }
        }
        ++small;
        swap(data,small,end);
        return small;
    }
    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
    /**
     * 根据数组特点找出时间复杂度为O(N)的算法
     * 数组中有一个数字出现的次数超过数组长度的一半，也就是说，它出现
     * 的次数比其他数字出现的次数的和还要多，因此，我们可以考虑在遍历数组的
     * 时候保存两个值：一个是数组中的一个数字，另一个是次数。当我们遍历到下
     * 一个数字的时候，如果下一个数字和我们之前保存的数字相等，则次数加1，如果
     * 不同就减去1。如果次数为零，那么我们需要保存下一个数字，并把次数设置为1。
     * 由于我们要找的数字出现的次数比其他所有数字的出现的次数之和还要多。那么要
     * 找的数字肯定是是最后以此把次数设置为1时对应的数字
     * 多数投票问题，可以利用 Boyer-Moore Majority Vote Algorithm 来解决这个问题，
     * 使得时间复杂度为 O(N)。
     */
    public int MoreThanHalfNum_Solution(int[] nums) {
        int majority = nums[0];
        for (int i = 1, cnt = 1; i < nums.length; i++) {
            cnt = nums[i] == majority ? cnt + 1 : cnt - 1;
            if (cnt == 0) {
                majority = nums[i];
                cnt = 1;
            }
        }
        int cnt = 0;
        for (int val : nums)
            if (val == majority)
                cnt++;
        return cnt > nums.length / 2 ? majority : 0;
    }
}
