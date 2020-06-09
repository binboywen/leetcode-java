import java.util.Map;
import java.util.Queue;
import java.util.Stack;

/**
 * 题目描述：
 * 给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
 * 示例 1:
 * 输入: "(()"
 * 输出: 2
 * 解释: 最长有效括号子串为 "()"
 * 示例 2:
 * 输入: ")()())"
 * 输出: 4
 * 解释: 最长有效括号子串为 "()()"
 */
public class problem32_longestValidParentheses {
    private static boolean isValid(String s){
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '('){
                stack.push('(');
            }else if(!stack.empty() && stack.peek() == '('){
                stack.pop();
            }else{
                return false;
            }
        }
        return stack.empty();
    }
    private static int longestValidParentheses(String s){
        int ans = 0;
        for(int i = 0; i < s.length(); i++){
            for (int j = i + 2; j <= s.length(); j+= 2){
                if(isValid(s.substring(i, j))){
                    ans = Math.max(ans, j - i);
                }
            }
        }
        return ans;
    }
    private static int longestValidParentheses_2(String s){
        int maxans = 0;
        int [] dp = new int[s.length()];
        for (int i = 1; i < s.length(); i++){
            if(s.charAt(i) == ')'){
                if(s.charAt(i-1) =='('){
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                }else if(i - dp[i - 1] > 0 && s.charAt(i - dp[i -1] - 1) == '('){
                    dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
                maxans = Math.max(maxans, dp[i]);
            }
        }
        return maxans;
    }
    private static int longestValidParentheses_3(String s){
        int maxans = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '('){
                stack.push(i);
            }else{
                stack.pop();
                if(stack.empty()){
                    stack.push(i);
                }else{
                    maxans = Math.max(maxans, i - stack.peek());
                }
            }
        }
        return maxans;
    }
    private static int longestValidParentheses_4(String s){
        int left = 0, right = 0, maxLength = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '('){
                left++;
            }
            else{
                right++;
            }
            if(left == right){
                maxLength = Math.max(maxLength, 2 * right);
            }else if(right >= left){
                left = right = 0;
            }
        }
        left = right = 0;
        for(int i = s.length() - 1; i >= 0; i--){
            if(s.charAt(i) == '('){
                left++;
            }
            else{
                right++;
            }
            if(left == right){
                maxLength = Math.max(maxLength, 2 * left);
            }else if(left >= right){
                left = right = 0;
            }
        }

        return maxLength;
    }

    public static void main(String [] args){
        int result = longestValidParentheses_3("())");
        System.out.println(result);
    }
}
