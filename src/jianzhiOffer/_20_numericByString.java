package jianzhiOffer;

/**
 * 请实现一个函数用来判断字符串是否表示数值(包括小数和整数)。
 * 例如，字符串"+100"、"5e2"、"-123"、"3.1416"、"-E-16"都表示数值
 * 但是，"12e"、"1a3.14"、"1.2.3"、"+-5"、"12e+5.4"都不是数值
 * 表示数值的字符串遵循模式A[.[B]][e|EC]或者.B[e|EC]，其中A为数值的
 * 整数部分，B为紧跟着小数点为数值的小数部分，C紧跟着'e'或者'E'为
 * 数值的指数部分，在小数里可能没有数值的整数部分。例如，小数.123等于0.123
 * 因此A部分不是必需的。如果一个数没有整数部分，那么它的小数部分
 * 不能为空。
 * 上述A和C都是可能以'+'或'-'开头的0~9数位串；B也是0~9的数位串，
 * 但是前面不能有正负号
 */
public class _20_numericByString {
    public static void main(String [] args){
        String test = "12e";
        Solution ss = new Solution();

        boolean result = ss.isNumeric(test.toCharArray());
        System.out.println(result);
    }

}
class Solution {
    StringBuffer stringBuffer;
    public boolean isNumeric(char[] str) {
        if(str == null)
            return false;

        stringBuffer = new StringBuffer(String.valueOf(str));

        boolean numeric = scanInteger();
        //前面的正负号和数字已经去除，接下来看看下一个是不是小数点
        if(stringBuffer.length() < 1)
            return numeric;
        if(stringBuffer.charAt(0) == '.'){

            stringBuffer.deleteCharAt(0);
            numeric = scanUnsignedInteger() || numeric;
        }
        if(stringBuffer.length() < 1)
            return numeric;
        if(stringBuffer.charAt(0) == 'e' || stringBuffer.charAt(0) == 'E'){
            stringBuffer.deleteCharAt(0);
            numeric = numeric && scanInteger();
        }
        return numeric && (stringBuffer.length() == 0);


    }

    boolean scanUnsignedInteger(){
        if(stringBuffer.length() == 0)
            return false;
        int i = 0;
        while(stringBuffer.length() > 0 && i < stringBuffer.length() && stringBuffer.charAt(i) >= '0' && stringBuffer.charAt(i) <= '9'){
            i++;
        }
        stringBuffer.delete(0,i);
        return (i > 0);
    }

    boolean scanInteger(){
        if(stringBuffer.length() == 0)
            return false;
        if(stringBuffer.length() > 0 &&stringBuffer.charAt(0) == '+' || stringBuffer.charAt(0) == '-'){
            stringBuffer.deleteCharAt(0);
        }
        boolean temp = scanUnsignedInteger();
        return temp;
    }
    public boolean isNumeric2(char[] str){
        /**
         * 使用正则表达式进行匹配
         * []  ： 字符集合
         * ()  ： 分组
         * ?   ： 重复 0 ~ 1 次
         * +   ： 重复 1 ~ n 次
         * *   ： 重复 0 ~ n 次
         * .   ： 任意字符
         * \\. ： 转义后的 .
         * \\d ： 数字
         */
        if(str == null || str.length == 0){
            return false;
        }
        return new String(str).matches("[+-]?\\d*(\\.?\\d+)?([eE][+-]?\\d+)?");
    }
}