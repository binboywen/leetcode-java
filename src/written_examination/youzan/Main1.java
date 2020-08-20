package written_examination.youzan;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main1 {
    public int maxSumDivFive (int[] nums) {
        // write code here
        List<Integer> listMod1 = new ArrayList<>();
        List<Integer> listMod2 = new ArrayList<>();
        List<Integer> listMod3 = new ArrayList<>();
        List<Integer> listMod4 = new ArrayList<>();
        int result = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] % 5 == 0){
                result += nums[i];
            }
            if(nums[i] % 5 == 1){
                listMod1.add(nums[i]);
            }
            if(nums[i] % 5 == 2){
                listMod2.add(nums[i]);
            }
            if(nums[i] % 5 == 3){
                listMod3.add(nums[i]);
            }
            if(nums[i] % 5 == 4){
                listMod4.add(nums[i]);
            }
        }

        return 0;
    }

    public static int maxSumDivFive1 (int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int [] dp = new int[5];
        dp[nums[0] % 5] = nums[0];
        for(int i  = 1; i < nums.length; i++){
            int [] temp = new int[5];
            for(int k = 0; k < 5; k++){
                temp[k] = dp[k];
            }
            for(int j = 0; j < 5; j++){
                int index = (temp[j] +  nums[i]) % 5;
                dp[index] = Math.max(dp[index],temp[j] + nums[i]);
            }

        }
        return dp[0];
    }

}
