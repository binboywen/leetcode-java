package jianzhiOffer;

/**
 * 把一根绳子剪成多段，并且使得每段的长度乘积最大
 * n = 2
 * return 1 (2 = 1 + 1)
 * n = 10
 * return 36 (10 = 3 + 3 + 4)
 */
public class _14_剪绳子 {
    /**
     * 动态规划：首先定义函数f(n)为把长度为n的绳子剪成若干段
     * 后各段长度乘积的最大值。在剪第一刀时，有n-1种可能选择，
     * 也就是剪出来的第一段绳子的可能长度分别为1，2,...,n-1,
     * 因此，f(n)=max(f(i)*f(n-i)),其中0<i<n
     * 这是一个从上至下的递归公式，由于递归会有很多重复的子问题
     * 从而有大量不必要的重复计算。一个更好的办法是按照从下而上的
     * 顺序计算，也就是说我们先得到f(2)、f(3)，再得到f(4)、f(5)，
     * 直到f(n)。
     * 当绳子长度为2时，只可能剪成长度都为1的两段，因此f(2)等于1，
     * 当绳子长度为3时，f(3)等于2
     */

    public int cutRpoe_dp(int n){
        if (n < 2)
            return 0;
        if (n == 2)
            return 1;
        if (n == 3)
            return 2;

        int [] products = new int[n + 1];
        products[0] = 0;
        products[1] = 1;
        products[2] = 2;
        products[3] = 3;

        int max = 0;
        for (int i = 4; i <= n; ++i){
            max = 0;
            for (int j = 1; j <= i/2; ++j){
                int product = products[j] * products[i -j];
                if (max < product)
                    max = product;
                products[i] = max;
            }
        }
        max = products[n];
        return max;
    }

    public int cutRope_dp2(int n){
        int [] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i<=n; i++){
            for (int j = 1; j < i; j++)
                dp[i] = Math.max(dp[i], Math.max(j * (i - j),dp[j] * (i -j)));
        }
        return dp[n];
    }

    /**
     * 贪心算法：尽可能多剪长度为3的绳子，并且不允许有长度为1的绳子出现。如果出现了，
     * 就从已经切好长度为3的绳子中拿出一段与长度为1的绳子重新组合，把它们切成两段
     * 长度为2的绳子。
     * 证明：当n>=5时，3(n - 3) - n = 2n - 9 > 0，且 2(n - 2) - n = n - 4 > 0。
     * 因此在 n >= 5 的情况下，将绳子剪成一段为 2 或者 3，得到的乘积会更大。
     * 又因为 3(n - 3) - 2(n - 2) = n - 5 >= 0，
     * 所以剪成一段长度为 3 比长度为 2 得到的乘积更大。
     */
    public int greedy_algorithm(int n){
        if (n < 2)
            return 0;
        if (n == 2)
            return 1;
        if (n == 3)
            return 2;
        int timesOf3 = n /3;

        if (n - timesOf3 * 3 == 1)
            timesOf3--;
        int timesOf2 = (n - timesOf3 * 3) / 2;

        return (int) (Math.pow(3, timesOf3)) * (int)(Math.pow(2, timesOf2));
    }

}
