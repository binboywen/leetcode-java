package jianzhiOffer;

/**
 * 我们可以使用2*1的小矩形横着或者竖着去覆盖更大的矩形，请问
 * 用n个2*1的小矩形无重叠的覆盖一个2*n的大矩形，总共有多少种方法？
 * 题解：
 * 当n = 1时，只有一种覆盖方法
 * 当n = 2时，有两种覆盖方法
 * 要覆盖2*n的大矩形，可以先覆盖2*1的小矩形，在覆盖2（n-1）的大矩形；
 * 或者先覆盖2*2的矩形再覆盖2*（n-2）的矩形；
 * 而覆盖2*（n-1）和2*（n-2）的矩形可以看成子问题，递推公式：
 * f(n) = 1 when n = 1
 * f(n) = 2 when n = 2
 * f(n) = f(n -1) + f(n - 2) when n > 2
 */
public class _10_2_矩形覆盖 {
    public static int rectCover(int n ){
        if (n <= 2)
            return n;
        int pre2 = 1, pre1 = 2;
        int result = 0;
        for (int i = 3; i <= n; i++){
            result = pre1 + pre2;
            pre2 = pre1;
            pre1 = result;
        }
        return result;
    }
}
