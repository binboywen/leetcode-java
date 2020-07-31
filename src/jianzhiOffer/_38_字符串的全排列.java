package jianzhiOffer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

/**
 * 输入一个字符串，打印该字符串所有的排列组合
 * 打印字符串的全排列
 * 第一步：求所有可能出现在第一个位置的字符，即把第一个字符和
 * 后面所有字符交换。
 * 第二步：固定第一个字符，求后面所有字符的排列，这时候我们仍把
 * 后面的字符分成两部分：后面字符的第一个字符，以及这个字符之后
 * 的所有字符。然后把第一个字符逐一和它后面的字符进行交换
 *
 */
public class _38_字符串的全排列 {
    static ArrayList<String> arrayString = new ArrayList<>();
    public static String[] permutation(String s) {
        char [] chs = s.toCharArray();
        process(chs,0);
        Collections.sort(arrayString);
        String [] res = new String[arrayString.size()];
        arrayString.toArray(res);
        return res;
    }
    public static void process(char [] chs, int i ){
        if(i == chs.length){
            arrayString.add(String.valueOf(chs));
        }
        HashSet<Character> set = new HashSet<>();
        for(int j = i; j < chs.length; j++){
            if (!set.contains(chs[j])){
                set.add(chs[j]);
                swap(chs,i,j);
                process(chs,i+1);
                swap(chs,i,j);
            }
        }
    }
    public static void swap(char[] chs, int i, int j) {
        char tmp = chs[i];
        chs[i] = chs[j];
        chs[j] = tmp;
    }

    public static void main(String[] args) {
        String test1 = "abcd";
        permutation(test1);
        System.out.println("======");


        String test2 = "aa";
        permutation(test2);
        System.out.println("======");

    }
}
