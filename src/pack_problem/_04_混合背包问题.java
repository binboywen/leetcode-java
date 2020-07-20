package pack_problem;

import java.util.ArrayList;
import java.util.Scanner;
class Thing{
    int volum;
    int value;
    int kind;
    Thing(int vo, int va){
        volum = vo;
        value = va;
    }
}
public class _04_混合背包问题 {
    /**
     有 N 种物品和一个容量是 V 的背包：
     物品一共有三类：
     第一类物品只能用1次（01背包）；
     第二类物品可以用无限次（完全背包）；
     第三类物品最多只能用 si 次（多重背包）；
     每种体积是 vi，价值是 wi。
     求解将哪些物品装入背包，可使物品体积总和不超过背包容量，且价值总和最大。
     输出最大价值。

     输入格式
     第一行两个整数，N，V，用空格隔开，分别表示物品种数和背包容积。
     接下来有 N 行，每行三个整数 vi,wi,si，用空格隔开，分别表示第 i 种物品的体积、价值和数量。
     si=−1 表示第 i 种物品只能用1次；
     si=0 表示第 i 种物品可以用无限次；
     si>0 表示第 i 种物品可以使用 si 次；

     输出格式
     输出一个整数，表示最大价值。

     数据范围
     0<N,V≤1000
     0<vi,wi≤1000
     −1≤si≤1000

     */
    public static void main(String [] args){
        ArrayList<Good> goods = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int number_of_items = sc.nextInt();
        int pack_volum = sc.nextInt();
        int [] volum = new int[number_of_items + 1];
        int [] vaule = new int[number_of_items + 1];
        int [] item_num = new int[number_of_items + 1];
        for(int i = 1; i <= number_of_items; i++ ){
            volum[i] = sc.nextInt();
            vaule[i] = sc.nextInt();
            item_num[i] = sc.nextInt();
        }
        int []dp = new int[pack_volum+1];//dp[i],体积是i的时候能够装到的最大价值

    }
}
