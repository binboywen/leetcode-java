package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 题目描述：
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 * 例如，给出 n = 3，生成结果为：
 * [  "((()))",
 *   "(()())",
 *   "(())()",
 *   "()(())",
 *   "()()()"]
 */
public class problem22_kuoHaoShengCheng {

    private static List<String> generateParenthesis(int n){
        List<String> combinatios = new ArrayList<>();
        generateAll(new char[2 * n], 0, combinatios);
        return combinatios;
    }

    private static void generateAll(char [] current, int pos, List<String> result){
        if (pos == current.length){
            if(valid(current))
                result.add(new String(current));
        }else{
            current[pos] = '(';
            generateAll(current, pos + 1, result);
            current[pos] = ')';
            generateAll(current, pos + 1, result);
        }
    }

    private static boolean valid(char [] current){
        int balance = 0;
        for(char c: current){
            if(c == '(') balance++;
            else balance--;
            if(balance < 0) return false;
        }
        return(balance == 0);
    }

    /**
     * 回溯法
     * @param n
     * @return
     */
    private static List<String> generateParenthesis_2(int n){
        List<String> ans = new ArrayList<>();
        backtrack(ans, "",0, 0, n);
        return ans;
    }

    private static void backtrack(List<String> ans, String cur,int open, int close, int max){
        if(cur.length() == max * 2){
            ans.add(cur);
            return;
        }
        if(open < max)
            backtrack(ans, cur+"(", open + 1, close, max);
        if(close < open)
            backtrack(ans, cur+")", open, close + 1, max);
    }

    private static List<String> generateParenthesis_3(int n){
        List<String> ans = new ArrayList<>();
        if(n == 0){
            ans.add("");
        }else{
            for(int c = 0; c < n; ++c)
                for (String left : generateParenthesis_3(c))
                    for (String right: generateParenthesis_3(n - 1 - c))
                        ans.add("(" + left + ")" + right);
        }
        return ans;
    }

    public static void main(String [] args){
        List<String> result = generateParenthesis_2(3);
        System.out.println(result);
    }
}
