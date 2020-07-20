package jianzhiOffer;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 转圈打印数组，顺时针打印数组
 */
public class _29_PrintMatrixSpiralOrder {
    public static void spiralOrderPring(int [][] matrix){
        int tR = 0;
        int tC = 0;
        int dR = matrix.length - 1;
        int dC = matrix[0].length - 1;
        while(tR <= dR && tC <= dC){
            printEdge(matrix, tR++, tC++, dR--, dC--);
        }
        Stack<Integer> stack = new Stack<>();
        Queue<Integer> queue = new LinkedList<>();
        int length = queue.size();
    }

    public static void printEdge(int [][] m, int tR, int tC, int dR, int dC){
        if(tR == dR){
            //制定只有一行数组打印
            for(int i = tC;i<=dC;i++){
                System.out.println(m[tR][i]);
            }
        }else if(tC == dC){
            //定制只有一列数组打印
            for(int i = tR; i <= dR; i++){
                System.out.println(m[i][tC]);
            }
        }else{
            int curC = tC;
            int curR = tR;
            while(curC != dC){
                System.out.println(m[tR][curC]);
                curC++;
            }
            while(curR != dR){
                System.out.println(m[curR][dC]);
                curR++;
            }
            while(curC != tC){
                System.out.println(m[dR][curC]);
                curC--;
            }
            while(curR != tR){
                System.out.println(m[curR][tC]);
                curR--;
            }

        }

    }
}
