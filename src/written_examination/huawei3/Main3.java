package written_examination.huawei3;

import java.util.*;

public class Main3 {
    static int r,c;
    static double [][] dp;
    static double [][][] mp;
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        r = sc.nextInt();
        c = sc.nextInt();
        dp = new double[r + 55][c + 55];
        mp = new double[r + 55][c+55][3];
        for(int i = 1; i <= r; i++){
            for(int j = 1; j <= c; j++){
                mp[i][j][2] = sc.nextDouble();
                mp[i][j][1] = sc.nextDouble();
                mp[i][j][0] = sc.nextDouble();
            }
        }
        for(int i=r;i>0;i--) {
            for(int j=c;j>0;j--) {
                if(i == r && j == c ){
                    continue;
                }
                if(Math.abs( 1- mp[i][j][0]) < 1e-7){
                    continue;
                }
                dp[i][j] = (mp[i][j][1]*dp[i][j+1]+mp[i][j][2]*dp[i+1][j]+1)/(1-mp[i][j][0]);
            }
        }
        System.out.println(dp[1][1]);
    }
}
