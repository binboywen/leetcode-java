package written_examination.Wangyi;

import java.util.Scanner;

public class Main1 {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int [] T = new int[m];
        int [] S = new int[100000];
        boolean [] flag = new boolean[100000];
        for(int i = 0; i < T.length; i++){
            T[i] = sc.nextInt();
            flag[T[i]] = true;
        }
        int k = 0;
        for(int i = 1; i <= n; ++i){
            if(!flag[i]){
                S[k++] = i;
            }
        }
        int i, j;
        for(i = 0, j = 0; i < m && j < k;){
            if(T[i] < S[j]){
                System.out.print(T[i++] + " ");
            }else{
                System.out.print(S[j++] + " ");
            }
        }
        while(i < m){
            System.out.print(T[i++] + " ");
        }
        while(j < k){
            System.out.print(S[j++] + " ");
        }
    }
}
