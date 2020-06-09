package jianzhiOffer;

/**
 * 把字符串转换为整数
 * 将一个字符串转换成一个整数，
 * 字符串不是一个合法的数值则返回 0，
 * 要求不能使用字符串转换整数的库函数。
 */
public class test {
    public static int StrToInt(String str) {
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
        ret = isNegative ? -ret : ret;
        if(ret < Integer.MIN_VALUE  || ret > Integer.MAX_VALUE )
            return 0;
        return (int)ret;
    }
    public static void main(String [] args){
        int a = 5;
        a &= -a;
        String str = "100";
        StringBuffer sb  = new StringBuffer(str);
        sb.delete(0,2);
        //sb.append(str.substring(3));
        System.out.println("*********************");
        System.out.println(false || true && true);
        System.out.println(sb.charAt(0) == '.');
        System.out.println(Integer.MIN_VALUE);
        System.out.println(Integer.MAX_VALUE);
        System.out.println(StrToInt("-2147483649"));
    }
}
