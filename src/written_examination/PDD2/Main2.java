package written_examination.PDD2;

import java.util.Scanner;

public class Main2 {
    static volatile int count;
    static volatile int temp;
    static int currentI;
    static int currentJ;
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int [][] array = new int[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                array[i][j] = sc.nextInt();
            }
        }
        System.out.print(countIslands(array));
    }
    public static int countIslands(int[][] m) {
        if (m == null || m[0] == null) {
            return 0;
        }
        int N = m.length;
        int M = m[0].length;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (m[i][j] == 0) {
                    m[i][j] = 2;
                    temp = count;
                    count = 0;
                    currentI = i;
                    currentJ = j;
                    dfs(m, i, j, N, M);
                    temp = Math.max(temp,count);
                    m[i][j] = 0;
                }
            }
        }
        return temp;
    }

    public static void dfs(int[][] m, int i, int j, int N, int M) {
        if (i < 0 || i >= N || j < 0 || j >= M || (i != currentI && j != currentJ && m[i][j] == 0)) {
            return;
        }
        if(i != currentI && j != currentJ){
            count++;
        }

        dfs(m, i + 1, j, N, M);
        dfs(m, i - 1, j, N, M);
        dfs(m, i, j + 1, N, M);
        dfs(m, i, j - 1, N, M);
    }
}
