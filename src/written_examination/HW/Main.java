package written_examination.HW;

import java.util.*;
import java.util.Scanner;

public class Main {
    static int index = 1;
    static List<List<Integer>> lists = new ArrayList<>();
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();
        sprialOrder(M,N);
    }
    public static void sprialOrder(int M, int N){
        if(M < 10 || M > 1000 || N < 10 || N > 1000){
            System.out.println("[]");
            return;
        }
        int tR = 0;
        int tC = 0;
        int dR = M -1;
        int dC = N -1;
        while(tR <= dR && tC <= dC){
            printEdge(tR++,tC++,dR--,dC--);
        }
        System.out.print("[");
        for(int i = 0; i < lists.size(); i++){
            if(i != lists.size() -1){
                System.out.print("["+lists.get(i).get(0)+","+lists.get(i).get(1)+"],");
            }else{
                System.out.print("["+lists.get(i).get(0)+","+lists.get(i).get(1)+"]");
            }
        }
        System.out.print("]");

    }
    public static void printEdge(int tR, int tC, int dR, int dC){
        if(tR == dR){
            for(int i = tC; i <= dC; i++){
                if(ifSP(index)){
                    List<Integer> list = new ArrayList<>();
                    list.add(tR);
                    list.add(i);
                    lists.add(list);
                }
                index++;
            }
        }else if(tC == dC){
            for(int i = tR; i <= dR; i++){
                if(ifSP(index)){
                    List<Integer> list = new ArrayList<>();
                    list.add(i);
                    list.add(tC);
                    lists.add(list);
                }
                index++;
            }
        }else{
            int curC = tC;
            int curR = tR;
            while(curC != dC){
                if(ifSP(index)){
                    List<Integer> list = new ArrayList<>();
                    list.add(tR);
                    list.add(curC);
                    lists.add(list);
                }
                index++;
                curC++;
            }
            while(curR != dR){
                if(ifSP(index)){
                    List<Integer> list = new ArrayList<>();
                    list.add(curR);
                    list.add(dC);
                    lists.add(list);
                }
                index++;
                curR++;
            }
            while(curC != tC){
                if(ifSP(index)){
                    List<Integer> list = new ArrayList<>();
                    list.add(dR);
                    list.add(curC);
                    lists.add(list);
                }
                index++;
                curC--;
            }
            while(curR != tR){
                if(ifSP(index)){
                    List<Integer> list = new ArrayList<>();
                    list.add(curR);
                    list.add(tC);
                    lists.add(list);
                }
                index++;
                curR--;
            }
        }
    }

    public static boolean ifSP(int num){
        if(num % 10 == 7 && ((num / 10) % 10) % 2 != 0){
            return true;
        }
        return false;
    }

}
