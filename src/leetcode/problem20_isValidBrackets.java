package leetcode;

import java.util.*;

/**
 * 题目描述：
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 * 示例 1:
 * 输入: "()"
 * 输出: true
 * 示例 2:
 * 输入: "()[]{}"
 * 输出: true
 * 示例 3:
 * 输入: "(]"
 * 输出: false
 * 示例 4:
 * 输入: "([)]"
 * 输出: false
 * 示例 5:
 * 输入: "{[]}"
 * 输出: true
 */
public class problem20_isValidBrackets {
    private static boolean isValid(String s){
        Stack<Character> stack = new Stack<>();
        Map<Character,Character> map = new HashMap<>();
        map.put('(',')');
        map.put('[',']');
        map.put('{','}');
        for (int i = 0; i < s.length(); i++){
            Character ch = s.charAt(i);
            if(map.containsKey(ch)){
                stack.push(ch);
            }else if( map.containsValue(ch)){
                if(stack.empty()) return false;
                if(ch == map.get(stack.peek())){
                    stack.pop();
                }else return false;
            }
        }
        return stack.empty();
    }
    public static void main(String [] args){
        System.out.println(isValid(new String("()[]{}")));
    }
}
