package written_examination.DiDi;

import java.util.Scanner;

public class Main1 {
    static int index;
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long [] array = new long[n * n];
        index = array.length - 1;
        fb(array,n*n);
        long [][] matrix = new long[n][n];
        sprialOrder(matrix,array);
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(j == n -1){
                    System.out.println(matrix[i][j]);
                }else{
                    System.out.print(matrix[i][j] + " ");
                }
            }
        }
    }

    public static void fb(long [] array, int n){
        if(n == 1){
            array[0] = 1;
            return ;
        }
        else if(n == 2){
            array[0] = 1;
            array[1] = 1;
            return ;
        }
        else if(n >= 3){
            array[0] = 1;
            array[1] = 1;
            for(int i = 2; i < n;i++){
                array[i] = array[i-1] + array[i-2];
            }
            return;
        }
    }
    public static void sprialOrder(long [][] matrix, long [] array){
        int tR = 0;
        int tC = 0;
        int dR =  matrix.length - 1;
        int dC = matrix[0].length - 1;
        while(tR <= dR && tC <= dC){
            printEdge(matrix,array,tR++,tC++,dR--,dC--);
        }
    }
    public static void printEdge(long [][] m,long [] array, int tR, int tC, int dR, int dC){
        if(tR == dR){
            for(int i = tC ; i <= dC; i++){
                m[tR][i] = array[index];
                index--;
            }
        }else if(tC == dC){
            for(int i = tR; i <= dR; i++){
                m[i][tC] = array[index];
                index--;
            }
        }else{
            int curC = tC;
            int curR = tR;
            while(curC != dC){
                m[tR][curC] = array[index];
                curC++;
                index--;
            }
            while(curR != dR){
                m[curR][dC] = array[index];
                index--;
                curR++;
            }
            while(curC != tC){
                m[dR][curC] = array[index];
                index--;
                curC--;
            }
            while(curR != tR){
                m[curR][tC] = array[index];
                index--;
                curR--;
            }
        }
    }
}
