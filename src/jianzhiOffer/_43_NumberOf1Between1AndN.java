package jianzhiOffer;

/**
 * 从1到n整数中1出现的次数，例如：1到12中
 * 1、10、11、12，一共出现五次
 */
public class _43_NumberOf1Between1AndN {
    public static int NumberOf1Between1AndN(int n){
        int cnt = 0;
        for(int m = 1; m <= n; m*=10){
            int a = n/m,b = n % m;
            cnt += (a + 8) / 10 * m + (a % 10 == 1?b+1:0);
        }
        return cnt;
    }
    public static void main(String [] args){
        System.out.println(NumberOf1Between1AndN(112));
    }
}
