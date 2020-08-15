package written_examination.meituan;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main3 {
    static int [] array;
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        List<List<Integer>> list = new ArrayList<>();
        array = new int[n + 1];
        for(int i = 0; i <= n; i++){
            array[i] = i;
        }
        for(int j = 0; j <= n; j++){
            list.add(new ArrayList<>());
        }
        for(int i = 0; i < m; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            list.get(a).add(b);
        }
        for(int i = 1; i <= n; i++){
            dfs(list,i,0);
        }

        int result = 0;
        System.out.println(result);
    }
    public static void dfs(List<List<Integer>> list, int i, int count){

        if(i > array.length || list.get(i).size() == 0 || count > list.size()) return;
        array[list.get(i).get(0)] = array[i];
        dfs(list,list.get(i).get(0),count++);
    }
}
