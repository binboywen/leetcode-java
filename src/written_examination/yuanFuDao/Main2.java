package written_examination.yuanFuDao;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main2 {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int mod = 1000000003;
        int N = sc.nextInt();
        List<Integer> [] g = new ArrayList[N];
        List<Integer> [] v = new ArrayList[N];
        for(int i = 0; i < N; i++){
            g[i] = new ArrayList<>();
            v[i] = new ArrayList<>();
        }
        for(int i = 0; i < N; i++){
            sc.nextLine();
            int a, b;
            a = sc.nextInt();
            b = sc.nextInt();
            v[i].add(a);
            if(b != 0) b = b - 2;
            g[b].add(i);
        }
        int ans = 0;
        for(int i = 0; i < g.length;i++){
            int size = g[i].size();
            int temp = 0;
            if(size == 0)
                continue;
            for(int j = 0; j < size; j++){
                int index = g[i].get(j);
                if(v[index].get(0) < 0 && g[index].size() == 0){
                    continue;
                }
                temp = temp + v[index].get(0) % mod;
            }
            ans = Math.max(ans, temp);
        }
        System.out.println(ans);
    }
}
