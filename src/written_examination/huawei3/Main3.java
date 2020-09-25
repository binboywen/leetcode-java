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
                /**
                 * 当前假如已经走了x步，到达dp[i][j]的状态
                 * 那么要走第x步的期望就是dp[i][j],也就是说当前期望(dp[i][j])乘以转移概率(1-mp[i][j][0])就等于当前步数，那么可以得到
                 * dp[i][j]*(1-mp[i][j][0])=(从右边转移过来的概率*右边格子的期望+从下边转移过来的概率*下边格子的期望+现在要走的步数1)
                 * 也就是说要走当前步数的期望dp[i][j]=(mp[i][j][1]*dp[i][j+1]+mp[i][j][2]*dp[i+1][j]+1)/(1-mp[i][j][0]);
                 */
            }
        }
        System.out.println(dp[1][1]);
    }
}
