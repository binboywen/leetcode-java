package jianzhiOffer;
import java.util.*;
public class _38_printAllPermutations_1 {
    //字典序方法
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> res = new ArrayList<String>();
        if (str.length() == 0) return res;
        char[] array = str.toCharArray();
        Arrays.sort(array);
        String s = new String(array);
        res.add(str);
        while (true) {
            s = nextString(s);
            if (!s.equals("finish")) {
                res.add(s);
            } else {
                break;
            }
        }
        return res;
    }

    public String nextString(String str) {
        char[] array = str.toCharArray();
        int length = str.length();
        int i = length - 2;
        for (; i >= 0 && array[i] >= array[i + 1]; i--) ;
        if (i == -1) return "finish";
        int j = length - 1;
        for (; j >= 0 && array[j] <= array[i]; j--) ;
        //swap i,j
        char tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
        //swap i,j
        for (int a = i + 1, b = length - 1; a < b; a++, b--) {
            tmp = array[a];
            array[a] = array[b];
            array[b] = tmp;
        }
        return new String(array);
    }

}
