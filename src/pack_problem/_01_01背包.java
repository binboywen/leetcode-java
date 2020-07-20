package pack_problem;
import java.util.*;
public class _01_01背包 {
    /**
     * 有 N 件物品和一个容量是 V 的背包。每件物品只能使用一次。
     * 第 i 件物品的体积是 vi，价值是 wi。
     * 求解将哪些物品装入背包，可使这些物品的总体积不超过背包容量，且总价值最大。
     * 输出最大价值。
     * 输入格式
     * 第一行两个整数，N，V，用空格隔开，分别表示物品数量和背包容积。
     * 接下来有 N 行，每行两个整数 vi,wi，用空格隔开，分别表示第 i 件物品的体积和价值。
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
     * 8
     */
    /**
    dp[i][j] 表示只看前i个物品，背包容量是j的情况下，总价值最大是多少。
    1.不选第i个物品，dp[i][j] = dp[i - 1][j]
    2.选第i个物品，dp[i][j] = dp[i - 1][j - v[i]] + w[i]
    如果选的话，前i-1个物品的体积最多为j-v[i]
    在这两种情况中取较大值即可，即为当前情况的最优解，
    我们的每一步都是从上一步的最优解转移过来，
    所以可以保证最后的结果一定是最优解
    dp[0][0] = 0
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
        for(int i = 1; i <= number_of_items; i++){
            for(int j = 0; j <= pack_volum; j++){
                dp[i][j] = dp[i-1][j];
                if(j >= volum[i])
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][j-volum[i]] + vaule[i]);
            }
        }
        System.out.println(dp[number_of_items][pack_volum]);
    }
    /*
    解法二：滚动数组优化：（实际上只需要一个数组）
    状态转移每次只与上一层有关，所以用一个一维数组就可以
    转移方程：dp[i]=max(dp[i],dp[i-v[i]]+w[i])
    其实就相当于二维中的 dp[i][j]=max(dp[i][j],dp[i-1][j-v[i]]+w[i])
    所以第二层循环需要从大到小循环，因为若是继续从小到大循环，
    后面算的时候，用的是这一层已经算过的数据，
    就变成dp[i][j]=max(dp[i][j],dp[i][j-v[i]]+w[i]) ，
    （这正好是完全背包一维的解法，每个物品可以选无限次）
    而从大到小算的话一定用的是上一层的状态
    */
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
        int []dp = new int[pack_volum+1];//dp[i],体积是i的时候能够装到的最大价值
        for(int i = 1; i <= number_of_items; i++){
            for(int j = pack_volum; j >= volum[i]; j--){
                dp[j] = Math.max(dp[j], dp[j-volum[i]] + vaule[i]);
            }
        }
        System.out.println(dp[pack_volum]);
    }
}

