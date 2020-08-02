package written_examination.PDD;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //中午饭套餐数量N
        int N = sc.nextInt();
        //晚饭套餐数量M
        int M = sc.nextInt();
        //最小需要摄入的美味值T
        int T = sc.nextInt();
        //中午饭套餐的热量值和美味值
        List<Integer>[] lunch = new ArrayList[N];
        List<Integer>[] dinner = new ArrayList[M];
        for (int i = 0; i < N; i++) {
            lunch[i] = new ArrayList<>();
            lunch[i].add(sc.nextInt());
            lunch[i].add(sc.nextInt());
        }
        for (int i = 0; i < M; i++) {
            dinner[i] = new ArrayList<>();
            dinner[i].add(sc.nextInt());
            dinner[i].add(sc.nextInt());
        }
        if (T == 0) {
            System.out.println(0);
            return;
        }
        Arrays.sort(lunch, new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                return o2.get(1) - o1.get(1);
            }
        });
        Arrays.sort(dinner, new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                return o2.get(1) - o1.get(1);
            }
        });
        System.out.println(getDilcious(lunch, dinner, T));
    }

    public static int getDilcious(List<Integer>[] lunch, List<Integer>[] dinner, int T) {
        if (lunch[0].get(1) + dinner[0].get(1) < T) {
            return -1;
        }
        int result = Integer.MAX_VALUE;
        int lunch_index = 0;
        int dinner_index = 0;
        int lunch_length = lunch.length - 1;
        int dinner_length = dinner.length - 1;
        while (lunch_index <= lunch_length && lunch[lunch_index].get(1) >= T) {
            result = Math.min(result, lunch[lunch_index].get(0));
            lunch_index++;
        }
        while (dinner_index <= dinner_length && dinner[dinner_index].get(1) >= T) {
            result = Math.min(result, dinner[dinner_index].get(0));
            dinner_index++;
        }
//        while(dinner[dinner_index].get(1) + lunch[lunch_length].get(1) < T){
//            lunch_length--;
//        }
//        while(lunch[lunch_index].get(1) + dinner[dinner_length].get(1) < T){
//            dinner_length--;
//        }
        for (int i = dinner_index; i <= dinner_length; i++) {
            if(dinner[i].get(1) + lunch[lunch_index].get(1) < T){
                continue;
            }
            for (int j = lunch_index; j <= lunch_length; j++) {
                if(dinner[i].get(1) + lunch[j].get(1) < T){
                    break;
                }
                if (dinner[i].get(1) + lunch[j].get(1) >= T) {
                    result = Math.min(result, dinner[i].get(0) + lunch[j].get(0));
                }

            }
        }
        return result;
    }
}
