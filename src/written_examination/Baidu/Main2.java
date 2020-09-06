package written_examination.Baidu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main2 {
    public static void main(String [] args){
        Scanner sc = new Scanner((System.in));
        int T = sc.nextInt();
        while(T-- > 0){
            int n = sc.nextInt();
            int m = sc.nextInt();
            int m_ = m;
            int [] array = new int[n+1];
            while(m_-- > 0){
                int k = sc.nextInt();
                while(k-->0){
                    int L = sc.nextInt();
                    int R = sc.nextInt();
                    for(int i = L; i<=R;i++){
                        array[i] +=1;
                    }
                }
            }
            int count = 0;
            List<Integer> list = new ArrayList<>();
            for(int i = 0; i < array.length;i++){
                if(array[i]>=m){
                    count++;
                    list.add(i);
                }
            }
            System.out.println(count);
            for(int i : list){
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
