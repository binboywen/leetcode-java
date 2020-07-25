package OnLineJudge;



import java.util.Scanner;

public class Main1 {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();
        int [] S = new int[N];
        for(int i = 0; i < N; i++){
            S[i] = sc.nextInt();
        }
        long result = 0;
        int length = N;

        while(S[0] > 0){
            int minIndex = 0;
            for(int i = 0; i < length; i++){
                minIndex = S[i] < S[minIndex] ? i : minIndex;
            }
            result+= (long)(S[minIndex]) * (long)length;
            for(int j = 0; j < length; j++){
                S[j] -= S[minIndex];
            }
            length = minIndex;
        }
        System.out.println(result);
    }
}
