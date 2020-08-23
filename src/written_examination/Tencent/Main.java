package written_examination.Tencent;

import java.util.Scanner;

public class Main {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while(T-- > 0){
            long n = sc.nextLong();
            System.out.println(unknownMethod(n));
            System.out.println(rightMethod(n));
        }
//        int T = 100;
//        while(T-- > 0){
//            long temp = (long) (Math.random() * 1000000);
//            long right = rightMethod(temp);
//            long unknown = unknownMethod(temp);
//            if(right != unknown){
//                System.out.println(temp);
//                System.out.println("right" + right);
//                System.out.println("unknown" + unknown);
//            }
//            System.out.println("nice");
//        }
    }
    public static long unknownMethod(long n){
        String str = String.valueOf(n);
        long convert = (long)(str.charAt(0) - '0') * (long)Math.pow(10,str.length() - 1);
        return  getDigitSum(convert - 1) + getDigitSum(n - convert + 1);
    }

    public static long rightMethod(long n){
        long maxSum = Integer.MIN_VALUE;
        for(long i = 0; i <= n; i++){
            long temp = getDigitSum(i) + getDigitSum(n - i);
            maxSum = Math.max(temp,maxSum);
        }
        return maxSum;
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
