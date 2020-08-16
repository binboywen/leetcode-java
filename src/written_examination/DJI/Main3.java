package written_examination.DJI;

import java.util.LinkedList;
import java.util.Scanner;

public class Main3 {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int k = sc.nextInt();
        String result = getMinNum(str,k);
        System.out.println(result);
    }
    public static String getMinNum(String oristr, int k){
        LinkedList<Character> stack = new LinkedList<>();
        for(char digit : oristr.toCharArray()){
            while(stack.size()>0 && k > 0 &&stack.peekLast() > digit){
                stack.removeLast();
                k = k - 1;
            }
            stack.addLast(digit);
        }
        for(int i = 0; i < k; i++){
            stack.removeLast();
        }
        StringBuffer ret = new StringBuffer();
        boolean prefixZero = true;
        for(char digit : stack){
            if(prefixZero && digit == '0'){
                continue;
            }
            prefixZero = false;
            ret.append(digit);
        }
        if(ret.length() == 0){
            return "0";
        }
        return ret.toString();
    }
}
