package written_examination.jingDong2;

import java.util.Scanner;

public class MW {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[][] map=new int[n][n*2];
        for(int i=0;i<n;i++){
            for(int j=0;j<(2*(i+1))-1;j++){
                map[i][j]=sc.nextInt();
            }
        }
        int [][]dp=new int[n][n*2];
        for(int i=n-1;i>=0;i--){
            for(int j=0;j<(2*(i+1))-1;j++){
                if(i==n-1){
                    dp[i][j]=map[i][j];
                    continue;
                }
                dp[i][j]=map[i][j]+Math.max(dp[i+1][j],Math.max(dp[i+1][j+1],dp[i+1][j+2]));
            }
        }
        System.out.println(dp[0][0]);
    }
}
