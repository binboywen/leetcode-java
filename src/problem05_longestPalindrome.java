import java.util.Map;

/**
 * 题目描述：
 * 给定一个字符串S，找到S中最长的回文字串。你可以假设S的最大长度为1000.
 * 示例1：
 * 	输入："babad"
 * 	输出："bab"
 * 	注意："aba"也是一个有效答案
 * 示例2：
 * 	输入："cbbd"
 * 输出："bb"
 *
 */
public class problem5_longestPalindrome {
    private static String longestPalindrome(String s){
        if(s == null || s.length() < 1) return "";
        int start = 0, end = 0;
        for(int i = 0; i < s.length(); i++){
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s,i ,i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start){
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start , end + 1);
    }

    private static int expandAroundCenter(String s, int left, int right){
        int L = left, R = right;
        while(L > 0 && R < s.length() && s.charAt(L) == s.charAt(R)){
            L--;
            R++;
        }
        return R - L - 1;//先执行了L--和R++，所以应该减1
    }

    public static void main(String [] args){
        String s = "babad";
        System.out.println(s.substring(1,3));
        System.out.println(longestPalindrome(s));
    }
}
