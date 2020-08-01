package written_examination.qiAnXin;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

public class Main2 {
    static ArrayList<String> arrayString = new ArrayList<>();
    static int count = 0;
    public static int permutation(String s) {
        char [] chs = s.toCharArray();
        process(chs,0);
        Collections.sort(arrayString);
        String [] res = new String[arrayString.size()];
        arrayString.toArray(res);
        return count;
    }
    public static void process(char [] chs, int i ){
        if(i == chs.length){
            //arrayString.add(String.valueOf(chs));
            if(Integer.valueOf(String.valueOf(chs)) % 7 == 0){
                count++;
            }
        }
        //HashSet<Character> set = new HashSet<>();
        for(int j = i; j < chs.length; j++){
            //if (!set.contains(chs[j])){
             //   set.add(chs[j]);
                swap(chs,i,j);
                process(chs,i+1);
                swap(chs,i,j);
            //}
        }
    }
    public static void swap(char[] chs, int i, int j) {
        char tmp = chs[i];
        chs[i] = chs[j];
        chs[j] = tmp;
    }

    public static void main(String[] args) {
        int a = Integer.valueOf("01");
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        String data = line.substring(1,line.length() - 1);
        String [] strs = data.split(",");
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < strs.length ; i++){
            sb.append(strs[i]);
        }
        int result = permutation(sb.toString());
        System.out.println(result);


    }
}
