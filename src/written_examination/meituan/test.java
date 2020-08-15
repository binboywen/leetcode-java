package written_examination.meituan;

import java.util.Scanner;

public class test {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if(n < 2178){
            System.out.println(0);
        }else if(n >= 2178 && n < 21978){
            System.out.println(1);
            System.out.println("2178 8712");
        }else if(n >= 21978 && n < 219978){
            System.out.println(2);
            System.out.println("2178 8712");
            System.out.println("21978 87912");
        }else if(n >= 219978 && n < 2199978){
            System.out.println(3);
            System.out.println("2178 8712");
            System.out.println("21978 87912");
            System.out.println("219978 879912");

        }else{
            System.out.println(4);
            System.out.println("2178 8712");
            System.out.println("21978 87912");
            System.out.println("219978 879912");
            System.out.println("2199978 8799912");
        }
    }
}
