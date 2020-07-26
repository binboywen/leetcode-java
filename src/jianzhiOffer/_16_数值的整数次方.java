package jianzhiOffer;

/**
 * 给定一个double类型的浮点数base和int类型的整数exponent，
 * 求base的exponent次方
 */
public class _16_数值的整数次方 {
    /**
     * 解决方法：
     * x^n = (x * x) ^ (n/2) when n%2=0
     * x^n = x * (x * x) ^ (n/2) when n%2=1
     * 利用递归求解，O(logN)
     */
    public double Power(double base, int exponent){
        if (exponent == 0)
            return 1;
        if (exponent == 1)
            return base;
        boolean isNegative = false;
        if (exponent < 0){
            exponent = - exponent;
            isNegative = true;
        }
        double pow = Power(base * base, exponent / 2);
        if (exponent % 2 != 0)
            pow = pow * base;
        return isNegative ? 1 / pow : pow;
    }

}
