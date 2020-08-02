package jianzhiOffer;

/**
 * 从1到n整数中1出现的次数，例如：1到12中
 * 1、10、11、12，一共出现五次
 */
public class _43_1到N中1出现的次数 {
    public static int NumberOf1Between1AndN(int n){
        int digit = 1, res = 0;
        int high = n / 10, cur = n % 10, low = 0;
        while(high != 0 || cur != 0) {
            if(cur == 0) res += high * digit;
            else if(cur == 1) res += high * digit + low + 1;
            else res += (high + 1) * digit;
            low += cur * digit;
            cur = high % 10;
            high /= 10;
            digit *= 10;
        }
        return res;
    }
    public static void main(String [] args){
        System.out.println(NumberOf1Between1AndN(112));
    }
}
