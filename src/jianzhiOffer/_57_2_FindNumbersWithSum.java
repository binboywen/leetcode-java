package jianzhiOffer;

import java.util.ArrayList;

/**
 * 和为s的连续正数序列
 * 输入一个正数s，打印出所有和为s的连续正数序列(至少含有两个数)
 * 例如输入15，由于1+2+3+4+5 = 4+5+6 = 7+8 = 15
 */
public class _57_2_FindNumbersWithSum {
    /**
     * 依据上题的解法
     * 用两个数small和big分别表示序列的最小值和最大值，首先把small
     * 初始化1，big初始化2。如果从small到big的序列和大于s，则可以从序列中
     * 去掉较小的值，也就是增大small。如果small到big的序列的和小于s，则可以增大big，
     * 让这个序列包含更多的数字。因为这个序列至少要有两个数字，我们一直增加small到
     * (1+s)/2为止。
     */
    public static ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum){
        ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
        if(sum < 3){
            return ret;
        }
        int start = 1;
        int end = 2;
        int curSum = 3;
        while(end < sum){
            if(curSum > sum){
                curSum-=start;
                start++;
            }else if(curSum < sum){
                end++;
                curSum+=end;
            }else{
                ArrayList<Integer> list = new ArrayList<>();
                for(int i = start;i <= end; i++){
                    list.add(i);
                }
                ret.add(list);
                curSum -= start;
                start++;


            }
        }
        return ret;
    }
}
