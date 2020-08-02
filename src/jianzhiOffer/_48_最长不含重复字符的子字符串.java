package jianzhiOffer;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 最长不含重复字符的子字符串
 * 输入一个字符串（只包含 a~z 的字符），
 * 求其最长不含重复字符的子字符串的长度。
 * 例如对于arabcacfr，最长不含重复字符的子字符串为acfr，
 * 长度为4。
 */
public class _48_最长不含重复字符的子字符串 {
    /**
     * 暴力法直接遍历所有字符串，检查是否包含有重复的字符串
     */
    public static int longestSubStringWithoutDuplication(String s){
        int n = s.length();
        int ans = 0;
        for(int i = 0; i<n;i++){
            for(int j = i + 1; j <= n; j++){
                if(allUnique(s,i,j))
                    ans = Math.max(ans,j - i);
            }
        }
        return ans;
    }

    private static boolean allUnique(String s, int i_start, int j_end){
        Set<Character> set = new HashSet<>();
        for(int i = i_start; i < j_end; i++){
            Character ch = s.charAt(i);
            if(set.contains(ch)) return false;
            set.add(ch);
        }
        return true;
    }
    /**
     * 滑动窗口
     */
    public static int longestSubStringWithoutDuplication_2(String s){
        int length = s.length();
        int result = 0,left = 0,right = 0;
        Set<Character> set = new HashSet<>();
        while(left < length && right < length){
            if(!set.contains(s.charAt(right))){
                set.add(s.charAt(right++));
                result = Math.max(result, right - left);
            }else{
                set.remove(s.charAt(left++));
            }
        }
        return result;
    }

    /**
     * 改进的滑动窗口
     */
    public static int longestSubStringWithoutDuplication_3(String s){
        int n = s.length();
        int result = 0;
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0, j = 0;j < n; j++){
            if(map.containsKey(s.charAt(j))){
                i = Math.max(map.get(s.charAt(j)), i);
            }
            result = Math.max(result, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return result;
    }
}
