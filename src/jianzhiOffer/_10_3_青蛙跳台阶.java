package jianzhiOffer;

/**
 * 一只青蛙一次可以跳1级台阶,也可以跳上2级,
 * 求一只青蛙跳上一个n级台阶总共有多少种跳法
 * 当 n = 1 时，只有一种跳法：
 * 当 n = 2 时，有两种跳法：
 * 跳 n 阶台阶，可以先跳 1 阶台阶，再跳 n-1 阶台阶；
 * 或者先跳 2 阶台阶，再跳 n-2 阶台阶。
 * 而 n-1 和 n-2 阶台阶的跳法可以看成子问题，该问题的递推公式为：
 * f(n) = 1 when n = 1
 * f(n) = 2 when n = 2
 * f(n) = f(n-1) + f(n-2) when n > 2
 */
public class _10_3_青蛙跳台阶 {
    public static int JumpFloor(int n){
        if(n <= 2)
            return n;
        int pre2 = 1, pre1 = 2;
        int result = 0;
        for(int i = 3; i <= n; i++){
            result = pre2 + pre1;
            pre2 = pre1;
            pre1 = result;
        }
        return result;
    }

}
