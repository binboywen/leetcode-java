package jianzhiOffer;

/**
 * 丑数
 * 把只包含因子 2、3 和 5 的数称作丑数（Ugly Number）。
 * 例如 6、8 都是丑数，但 14 不是，因为它包含因子 7。
 * 习惯上我们把 1 当做是第一个丑数。
 * 求按从小到大的顺序的第 N 个丑数。
 */
public class _49_丑数 {
    /**
     * 一种是暴力解法
     */
    public static boolean IsUgly(int number) {
        while (number % 2 == 0)
            number /= 2;
        while (number % 3 == 0)
            number /= 3;
        while (number % 5 == 0)
            number /= 5;

        return number == 1;
    }
    public static int GetUglyNumber(int index){
        if(index <= 0)
            return 0;
        int number = 0;
        int uglyFound = 0;
        while(uglyFound < index){
            ++number;
            if(IsUgly(number))
                ++uglyFound;
        }
        return number;
    }

    /**
     * 动态规划
     * 空间换时间
     */
    public static int GetUglyNumber_2(int n){
        if(n <= 6)
            return n;
        int i2 = 0, i3 = 0, i5 = 0;
        int [] dp = new int[n];
        dp[0] = 1;
        for(int i = 1; i < n; i++){
            int next2 = dp[i2] * 2, next3 = dp[i3] * 3, next5 = dp[i5] * 5;
            dp[i] = Math.min(next2,Math.min(next3, next5));
            if(dp[i] == next2)
                i2++;
            if(dp[i] == next3)
                i3++;
            if(dp[i] == next5)
                i5++;
        }
        return dp[n - 1];
    }
}
