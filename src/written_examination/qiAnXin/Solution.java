package written_examination.qiAnXin;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Solution {

    static int count = 0;
    public static int permutation(String s) {
        char [] chs = s.toCharArray();
        process(chs,0);
        return count;
    }
    public static void process(char [] chs, int i ){
        if(i == chs.length){
            if(Integer.valueOf(String.valueOf(chs)) % 7 == 0){
                count++;
            }
        }
        for(int j = i; j < chs.length; j++){
            swap(chs,i,j);
            process(chs,i+1);
            swap(chs,i,j);
        }
    }
    public static void swap(char[] chs, int i, int j) {
        char tmp = chs[i];
        chs[i] = chs[j];
        chs[j] = tmp;
    }
    public static int reletive_7(int [] digit) {
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < digit.length; i++){
            sb.append(digit[i]);
        }
        int result = permutation(sb.toString());
        return result;
    }

    public static void main(String [] args){
        System.out.println(reletive_7(new int[]{1,1,2}));
    }
}