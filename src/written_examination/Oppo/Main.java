package written_examination.Oppo;

import java.lang.reflect.Array;
import java.util.*;

public class Main {

    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int p = sc.nextInt();
        List<Integer> [] lists = new ArrayList[n];
        for(int i = 0; i < n; i++){
            lists[i] = new ArrayList<>();
        }
        for(int i = 0; i < p; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            lists[a].add(b);
        }
        int result = Integer.MAX_VALUE;
        for(int i = 0; i<lists[1].size();i++){
            int a = lists[1].get(i);
            int temp = getInfected(lists,a);
            if(temp != 0)
            {
                result = Math.min(temp,result);
            }
        }
        System.out.println(result);
    }
    public static int getInfected(List<Integer> [] lists,int index){
        if(index >= lists.length || lists[index].size() == 0){
            return 1;
        }
        int result = 1;
        for(int i : lists[index]){
            result += getInfected(lists,i);
        }
        return result;
    }
}
