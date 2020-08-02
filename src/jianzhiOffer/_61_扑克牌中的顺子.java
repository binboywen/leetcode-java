package jianzhiOffer;

import java.util.Arrays;

/**
 * 扑克牌中的顺子
 * 从扑克牌中随机抽取5张牌，判断是不是一个顺子，即这5张牌是不是连续的
 * 大小王是癞子，可以代替任何数字，A为1，J为11，Q为12，K为13
 */
public class _61_扑克牌中的顺子 {
    public boolean isContinuous(int [] nums){
        if(nums.length < 5)
            return false;
        Arrays.sort(nums);

        int cnt = 0;
        for(int num : nums){
            if(num == 0)
                cnt++;
        }
        int sum = 0;
        //使用癞子去补全不连续的顺子
        for(int i = cnt; i < nums.length - 1; i++){
            if(nums[i + 1] == nums[i])
                return false;
            //cnt -= nums[i + 1] - nums[i] - i;
            sum += nums[i + 1] - nums[i] - 1;
        }

        return (cnt - sum)>=0;
    }
}
