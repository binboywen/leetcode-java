package written_examination.HW;

import java.util.HashMap;
import java.util.Scanner;

public class Main3 {
    static long mod = 1000000000L + 7L;
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        HashMap<Integer,Integer> hashmap = new HashMap<>();
        int maxDepth = 0;
        for(int i = 0; i < N; i++){
            int temp = sc.nextInt();
            hashmap.put(temp,hashmap.getOrDefault(temp,0) +1);
            maxDepth = Math.max(temp,maxDepth);
        }
        long result = 1L;
        for(int i = 1; i <= maxDepth; i++){
            int currentCount = hashmap.get(i);
            int lastCount = hashmap.get(i - 1);
            if(lastCount == Math.pow(2, i - 1)){
                result *= combination((int)Math.pow(2,i),currentCount) % mod;
            }
            else{
                result *= combination(2*lastCount,currentCount) % mod;
            }
        }
        System.out.println(result);
    }
    public static int combination(int n, int k){
        int a = 1;
        int b = 1;
        if(k > n / 2){
            k = n - k;
        }
        for(int i = 1; i <= k; i++){
            a *= (n + 1 - i) % mod;
            b *= i % mod;
        }
        return a/b;
    }
}
