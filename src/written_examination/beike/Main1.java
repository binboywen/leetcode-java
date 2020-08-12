package written_examination.beike;

import java.util.Scanner;

public class Main1 {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String str = sc.nextLine();
        int count = 0;
        for(int i = 0, j = str.length() - 1; i < j;i++,j--){
            if(str.charAt(i) != str.charAt(j)){
                count++;
            }
        }
        System.out.println(count);
    }
}
