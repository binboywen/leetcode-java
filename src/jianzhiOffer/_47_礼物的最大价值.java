package jianzhiOffer;

/**
 * 礼物的最大价值
 * 在一个m×n的棋盘的每一格都放有一个礼物，每个礼物都有一个
 * 定的价值(价值大于0).你可以从棋盘的左上角开始拿格子里的礼物
 * 每次向右或向下移动一格，直到到达棋盘的右下角。给定一个棋盘
 * 及其上面的礼物，请计算你最多能拿到多少价值的礼物？
 */
public class _47_礼物的最大价值 {
    //暴力递归 直接超时了
    public static int getMaxValue(int [][] matrix,int i, int j){
        if(i == matrix.length - 1 && j == matrix[0].length - 1)
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
        if( m.length == 0 || m[0].length == 0)
            return 0;
        int row = m.length;
        int col = m[0].length;
        int [][] dp = new int[row][col];
        dp[0][0] = m[0][0];
        for(int i = 1; i < row ; i++){
            dp[i][0] = dp[i-1][0] + m[i][0];
        }
        for(int j = 1; j < col ; j++){
            dp[0][j] = dp[0][j-1] + m[0][j];
        }
        for(int i = 1; i < row; i++){
            for(int j = 1; j < col; j++){
                dp[i][j] = m[i][j] + Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        return dp[row - 1][col - 1];

    }
}
