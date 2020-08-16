package written_examination.DJI;

import java.util.Scanner;

public class Main2 {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int number_of_items = sc.nextInt();
        int pack_volum = sc.nextInt();
        int [] volum = new int[number_of_items + 1];
        int [] value = new int[number_of_items + 1];
        for(int i = 1; i <= number_of_items; i++){
            value[i] = sc.nextInt();
            volum[i] = sc.nextInt();
        }
        int [][] dp = new int[number_of_items + 1][pack_volum + 1];
        for(int i = 1; i <= number_of_items; i++){
            for(int j = 0; j <= pack_volum; j++){
                dp[i][j] = dp[i-1][j];
                if(j >= volum[i]){
                    dp[i][j] = Math.max(dp[i][j],dp[i-1][j-volum[i]] + value[i]);
                }
            }
        }
        System.out.println(dp[number_of_items][pack_volum]);
    }
}
