package OneQuestionPerDay;

import java.util.Arrays;

/**
 * 你有1元、4元、5元三种硬币，求一种方法，用最少的硬币凑出m元
 * https://blog.csdn.net/aimsgmiss/article/details/81868699?utm_
 */
public class 最少硬币数 {
    //测试用例
    public static void main(String[] args) {

    }
    //找出最少的钱的数目
    private static int[] coinCoin(int m) {
        int[] a = {1, 5,10,50,100};  //硬币面值
        int[] temp = new int[m + 1];  //存储所需硬币的数目
        for(int i = 0; i <= m; i++) {
            temp[i] = i;    //默认全部使用1元，则i元最多需要使用i个银币。
        }
        for(int i = 1; i <= m; i++) {
            //这个外层循坏，依次对1到m个钱数，进行凑数
            for(int j = 0; j < 3; j++) {
                //这个内层循环，每次都会固定执行3次
                if(a[j] <= i && temp[i - a[j]] + 1 < temp[i]) {
                    temp[i] = temp[i - a[j]] + 1;
                }
            }
        }
        return temp;
    }


}
