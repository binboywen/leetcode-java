package pack_problem;

import java.util.ArrayList;
import java.util.Scanner;

class Good{
    int volum;
    int value;
    Good(int vo, int va){
        volum = vo;
        value = va;
    }
}

public class _3_多重背包二进制优化 {
    /**
    优化思路：  二进制优化
    第i个物品最多选s个， 可以表示为 i个物品选1个、2个、4个、8个、16个直到小于s的2的幂次
    由此转换成0 1背包问题。
    S == 2000, logS = 11
     0<N≤1000
     0<V≤2000
     0<vi,wi,si≤2000
*/


    public static void main(String [] args){
        ArrayList<Good> goods = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int number_of_items = sc.nextInt();
        int pack_volum = sc.nextInt();
        int [] volum = new int[number_of_items + 1];
        int [] value = new int[number_of_items + 1];
        int [] item_num = new int[number_of_items + 1];
        for(int i = 1; i <= number_of_items; i++ ){
            volum[i] = sc.nextInt();
            value[i] = sc.nextInt();
            item_num[i] = sc.nextInt();
        }
        int []dp = new int[pack_volum+1];//dp[i],体积是i的时候能够装到的最大价值
        for(int i = 1; i <= number_of_items; i++){
            for(int k = 1; k <= item_num[i]; k*=2){
                item_num[i] -= k;
                goods.add(new Good(volum[i] * k, value[i] * k));
            }
            if(item_num[i] > 0)
                goods.add(new Good(volum[i] * item_num[i], value[i] * item_num[i]));
        }
        for(Good good : goods){
            for(int j = pack_volum; j >= good.volum; j--){
                dp[j] = Math.max(dp[j], dp[j - good.volum] + good.value);
            }
        }
        System.out.println(dp[pack_volum]);
    }
}
