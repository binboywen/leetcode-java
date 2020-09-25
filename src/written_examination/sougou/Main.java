package written_examination.sougou;

import java.util.*;
public class Main {
    class Interval{
        int start;
        int end;
    }
    public Interval solve(int n, int k, String str1, String str2){
        Interval result = new Interval();
        if(n < k || str1 == null || str2 == null || str1.length() < n || str2.length() < n || str1.length() != str2.length()){
            return result;
        }
        int sameAnswer = 0;
        for(int i = 0; i < n; i++){
            if(str1.charAt(i) == str2.charAt(i)){
                sameAnswer++;
            }
        }

        if(n == k ){
            result.start = sameAnswer;
            result.end = sameAnswer;
        }else{
            if(sameAnswer >= k){
                if(n - sameAnswer >= k){
                    result.start = 0;
                    result.end = k + (n - k - (sameAnswer - k));
                }else{
                    result.start = k - (n - sameAnswer);
                    result.end = n;
                }
            }else{
                if(n - sameAnswer >= k){
                    result.start = 0;
                    result.end = k + sameAnswer;
                }else{
                    result.start = k - (n - sameAnswer);
                    result.end = n;
                }
            }
        }
        return result;
    }
}
