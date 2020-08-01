package written_examination.qiAnXin;

import java.util.Scanner;

public class Main {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int pack_volum = sc.nextInt();
        int number_of_items = sc.nextInt();
        int [] volum = new int[number_of_items + 1];
        int [] vaule = new int[number_of_items + 1];
        for(int i = 1; i <= number_of_items; i++ ){
            volum[i] = sc.nextInt();
            vaule[i] = sc.nextInt();
        }
        int [] dp = new int[pack_volum+1];
        for(int i = 1; i <= number_of_items; i++){
            for(int j = volum[i]; j <= pack_volum ; j++){
                dp[j] = Math.max(dp[j], dp[j-volum[i]] + vaule[i]);
            }
        }
        System.out.println(dp[pack_volum]);
    }
}
