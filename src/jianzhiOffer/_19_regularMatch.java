package jianzhiOffer;

/**
 * 请实现一个函数用来匹配包括 '.' 和 '*' 的正则表达式。模式中的字符
 * '.' 表示任意一个字符，而 '*' 表示它前面的字符可以出现任意次（包含 0 次）。
 * 在本题中，匹配是指字符串的所有字符匹配整个模式。例如，字符串 "aaa" 与
 * 模式 "a.a" 和 "ab*ac*a" 匹配，但是与 "aa.a" 和 "ab*a" 均不匹配
 * 应该注意到，'.' 是用来当做一个任意字符，而 '*' 是用来重复前面的字符。
 * 这两个的作用不同，不能把 '.' 的作用和 '*' 进行类比，
 * 从而把它当成重复前面字符一次。
 */
public class _19_regularMatch {
    /**
     * 解决思路：使用递归回溯
     * 声明一个匹配方法match(i,j),代表子字符串s的第i至末尾字符与p的j至末尾字符是否匹配。
     * 整体思路，根据两字符串当前指针对应值，进入不同的递归分支，最终通过回溯返回结果。
     * 递归流程：
     * 返回值：
     * true：成功匹配；false：无法匹配
     * 终止条件：
     * j==lp
     * j==lp代表匹配字符串p已经走完，无法继续匹配，此时，当i==ls时，代表两字符串完全匹配
     * 返回true，当i!=ls时，代表未匹配完，返回false
     * 递归分支：
     * 当p[j+1]为'*'时:
     *      当p[j]为'.'或p[j]==s[j]时：返回match(i+1,j)或match(i,j+2);代表若子串
     *      s[i+1:]和p[j:]可以匹配，或字符串s[i:]和p[j+2:]可以成功匹配，则s[i:]和p[j:]
     *      可以成功匹配。
     *      否则返回match(i,j+2)，代表若子字符串s[i:]和p[j+2:]可以成功匹配，则s[i:]和p[j:]
     *      可以成功匹配。
     * 否则，当p[j]为'.'或s[j]==p[j]时，返回match(i+1,j+1);
     * 代表若子字符串s[i+1]:和p[j+1]可以成功匹配，则s[i:]和p[j:]可以成功匹配
     */
    int ls, lp;

    public boolean isMatch(String s, String p) {
        ls = s.length();
        lp = p.length();
        return match(s, p, 0, 0);
    }

    private boolean match(String s, String p, int i, int j) {
        if (j == lp) return i == ls;
        if (j < lp - 1 && p.charAt(j + 1) == '*') {
            if (i < ls - 1 && (p.charAt(j) == '.' || s.charAt(i) == p.charAt(j))) {
                // 可以包含多次，那么每匹配一次s往后移动一次，而p不用移动
                // j+2表示匹配零次，则p直接往后移动2
                return match(s, p, i + 1, j) || match(s, p, i, j + 2);
            }
            // 如果p[j]不为'.'且s.charAt(i) != p.charAt(j)那么就默认匹配零次
            // p的位置往后移动2
            return match(s, p, i, j + 2);
        }
        // 如果p.charAt(j + 1) != '*',且p.charAt(j) == '.' || s.charAt(i) == p.charAt(j)
        // 那么s和p的位置同时往后移动1
        if (i < ls && (p.charAt(j) == '.' || s.charAt(i) == p.charAt(j)))
            return match(s, p, i + 1, j + 1);
        return false;

    }
    /**
     * 动态规划：
     * 设动态规划网格dp，dp[i][j]代表字符串s中前i个字符和p中前j个字符是否匹配，
     * 值为true或false。
     * 记s第i个字符记为s[m]==s[i-1];p第j个字符记为p[n]==p[j-1]
     * 记s和p长度分别为ls，lp
     * #初始状态：
     *  初始化第一行：dp[0][j]=dp[0][j-2] and p[j-1]=='*';tips:p第j个字符为'*'
     *      且dp[0][j-2]为true
     * #转移方程：
     *  1.当第p[n]为'*'时:
     *      1. 当p[n-1]为'.'或s[m]==p[n-1]时:dp[i][j] = dp[i-1][j];tips：此两种情况
     *      代表s[m]和p[n-1]可以匹配，等价于无s[m]的状态dp[i-1][j]
     *      2. 否则：dp[i][j]=dp[i][j-2];tips：代表s[m]和p[n-1]无法匹配，p[n-1]p[n]
     *      的组合必须出现0次，等价于没有p[n-1]p[n]时的状态dp[i][j-2]
     *  2.否则，当p[n]为'.'或s[m]==p[n]时：dp[i][j]=dp[i-1][j-1];tips：代表s[m]和p[n]
     *  直接匹配，当前状态等价于未匹配次两字符前的状态dp[i-1][j-1]
     *
     * #返回值：
     *  字符串s中前ls个字符和p中前lp个字符是否匹配，即：dp[ls][lp]
     */
    public boolean isMatch_2(String s, String p){
        int ls = s.length();
        int lp = p.length();
        boolean [][] dp = new boolean[ls + 1][lp + 1];
        dp[0][0] = true;
        for(int j = 2; j <= lp; j++){
            dp[0][j] = dp[0][j-2]&&p.charAt(j-1)=='*';
        }
        for(int i = 1; i <= ls; i++){
            for(int j = 1; j <= lp; j++){
                int m = i -1, n = j - 1;
                if(p.charAt(n) == '*'){
                    dp[i][j] = dp[i][j-2] || dp[i-1][j] &&
                            (s.charAt(m) == p.charAt(n-1) || p.charAt(n - 1) == '.');
                }
                else if(s.charAt(m) == p.charAt(n) || p.charAt(n) == '.')
                    dp[i][j] = dp[i-1][j-1];
            }
        }
        return dp[ls][lp];
    }

}
