package jianzhiOffer;

/**
 * 给定一个数字，按照如下规则翻译成字符串：
 * 1 翻译成“a”，2 翻译成“b”... 26 翻译成“z”。
 * 一个数字有多种翻译可能，例如 12258 一共有 5 种，
 * 分别是 abbeh，lbeh，aveh，abyh，lyh。实现一个函数，
 * 用来计算一个数字有多少种不同的翻译方法。
 */
//先试试暴力递归然后改成动态规划
public class _46_numDecodingsToString {
    public static int numDecodings(String s) {
        if(s == null || s.length() == 0)
            return 0;

        return GetTranslationCount(s,0);
    }

    public static int GetTranslationCount(String s,int start){
        if(start == s.length() - 1)
            return 1;
        if(start > s.length() - 1)
            return 0;
        int TwoNum = Integer.parseInt(s.substring(start, start+2));
        int ifTwoNum = TwoNum >= 10 && TwoNum <= 25 ? 1 : 0;

        return GetTranslationCount(s,start+1) + ifTwoNum * GetTranslationCount(s, start + 2);
    }

    public static int GrTranslationCountDp_1(String s){
        if(s == null || s.length() == 0)
            return 0;
        int n = s.length();
        int [] dp = new int[n];
        int count = 0;
        dp[n - 1] = 1;
        dp[n - 2] = Integer.parseInt(s.substring(n-1)) >= 10 &&
                Integer.parseInt(s.substring(n-1)) <= 25 ? 2 : 1;
        for(int i = n - 3; i >= 0; --i){
            int TwoNum = Integer.parseInt(s.substring(i, i+2));
            int ifTwoNum = TwoNum >= 10 && TwoNum <= 25 ? 1 : 0;
            dp[i] = dp[i+1] + ifTwoNum * dp[i + 2];
        }
        return dp[0];
    }

    public static int GetTranslationCountDp(String s){
        if(s == null || s.length() == 0)
            return 0;
        int n = s.length();
        int [] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0'? 0 : 1;
        for(int i = 2; i <= n; i++){
            int one = Integer.valueOf(s.substring(i - 1, i));
            if(one != 0){
                dp[i] += dp[i - 1];
            }
            if(s.charAt(i - 2) == '0'){
                continue;
            }
            int two = Integer.valueOf(s.substring(i - 2, i));
            if(two < 26){
                dp[i] += dp[i - 2];
            }
        }
        return dp[n];
    }

    public static void main(String [] args){
        String s = "12258";
        int result = numDecodings(s);
        int result_2 = GrTranslationCountDp_1(s);
        System.out.println("");
    }

}
