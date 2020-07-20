package leetcode;

/**
 * 题目描述：
 * 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
 * '.' 匹配任意单个字符
 * '*' 匹配零个或多个前面的那一个元素
 * 所谓匹配，是要涵盖整个字符串s的，而不是部分字符串。
 * 说明:
 * s 可能为空，且只包含从 a-z 的小写字母。
 * p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。
 * 示例 1:
 * 输入:
 * s = "aa"
 * p = "a"
 * 输出: false
 * 解释: "a" 无法匹配 "aa" 整个字符串。
 * 示例 2:
 * 输入:
 * s = "aa"
 * p = "a*"
 * 输出: true
 * 解释: 因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。
 * 因此，字符串 "aa" 可被视为 'a' 重复了一次。
 * 示例 3:
 * 输入:
 * s = "ab"
 * p = ".*"
 * 输出: true
 * 解释: ".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
 * 示例 4:
 * 输入:
 * s = "aab"
 * p = "c*a*b"
 * 输出: true
 * 解释: 因为 '*' 表示零个或多个，这里 'c' 为 0 个, 'a' 被重复一次。因此可以匹配字符串 "aab"。
 * 示例 5:
 * 输入:
 * s = "mississippi"
 * p = "mis*is*p*."
 * 输出: false
 *
 */
public class problem10_isMatchRegularExpression {
    private static int ls, lp;

    /**
     * 回溯法
     * @param s
     * @param p
     * @return
     */
    public static boolean isMatch_1(String s, String p){
        ls = s.length();
        lp = p.length();
        return match(s, p, 0, 0);
    }

    /**
     * 递归实现回溯
     * @param s
     * @param p
     * @param i
     * @param j
     * @return
     */
    private static boolean match(String s, String p, int i, int j){
        if(j == lp) return i == ls;
        if(j < lp - 1 && p.charAt(j + 1) == '*'){
            if (i < ls && (p.charAt(j) == '.' || s.charAt(i) == p.charAt(j)))
                return match(s, p, i + 1, j) || match(s, p, i, j + 2);
            return match(s, p, i, j + 2);
        }
        if(i < ls && (p.charAt(j) == '.' || s.charAt(i) == p.charAt(j)))
            return match(s, p, i + 1, j + 1);
        return false;
    }

    /**
     * 动态规划
     * @param s
     * @param p
     * @return
     */
    private static boolean isMatch_2(String s, String p){
        int length_s = s.length(), length_p = p.length();
        // dp[i][j]代表字符串s中前i个字符和p中前j个字符是否匹配
        // s的第i个字符记为s[m]==s[i-1]；p的第j个字符记为p[n]==p[j-1]
        boolean [][] dp = new boolean[length_s + 1][length_p + 1];
        dp[0][0] = true;
        for(int j = 2; j <= length_p; j++){
            //初始化第一行，p第j个字符记为'*'且dp[0][j-2]为true
            dp[0][j] = dp[0][j - 2] && p.charAt(j - 1) == '*';
        }
        for(int i = 1; i <= length_s; i++){
            for(int j = 1; j <= length_p; j++){
                int m = i - 1;
                int n = j - 1;
                if(p.charAt(n) == '*')
                    dp[i][j] = dp[i][j-2] || dp[i-1][j] && (s.charAt(m)==p.charAt(n-1)||p.charAt(n-1)=='.');
                else if(s.charAt(m) == p.charAt(n) || p.charAt(n) == '.')
                    dp[i][j] = dp[i-1][j-1];
            }
        }
        return dp[length_s][length_p];
    }

    public static void main(String [] args){

    }

}
