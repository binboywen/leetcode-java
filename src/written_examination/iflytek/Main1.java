package written_examination.iflytek;

import java.util.Scanner;

public class Main1 {
    static int mod = 1000000000 + 7;

    private static int Combination1(int n, int k) {
        int a=1,b=1;
        if(k>n/2) {
            k=n-k;
        }
        for(int i=1;i<=k;i++) {
            a = a * (n+1-i) % mod;
            b= b * i % mod;
        }
        return a/b;
    }
    static long pow(long m, long n){
        long ans = 1;
        while((n--)>0){
            ans = ans*m;
            ans = ans % mod;
        }
        return ans;
    }
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int result = 0;
        double temp = Math.pow(m,n);
        double temp2 = Math.pow(1-m,n+1);

        System.out.println(temp/temp2);
    }
}
