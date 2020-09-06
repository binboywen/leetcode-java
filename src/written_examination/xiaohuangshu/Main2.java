package written_examination.xiaohuangshu;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main2 {
    public static int Llength(int[] nums) {
        int[] dp = new int[nums.length];
        int len = 0;
        for (int num : nums) {
            int i = Arrays.binarySearch(dp, 0, len, num);
            if (i < 0) {
                i = -(i + 1);
            }
            dp[i] = num;
            if (i == len) {
                len++;
            }
        }
        return len;
    }

    public static int getmaxflower(int[][] flower) {
        // sort on increasing in first dimension and decreasing in second
        Arrays.sort(flower, new Comparator<int[]>() {
            public int compare(int[] arr1, int[] arr2) {
                if (arr1[0] == arr2[0]) {
                    return arr2[1] - arr1[1];
                } else {
                    return arr1[0] - arr2[0];
                }
            }
        });
        // extract the second dimension and run LIS
        int[] lastD = new int[flower.length];
        for (int i = 0; i < flower.length; ++i) lastD[i] = flower[i][1];
        return Llength(lastD);
    }

    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();
        int col = sc.nextInt();
        int [][] array = new int[row][2];
        for(int i = 0; i < row; i++){
            array[i][0] = sc.nextInt();
            array[i][1] = sc.nextInt();
        }
        System.out.println(getmaxflower(array));
    }
}
