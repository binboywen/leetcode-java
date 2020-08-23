package written_examination.beike;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main4 {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while(T-- > 0){
            sc.nextLine();
            String string = sc.nextLine();
            String [] arrString = string.split(" ");
            System.out.println(getResult(arrString) ? "YES" : "NO");
        }
    }
    public static boolean getResult(String [] arrString){
        Set<Integer> bin = new HashSet<>();
        Set<Integer> tiao = new HashSet<>();
        Set<Integer> wan = new HashSet<>();
        for(String str : arrString){
            int number = str.charAt(0) - '0';
            if(str.charAt(1) == 'B'){
                if(bin.contains(number) || bin.contains(number + 1) || bin.contains(number + 2) ||
                        bin.contains(number - 1) || bin.contains(number - 2))
                    return false;
                bin.add(number);
            }
            if(str.charAt(1) == 'W'){
                if(tiao.contains(number)|| tiao.contains(number + 1) || tiao.contains(number + 2) ||
                        tiao.contains(number - 1) || tiao.contains(number - 2)) return false;
                tiao.add(number);
            }
            if(str.charAt(1) == 'T'){
                if(wan.contains(number)|| wan.contains(number + 1) || wan.contains(number + 2) ||
                        wan.contains(number - 1) || wan.contains(number - 2)) return false;
                wan.add(number);
            }
        }
        if(bin.size() > 3 || wan.size() > 3 || tiao.size() > 3) return false;

        return true;
    }
}
