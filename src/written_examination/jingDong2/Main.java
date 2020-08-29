package written_examination.jingDong2;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static int height=0;
    public static final int[] f={5,2,3};
    public static int getHeight(int n){
        int end=0;
        int start=0;
        while(n>end){
            start=end+1;
            end=start+(int)Math.pow(3,++height)-1;
        }
        return n-start+1;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        Stack<Integer> stack=new Stack<>();
        int x=getHeight(n);
        while(height-->0){
            stack.push(x%3);
            x=(x+2)/3;
        }
        while(!stack.isEmpty()){
            System.out.print(f[stack.pop()]);
        }

    }
}

