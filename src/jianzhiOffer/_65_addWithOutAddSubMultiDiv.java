package jianzhiOffer;
import java.util.*;
/**
 * 写一个函数，求两个整数之和，不能使用加减乘除四则运算符号
 * a ^ b 表示没有考虑进位的情况下两数的和，(a & b) << 1 就是进位。
 * 递归会终止的原因是 (a & b) << 1 最右边会多一个 0，那么继续递归，
 * 进位最右边的 0 会慢慢增多，最后进位会变为 0，递归终止。
 */
public class _65_addWithOutAddSubMultiDiv {
    public int Add(int a, int b) {
        return b == 0 ? a : Add(a ^ b, (a & b) << 1);
    }
    HashMap<Integer,Integer> hashMap = new HashMap<>();
    public int Add_(int num1, int num2){
        int sum,carry;
        do{
            sum = num1 ^ num2;
            carry = (num1 & num2) << 1;
            num1 = sum;
            num2 = carry;
        }while(num2!=0);
        return num1;
    }
}
