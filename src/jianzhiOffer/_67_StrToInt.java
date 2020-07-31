package jianzhiOffer;

/**
 * 把字符串转换为整数
 * 将一个字符串转换成一个整数，
 * 字符串不是一个合法的数值则返回 0，
 * 要求不能使用字符串转换整数的库函数。
 */
public class _67_StrToInt {
    public static long StrToInt(String str) {
        if (str == null || str.length() == 0)
            return 0;
        boolean isNegative = str.charAt(0) == '-';
        long ret = 0L;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (i == 0 && (c == '+' || c == '-'))  /* 符号判定 */
                continue;
            if (c < '0' || c > '9')                /* 非法输入 */
                return 0;
            int a = c - '0';
            ret = ret * 10 + a;
        }
        return isNegative ? -ret : ret;
    }
    public static void main(String [] args){
        String aa = "2147483649";
        System.out.println(StrToInt(aa));
    }
}
