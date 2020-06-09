package jianzhiOffer;

/**
 * 礼物的最大价值
 * 在一个m×n的棋盘的每一格都放有一个礼物，每个礼物都有一个
 * 定的价值(价值大于0).你可以从棋盘的左上角开始拿格子里的礼物
 * 每次向右或向下移动一格，直到到达棋盘的右下角。给定一个棋盘
 * 及其上面的礼物，请计算你最多能拿到多少价值的礼物？
 */
public class _47_getMaxValue {
    //暴力递归改动态规划
    public static int getMaxValue(int [][] matrix,int i, int j){
        if(i == matrix.length && j == matrix[0].length)
            return matrix[i][j];
        if(i == matrix.length - 1)
            return matrix[i][j] + getMaxValue(matrix,i,j+1);
        if(j == matrix[0].length - 1)
            return matrix[i][j] + getMaxValue(matrix,i+1,j);
        int right = getMaxValue(matrix,i,j+1);
        int down = getMaxValue(matrix,i+1,j);

        return matrix[i][j] + Math.max(right,down);
    }

    public static int getMaxValue_2(int [][] m){
        if( m == null || m.length == 0 || m[0] == null || m[0].length == 0)
            return 0;
        int row = m.length;
        int col = m[0].length;
        int [][] dp = new int[row][col];
        for(int i = row - 2; i >= 0; i--){
            dp[i][col - 1] = dp[i+1][col - 1] + m[i][col -1];
        }
        for(int j = col - 2; j >= 0; j--){
            dp[row - 1][j] = dp[row - 1][j+1] + m[row -1][j];
        }
        for(int i = row - 2; i >= 0;i--){
            for(int j = col - 2; j >= 0; j--){
                dp[i][j] = m[i][j] + Math.max(dp[i + 1][j],dp[i][j+1]);
            }
        }
        return dp[0][0];

    }
}
