package written_examination.meituan;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String [] args){
        List<List<Integer>> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int count = 0;
        for(int i = 1; i <= n / 4; i++){
            if(getInverse(i)  == i * 4){
                count++;
                List<Integer> temp = new ArrayList<>();
                temp.add(i);
                temp.add(i*4);
                list.add(temp);
            }
        }
        System.out.println(count);
        for(List<Integer> a : list){
            System.out.println(a.get(0) + " " + a.get(1));
        }
    }
    public static int getInverse(int i){
        StringBuffer sb = new StringBuffer(String.valueOf(i));
        sb.reverse();
        int index = 0;
        while(index < sb.length() && sb.charAt(index) == '0'){
            index++;
        }
        if(index == 0){
            return Integer.valueOf(sb.substring(index));
        }
        if(index == sb.length()){
            return 0;
        }
        return Integer.valueOf(sb.substring(index-1));
    }

}
