package jianzhiOffer;

import javafx.scene.SnapshotParameters;

import java.util.*;

public class test2 {
    public static void main(String [] args){
        String str1 = "001000100102345678ABCDEF00";
        String str2 = "02345678ABCDEF0010010010010";
        String str3 = "00102345678ABCDEF00";
        List<Integer> list = new ArrayList<>();
        Collections.sort(list);
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while(t-- > 0){
            String str = sc.nextLine();
            System.out.println(getDelete(str));
        }
    }
    public static int getDelete(String str){
        int result = 0;
        int lastIndx = 0;
        int cons = 1;
        for(int i = 0; i <= str.length() - 4; i++){
            if(str.substring(i,i+4).equals("0010")){
                if(lastIndx + 3 == i){
                    cons++;
                }
                else{
                    if(cons <= 2){
                        result += cons;
                    }else{
                        result += cons - 1;
                    }
                }
                lastIndx = i;
            }
        }

        return result;
    }
}
