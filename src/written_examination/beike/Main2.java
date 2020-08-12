package written_examination.beike;

import java.util.Scanner;

public class Main2 {
    public static int getresult(int n){
        for(int i = 2; i <= Math.pow(n,0.5);i++){
            if(n % i == 0) return i;
        }
        return n;
    }
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while(T-- > 0){
            int N = sc.nextInt();
            int M = sc.nextInt();
            if(N == 1){
                System.out.println(getresult(M));
            }else if(M == 1){
                System.out.println(getresult(N));
            }else{
                int result = Math.min(getresult(N),getresult(M));
                System.out.println(result);
            }

        }
    }
}
