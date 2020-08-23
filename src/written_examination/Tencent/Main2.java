package written_examination.Tencent;

import java.util.Scanner;

public class Main2 {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while(T-- > 0){
            long n = sc.nextLong();
            System.out.println(unknownMethod(n));
        }
    }
    public static long unknownMethod(long n){
        String str = String.valueOf(n);
        long convert = (long)(str.charAt(0) - '0') * (long)Math.pow(10,str.length() - 1);
        return  getDigitSum(convert - 1) + getDigitSum(n - convert + 1);
    }

    public static long getDigitSum(long num){
        String str = String.valueOf(num);
        long result = 0;
        for(int i = 0; i < str.length(); i++){
            result += (str.charAt(i) - '0');
        }
        return result;
    }
}
