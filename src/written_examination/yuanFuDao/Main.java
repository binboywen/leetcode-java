package written_examination.yuanFuDao;

import java.util.*;

public class Main {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [][] gap = new int[n][2];
        int[] map = new int[n*2];
        int [] hash = new int[n*2];
        for(int i = 0; i < n; i++){
            gap[i][0] = sc.nextInt();
            gap[i][1] = sc.nextInt();
            map[i*2] = gap[i][0];
            map[i*2+1] = gap[i][1];
        }
        Arrays.sort(map);
        int index = 1;
        hash[0] = map[0];
        for(int i = 1; i < n * 2; i++){
            if(map[i] != map[i-1]){
                hash[index++] = map[i];
            }
        }
        int [] height = new int[index];
        for(int i = 0; i < n; i++){
            int s = find(hash,gap[i][0],index);
            int b = find(hash,gap[i][1],index);
            for(int j = s; j < b; j++){
                height[j] += 1;
            }
        }
        Arrays.sort(height);
        System.out.println(height[index - 1]);
    }
    public static int find(int [] x, int target, int bund){
        int left = 0;
        int right = bund - 1;
        while(left <= right){
            int mid = left + (right - left) /2;
            if(x[mid] == target)
                return mid;
            if (x[mid] < target)
                left = mid + 1;
            else
                right = mid -1;
        }
        return -1;
    }
}
