package jianzhiOffer;

import java.util.ArrayList;

/**
 * 和为s的两个数字
 * 输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得
 * 它们的和正好是s，如果有多对数字的和等于s，则输出任意一对就可
 * 如果是无序数组，则可以了利用hash表来求解
 * 但是是有序数组，则可以利用类似外排的形式，利用双指针求解
 */
public class _57_1_和为S的两个数字 {
    /**
     * 使用双指针，一个指针指向元素较小的值，
     * 一个指针指向元素较大的值。
     * 指向较小元素的指针从头向尾遍历，
     * 指向较大元素的指针从尾向头遍历。
     * 如果两个指针指向元素的和 sum == target，那么得到要求的结果；
     * 如果 sum > target，移动较大的元素，使 sum 变小一些；
     * 如果 sum < target，移动较小的元素，使 sum 变大一些。
     */
    public static ArrayList<Integer> FindNumbersWithSum(int [] array, int sum){
        int i = 0, j = array.length - 1;
        while(i < j){
            int cur = array[i] + array[j];
            if(cur < sum)
                i++;
            else if(cur > sum)
                j--;
            else{
                System.out.println(String.format("%d,%d,%d,%d", i , j, array[i],array[j]));
                break;
            }

        }
        return new ArrayList<>();
    }

}
