package Kedaxunfei;

import java.util.Scanner;

public class Main3 {
    public static boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        return (Math.min(rec1[2], rec2[2]) > Math.max(rec1[0], rec2[0]) &&
                Math.min(rec1[3], rec2[3]) > Math.max(rec1[1], rec2[1]));
    }
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int [] rect1 = new int[4];
        int [] rect2 = new int[4];
        for(int i = 0; i < 4; i++){
            rect1[i] = sc.nextInt();
        }
        for(int i = 0; i < 4; i++){
            rect2[i] = sc.nextInt();
        }
        int result = isRectangleOverlap(rect1,rect2) ? 1 : 0;
        System.out.println(result);
    }
}
