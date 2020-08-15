package written_examination.meituan;

import java.util.Scanner;

public class Main2 {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String [] s1 = new String[n];
        String [] s2 = new String[n];
        sc.nextLine();
        for(int i = 0; i < n; i++){
            String [] strs = sc.nextLine().split(" ");
            s1[i] = strs[0];
            s2[i] = strs[1];
        }
        int l = 0, r = 0;
        int result = 0;
        while(l < n && r < n){
            String string1 = s1[l];
            String string2 = s2[r];

            if(!string1.equals(string2)){
                r++;
            }else{
                result++;
                l = r + 1;
            }
        }
        System.out.println(result);
    }
}
