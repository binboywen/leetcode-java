package jianzhiOffer;

/**
 * 把字符串转换为整数
 * 将一个字符串转换成一个整数，
 * 字符串不是一个合法的数值则返回 0，
 * 要求不能使用字符串转换整数的库函数。
 */
public class _67_字符串转换成整数 {
    //AC代码
    public int strToInt2(String str) {
        char[] c = str.trim().toCharArray();
        if(c.length == 0) return 0;
        //int_max = 2147483647
        //bndry = 214748364
        int res = 0, bndry = Integer.MAX_VALUE / 10;
        int i = 1, sign = 1;
        if(c[0] == '-') sign = -1;
        else if(c[0] != '+') i = 0;
        for(int j = i; j < c.length; j++) {
            if(c[j] < '0' || c[j] > '9') break;
            if(res > bndry || res == bndry && c[j] > '7') return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            res = res * 10 + (c[j] - '0');
        }
        return sign * res;

    }
    public static long StrToInt(String str) {
        if (str == null || str.length() == 0)
            return 0;
        boolean isNegative = str.charAt(0) == '-';
        long ret = 0L;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (i == 0 && (c == '+' || c == '-'))
                continue;
            if (c < '0' || c > '9')
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
