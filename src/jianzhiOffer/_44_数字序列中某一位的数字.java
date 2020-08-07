package jianzhiOffer;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 数字序列中的某一位数字
 * 数字以 0123456789101112131415... 的格式序列化到一个字符串中，求这个字符串的第 index 位。
 * 在这个序列中，第5位（0开始计数）是5，第13位是1，第19位是4；
 *
 */
public class _44_数字序列中某一位的数字 {
    //https://leetcode-cn.com/problems/shu-zi-xu-lie-zhong-mou-yi-wei-de-shu-zi-lcof/solution/mian-shi-ti-44-shu-zi-xu-lie-zhong-mou-yi-wei-de-6/
    public int findNthDigit(int n) {
        int digit = 1;
        long start = 1;
        long count = 9;
        while (n > count) {
            n -= count;
            digit += 1;
            start *= 10;
            count = digit * start * 9;
        }
        long num = start + (n - 1) / digit;
        int [] aa = new int[10];
        Arrays.sort(aa);
        return Long.toString(num).charAt((n - 1) % digit) - '0';
    }
}
