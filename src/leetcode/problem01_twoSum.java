package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 题目描述
 * 给定一个整数数组 nums 和一个目标值 target，
 * 请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * 给定 nums = [2, 7, 11, 15], target = 9
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 */

public class problem01_twoSum {
    /**
     *  暴力法
     * @param nums 目标数组
     * @param target 目标和
     * @return 返回目标和的两个数字对应的下标
     */
    private static int [] twoSum_1(int [] nums, int target){
        for (int i = 0; i < nums.length; i++){
            for (int j = i + 1; j < nums.length; j++){
                if (nums[j] == target - nums[i]){
                    return new int [] {i, j};
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    /**
     * 两遍hash表
     * @param nums 目标数组
     * @param target 目标和
     * @return 返回目标和的两个数字对应的下标
     */
    private static int [] twoSum_2(int [] nums, int target){
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++){
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++){
            int complement = target - nums[i];
            if(map.containsKey(complement) && map.get(complement) != i){
                return new int [] {i, map.get(complement)};
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    /**
     * 一遍hash表
     * @param nums 目标数组
     * @param target 目标和
     * @return 返回目标和的两个数字对应的下标
     */
    private static int [] twoSum_3(int [] nums, int target){
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++){
            int comp = target - nums[i];
            if(map.containsKey(comp) && map.get(comp) != i){
                return new int [] {i, map.get(comp)};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public static void main(String [] args){
        int [] nums = {2,7,11,15};
        int target = 22;
        int [] result = twoSum_3(nums, target);

        System.out.println(Arrays.toString(result));


    }

}
