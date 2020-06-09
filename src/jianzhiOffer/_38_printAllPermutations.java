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
public class _38_printAllPermutations {
    public static void printAllPermutations1(String str) {
        ArrayList<String> arrayString = new ArrayList<>();
        char[] chs = str.toCharArray();
        process1(chs, 0);
        Collections.sort(arrayString);
    }

    public static void process1(char[] chs, int i) {
        if (i == chs.length) {
            System.out.println(String.valueOf(chs));
        }
        for (int j = i; j < chs.length; j++) {
            swap(chs, i, j);
            process1(chs, i + 1);
            //交换回来，恢复上一次的状态，回溯的关键
            swap(chs, i, j);
        }
    }

    public static void printAllPermutations2(String str) {
        char[] chs = str.toCharArray();
        process2(chs, 0);
    }

    public static void process2(char[] chs, int i) {
        if (i == chs.length) {
            System.out.println(String.valueOf(chs));
        }
        HashSet<Character> set = new HashSet<>();
        for (int j = i; j < chs.length; j++) {
            if (!set.contains(chs[j])) {
                set.add(chs[j]);
                swap(chs, i, j);
                process2(chs, i + 1);
                swap(chs, i, j);
            }
        }
    }

    public static void swap(char[] chs, int i, int j) {
        char tmp = chs[i];
        chs[i] = chs[j];
        chs[j] = tmp;
    }

    public static void main(String[] args) {
        String test1 = "aa";
        printAllPermutations1(test1);
        System.out.println("======");
        printAllPermutations2(test1);
        System.out.println("======");

        String test2 = "aa";
        printAllPermutations1(test2);
        System.out.println("======");
        printAllPermutations2(test2);
        System.out.println("======");
    }
}
