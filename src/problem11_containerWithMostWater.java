public class problem11_containerWithMostWater {
    /**
     * 暴力法求解，时间复杂度为n的平方
     * @param height
     * @return
     */
    private static int maxArea_1(int[] height) {
        int n = height.length;
        int ans = 0;
        for(int i = 0; i < n - 1; i++){
            for (int j = i + 1; j < n; j++){
                int temp = (j - i) * Math.min(height[i], height[j]);
                ans = Math.max(temp, ans);
            }
        }
        return ans;
    }

    /**
     * 利用双指针法求解
     * @param height
     * @return
     */
    private static int maxArea_2(int [] height){
        int ans = 0;
        int i = 0, j = height.length - 1;
        while(i < j){
            int temp = (j - i) * Math.min(height[i], height[j]);
            ans = Math.max(temp, ans);
            if(height[i] < height[j]){
                i++;
            }else{
                j--;
            }
        }
        return ans;
    }
    public static void main(String [] args){
        int [] input = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxArea_2(input));
    }
}
