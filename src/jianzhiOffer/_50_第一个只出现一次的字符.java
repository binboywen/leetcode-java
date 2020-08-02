package jianzhiOffer;

import java.util.BitSet;

/**
 * 第一个只出现一次的字符
 * 在字符串中找出第一个只出现一次的字符。如输入"abaxxdeff"
 * 则输出'b'
 */
public class _50_第一个只出现一次的字符 {
    /**
     * 首先想到的方法当让是使用HashMap
     * 并且可以使用整型数组代替HashMap
     */
    public static Character FirstNotRepeatingChar(String str){
        int [] cnts = new int[256];
        for(int i = 0; i < str.length();i++){
            cnts[str.charAt(i)]++;
        }
        for(int i = 0; i < str.length(); i++){
            if(cnts[str.charAt(i)] == 1)
                return str.charAt(i);
        }
        return null;
    }
    /**
     * 以上实现的空间复杂度还不是最优的。
     * 考虑到只需要找到只出现一次的字符，
     * 那么需要统计的次数信息只有 0,1,更大，
     * 使用两个比特位就能存储这些信息。
     */
    public static Character FirstNotRepeatingChar2(String str){
        BitSet bs1 = new BitSet(256);
        BitSet bs2 = new BitSet(256);
        for(char c : str.toCharArray()){
            if(!bs1.get(c) && !bs2.get(c))
                bs1.set(c);
            else if(bs1.get(c) && !bs2.get(c))
                bs2.set(c);
        }
        for(int i = 0; i < str.length(); i++){
            char c = str.charAt(i);
            if(bs1.get(c) && !bs2.get(c))
                return c;
        }
        return null;
    }

}
