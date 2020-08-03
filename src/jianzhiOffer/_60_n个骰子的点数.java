package jianzhiOffer;

import java.text.NumberFormat;
import java.util.*;

/**
 * 把n个骰子仍在地上，所有骰子朝上一面的点数之和为s，
 * 输入n，打印出s的所有可能的值出现的概率
 * n个骰子的点数和的最小值为n，最大值为6n。n个骰子的所有点数
 * 的排列数位6的n次方。要解决这个问题，我们需要先统计出每个点数
 * 出现的次数，然后把每个点数出现的次数除以6的n次方，就能求出
 * 每个点数出现的概率。
 */
public class _60_n个骰子的点数 {
    /**
     * 思路一：递归暴力
     * 我们知道点数之和s的最小值为n，最大值为6*n，
     * 因此考虑用一个大小为（6*n-n+1）的数组存放不同点数之和的情况个数，
     * 那么，如果点数之和为x，那么把它出现的情况总次数放入数组种下标为x-n的元素里。
     * 确定了如何存放不同点数之和的次数之后，
     * 我们要计算出这些次数。我们把n个骰子分为1个骰子和n-1个骰子，
     * 这1个骰子可能出现1~6个点数，由该骰子的点数与后面n-1个骰子的点数可以计算出总点数；
     * 而后面的n-1个骰子又可以分为1个和n-2个，把上次的点数，与现在这个骰子的点数相加，
     * 再和剩下的n-2个骰子的点数相加可以得到总点数……，
     * 即可以用递归实现。在获得最后一个骰子的点数后可以计算出几个骰子的总点数，
     * 令数组中该总点数的情况次数+1，即可结束遍历。
     * 可以感受到，计算量实在太大了，效率会比较低。
     */
    private final int maxValue = 6;

    public  void printProbability1(int number) {
        if(number<=0) {
            return;
        }
        int[] probabilities = new int[maxValue*number-number+1];
        Arrays.fill(probabilities,0);
        //计算不同点数出现的次数
        for(int i=1;i<=maxValue;i++) {
            //第一次掷骰子，总点数只能是1~maxValue(即6)
            calP(probabilities, number, number-1, i);
        }
        //所有情况总共出现的次数
        int totalP = (int) Math.pow(maxValue, number);
        for(int i=0; i<probabilities.length; i++) {
            double ratio = (double)probabilities[i]/totalP;
            NumberFormat format = NumberFormat.getPercentInstance();
            format.setMaximumFractionDigits(2);//设置保留几位小数
            System.out.println("点数和为"+(i+number)+"的概率为:"+format.format(ratio));
        }
    }
    private  void calP(int[] probabilities, int number, int curNumber, int sum) {
        if(curNumber==0) {
            probabilities[sum-number]++; //总数为sum的情况存放在sum-number下标中
            return;
        }
        for(int i=1; i<=maxValue; i++) {
            // 相当于剩余的骰子少一个，总点数增加。
            calP(probabilities, number, curNumber-1, sum+i);
        }
    }
    /**
     * 思路二：动态规划
     * 剑指Offer的解答过于繁琐与复杂。这里提供一种相对理解简单，容易实现的方法。
     * 我们通过分析能够发现 n个骰子的点数依赖于n-1个骰子的点数，相当于在n-1个骰子点数的基础上再进行投掷。
     * 由此定义状态转移方程为f(n,k)表示n个骰子点数和为k时出现的次数，于是可得:
     * f(n,k)=f(n−1,k−1)+f(n−1,k−2)+f(n−1,k−3)+f(n−1,k−4)+f(n−1,k−5)+f(n−1,k−6)
     * 其中 n>0且k<=6n，f(n−1,k−i)表示的是第n次掷骰子时，骰子的点数为i对应的情况
     * 从k−1到k−6分别对应第n次掷骰子时骰子正面为1到6的情况。而初始状态可以定义为：
     * f(1,1)=f(1,2)=f(1,3)=f(1,4)=f(1,5)=f(1,6)=1
     * 按照上面的思路来说依然是暴力递归，这才是暴力递归，
     * 那么考虑是否可以改为动态规划
     */
    public  void printProbability(int number) {
        double total = Math.pow(6,number);
        for(int i=number; i<=6*number; i++) {
            double ratio = (double)getNSumCount(number,i)/total;
            NumberFormat format = NumberFormat.getPercentInstance();
            format.setMaximumFractionDigits(2);//设置保留几位小数
            System.out.println("点数和为"+getNSumCount(number,i)+"的概率为:"+format.format(ratio));
        }
    }

    private int getNSumCount(int n, int sum) {
        if(n<1 || sum<n || sum>6*n) {
            return 0;
        }
        if(n==1) {
            return 1;
        }
        int resCount;
        resCount = getNSumCount(n-1,sum-1)+getNSumCount(n-1,sum-2)+
                getNSumCount(n-1,sum-3)+getNSumCount(n-1,sum-4)+
                getNSumCount(n-1,sum-5)+getNSumCount(n-1,sum-6);
        return resCount;
    }
    /**
     * 暴力递归改动态规划
     *使用一个二维数组 dp 存储点数出现的次数，其中 dp[i][j] 表示前 i 个骰子产生点数 j 的次数。
     * 由此定义状态转移方程为f(n,k)表示n个骰子点数和为k时出现的次数，于是可得:
     * f(n,k)=f(n−1,k−1)+f(n−1,k−2)+f(n−1,k−3)+f(n−1,k−4)+f(n−1,k−5)+f(n−1,k−6)
     */

    public List<Map.Entry<Integer, Double>> dicesSum(int n) {

        final int face = 6;
        final int pointNum = face * n;
        long[][] dp = new long[n + 1][pointNum + 1];

        for (int i = 1; i <= face; i++)
            dp[1][i] = 1;

        for (int i = 2; i <= n; i++)
            for (int j = i; j <= i*6; j++)     /* 使用 i 个骰子最小点数为 i */
                for (int k = 1; k <= face && k <= j; k++) /*状态转移方程 */
                    dp[i][j] += dp[i - 1][j - k];

        final double totalNum = Math.pow(6, n);
        List<Map.Entry<Integer, Double>> ret = new ArrayList<>();
        for (int i = n; i <= pointNum; i++)
            ret.add(new AbstractMap.SimpleEntry<>(i, dp[n][i] / totalNum));

        return ret;
    }

}
