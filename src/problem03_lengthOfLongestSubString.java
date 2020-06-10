import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 题目描述:
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * 示例1：
 * 	输入: "abcabcbb"
 * 	输出: 3
 * 	解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例2：
 * 	输入: "bbbbb"
 * 	输出: 1
 * 	解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例3：
 * 	输入: "pwwkew"
 * 	输出: 3
 * 	解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *
 */
public class problem3_lengthOfLongestSubString {
    /**
     *  暴力法直接遍历所有字串，检查是否包含有重复字串
     * @param s 输入字符串
     * @return 返回最长无重复子串长度
     */
    private static int lengthOfLongestSubString_1(String s){
        int n = s.length();
        int ans = 0;
        for (int i = 0; i < n; i++){
            for (int j = i + 1; j <= n; j++){
                if(allUnique(s,i,j))
                    ans = Math.max(ans, j - i);
            }
        }
        return ans;
    }
    private  static boolean allUnique(String s, int start, int end){
        Set<Character> set = new HashSet<>();
        for (int i = start; i < end; i++){
            Character ch = s.charAt(i);
            if(set.contains(ch)) return false;
            set.add(ch);
        }
        return true;
    }

    /**
     * 滑动窗口法
     * @param s 输入字符串
     * @return 返回最长无重复子串长度
     */
    private static int lengthOfLongestSubString_2(String s){
        int n = s.length();
        int ans = 0, i = 0, j = 0;
        Set<Character> set = new HashSet<>();
        while(i < n && j < n){
            if(!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            }else{
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }

    /**
     * 优化滑动窗口法
     * @param s 输入字符串
     * @return 返回最长无重复子串长度
     */
    private static int lengthOfLongestSubString_3(String s){
        int n = s.length();
        int ans = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0, j = 0; j < n; j++){
            if(map.containsKey(s.charAt(j))){
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }
    public static void main(String [] args){
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubString_3(s));
    }

}
