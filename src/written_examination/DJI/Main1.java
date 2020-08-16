package written_examination.DJI;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main1 {
    static int result_num = Integer.MAX_VALUE;
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int P = sc.nextInt();
        List<List<List<Integer>>> lists = new ArrayList<>();
        for(int i = 0; i < N; i++){
            lists.add(new ArrayList<>());
            List<List<Integer>> list = lists.get(i);
            for(int j = 0; j < N; j++){
                list.add(new ArrayList<>());
            }
        }
        for(int i = 0; i < P; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            lists.get(a).get(b).add(c);
        }
        int k_ = sc.nextInt();
        getMinPath(lists,0,k_,0);
        System.out.println(result_num);

    }
    public static void getMinPath(List<List<List<Integer>>> lists, int start, int end, int value){

        if(start == end){
            result_num = Math.min(value, result_num);
            return;
        }
        for(int i = 0; i < lists.get(start).size(); i++){
            if(lists.get(start).get(i).size() == 0){
                continue;
            }
            value += lists.get(start).get(i).get(0);
            getMinPath(lists,i,end,value);
        }
    }
}
