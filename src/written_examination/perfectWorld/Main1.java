package written_examination.perfectWorld;

import java.util.Scanner;

public class Main1 {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int result = 1;
        for(int i = 1; i <= N; i++){
            result = (result + 1) * 2;
        }
        System.out.println(result);
    }
}
