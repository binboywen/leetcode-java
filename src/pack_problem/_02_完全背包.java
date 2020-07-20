package pack_problem;

import java.util.Scanner;

public class _02_完全背包 {
    /**
     * 有 N 种物品和一个容量是 V 的背包，每种物品都有无限件可用。
     * 第 i 种物品的体积是 vi，价值是 wi。
     * 求解将哪些物品装入背包，可使这些物品的总体积不超过背包容量，且总价值最大。
     * 输出最大价值。
     * 输入格式
     * 第一行两个整数，N，V，用空格隔开，分别表示物品种数和背包容积。
     * 接下来有 N 行，每行两个整数 vi,wi，用空格隔开，分别表示第 i 种物品的体积和价值。
     * 输出格式
     * 输出一个整数，表示最大价值。
     * 数据范围
     * 0<N,V≤1000
     * 0<vi,wi≤1000
     * 输入样例
     * 4 5
     * 1 2
     * 2 4
     * 3 4
     * 4 5
     * 输出样例：
     * 10
     * 朴素版解法：二维空间解法
     * 也是两种选择，选或不选，只不过每个物品可以选无限次，在01的基础上把
     * dp[i][j]=max(dp[i][j],dp[i-1][j-v[i]]+w[i])
     * 改为 dp[i][j]=max(dp[i][j],dp[i][j-v[i]]+w[i])即可
     */
    public static void main1(String [] args){
        Scanner sc = new Scanner(System.in);
        int number_of_items = sc.nextInt();
        int pack_volum = sc.nextInt();
        int [] volum = new int[number_of_items + 1];
        int [] vaule = new int[number_of_items + 1];
        for(int i = 1; i <= number_of_items; i++ ){
            volum[i] = sc.nextInt();
            vaule[i] = sc.nextInt();
        }
        int [][] dp = new int[number_of_items+1][pack_volum+1];
        dp[0][0] = 0;
        for(int i = 1; i <= number_of_items; i++){
            for(int j = 0; j <= pack_volum; j++){
                dp[i][j] = dp[i-1][j];
                if(j >= volum[i])
                    dp[i][j] = Math.max(dp[i][j], dp[i][j-volum[i]] + vaule[i]);
            }
        }
        System.out.println(dp[number_of_items][pack_volum]);
    }

    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int number_of_items = sc.nextInt();
        int pack_volum = sc.nextInt();
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
