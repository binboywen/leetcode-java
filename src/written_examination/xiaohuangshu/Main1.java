package written_examination.xiaohuangshu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main1 {
    public static void main(String [] args){
//        Scanner sc = new Scanner(System.in);
//        String str = sc.nextLine();
        String str =
                "This is a very very very very very very very very very very very very very very very " +
                "very very very very very very very very very very very very very very very very very " +
                "very very very very very very very very very very very very very very very very very " +
                "very very very very very very very very very very very very very very very very very " +
                "very very very very very very very very very very very very very very very very very " +
                "very very very very very very very very very very very very very very very very very " +
                "very very very very very very very very very very very very very very very very very " +
                "very very very very very very very very very very very very very very very very very " +
                "very very very very very very very very very very very very very very very very very " +
                "very very very very very very very very very very very very very very very very very " +
                "very very very very very very very very very very very very very very very very very " +
                "very very very very very very very very very very very very long sentence.With lon" +
                "ger than 1024 bytes paragraph, it should be splitted into 2 part.\n" +
                "One is: This is a very very very very very very very very very very very very very very very " +
                "very very very very very very very very very very very very very very very very very " +
                "very very very very very very very very very very very very very very very very very" +
                "very very very very very very very very very very very very very very very very very" +
                "very very very very very very very very very very very very very very very very very" +
                "very very very very very very very very very very very very very very very very very" +
                "very very very very very very very very very very very very very very very very very" +
                "very very very very very very very very very very very very very very very very very" +
                "very very very very very very very very very very very very very very very very very" +
                "very very very very very very very very very very very very very very very very very" +
                "very very very very very very very very very very very very long sentence.\n" +
                "The Other is: With longer than 1024 bytes paragraph, it should be splitted into 2 part.";
        String [] st = splitMsg(str);
        for(String strr : st){
            System.out.println(strr);
        }
    }
    public static String [] splitMsg(String textContent){

        if(textContent.getBytes().length <= 1024){
            return new String[]{textContent};
        }
        List<String> lists = new ArrayList<>();
        String [] strEnter = textContent.split("\n");
        for(String str : strEnter){
            if(str.getBytes().length > 1024){
               String [] strJuHao = str.split("\\.");
               for(String strJH : strJuHao){
                   if(strJH.getBytes().length > 1024){
                       String [] strGanTanHao = str.split("!");
                       for(String strGTH : strGanTanHao){
                           lists.add(strGTH);
                       }
                   }
                   lists.add(strJH);
               }

               continue;
            }
            lists.add(str);
        }
        String [] result = new String[lists.size()];
        lists.toArray(result);
        return result;
    }
}
