package written_examination.Wangyi;

import java.util.Scanner;

public class Main {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long result = 0L;
        for(int i = 0; i < n; i++){
            result += sc.nextInt() / 2;
        }
        System.out.println(result);
    }
}
