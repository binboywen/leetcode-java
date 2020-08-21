package written_examination.DiDi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        List<List<Integer>> lists = new ArrayList<>();
        int n = sc.nextInt();
        for(int i = 100; i < 1000; i++){
            StringBuffer sb1 = new StringBuffer(String.valueOf(i));
            StringBuffer sb2 = new StringBuffer(String.valueOf(i));
            sb2.setCharAt(1,sb1.charAt(2));
            if(sb1.charAt(0) == sb1.charAt(1) ||
                    sb1.charAt(0) == sb1.charAt(2) ||
                    sb1.charAt(1) == sb1.charAt(2) ||
                    sb2.charAt(0) == sb2.charAt(1) || sb1.equals(sb2)){
                continue;
            }
            int temp = Integer.valueOf(sb1.toString()) + Integer.valueOf(sb2.toString());
            if(temp == n){
                List<Integer> list = new ArrayList<>();
                list.add(Integer.valueOf(sb1.toString()));
                list.add(Integer.valueOf(sb2.toString()));
                lists.add(list);

            }
        }
        System.out.println(lists.size());
        for(List<Integer> list : lists){
            System.out.println(list.get(0) + " " + list.get(1));
        }
    }
}
