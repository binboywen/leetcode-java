package pack_problem;

import java.util.Scanner;

public class _0_EggDrop {
    /**
     * 扔鸡蛋
     * @param K
     * @param N
     * @return
     */

    public static int  superEggDrop2(int K, int N) {

        if (N == 1)
            return 1;
        //我们令dp[k][m]表示k个鸡蛋在m步内可以测出的最多的层数
        int[][] dp = new int[K + 1][N + 1];
        for (int i = 1; i <= K; ++i) {
            dp[i][1] = 1;//只有一层楼
        }
        int ans = -1;
        for (int i = 2; i <= N; ++i) {//从第二层楼开始扔
            for (int j = 1; j <= K; ++j) {
                //鸡蛋碎 鸡蛋不碎
                dp[i][j] = 1 + dp[i - 1][j - 1] + dp[i - 1][j];
            }
            if (dp[i][K] >= N) {
                ans = i;
                break;
            }
        }
        return ans;
    }
    //其实我们可以换一个思路来想：有k个鸡蛋，可以进行m次操作，那么我们能找到的答案的最高
    //的N是多少？f(K,m)为在上述条件下的N，如果求出了所有的f(K,m)，那么只需要找出最小的满足
    //f(K,m)≥N的m
    public static int superEggDrop(int K, int N) {
        //K为鸡蛋个数，当K为1的时候，需要扔N次才知道在哪层楼扔恰好不会碎
        //N为楼层高，当N为1的时候，仍一次就知道碎不碎了

        //我们令dp[k][m]表示k个鸡蛋在m步内可以测出的最多的层数
        //那么当我们在第X层扔鸡蛋的时候，就有两种情况：
        //鸡蛋碎了:
        //  我们少了一颗鸡蛋，也用掉了一步，
        //  此时测出N - X + dp[k-1][m-1]层，
        //  X和它上面的N-X层已经通过这次扔鸡蛋确定大于F；
        //鸡蛋没碎:
        //  鸡蛋的数量没有变，但是用掉了一步，
        //  剩余X + dp[k][m-1]，X层及其以下已经通过这次扔鸡蛋确定不会大于F；
        //边界条件：
        //  当m≥1的时候，f(1,m)=m,当K≥1时，f(k，1)= 1
        //m 最大可以达到多少？由于我们在进行动态规划时，m在题目中并没有给出，
        // 那么我们需要进行到动态规划的哪一步呢？
        // 可以发现，操作次数是一定不会超过楼层数的，
        // 因此 m≤N，我们只要算出在f(K,N)内的所有f值即可。
        int[][] dp = new int[K + 1][N + 1];
        for (int m = 1; m <= N; m++) {
            dp[0][m] = 0; // zero egg
            for (int k = 1; k <= K; k++) {
                //“本次扔之后可能测出来的层数 + 本次扔之前已经测出来的层数”
                //无论你上楼还是下楼，总的楼层数 = 楼上的楼层数 + 楼下的楼层数 + 1（当前这层楼）。
                dp[k][m] = dp[k][m - 1] + dp[k - 1][m - 1] + 1;
                if (dp[k][m] >= N) {
                    return m;
                }
            }
        }
        return N;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int k,n;
        k=sc.nextInt();
        n=sc.nextInt();
        System.out.println(superEggDrop(k,n));
    }
}