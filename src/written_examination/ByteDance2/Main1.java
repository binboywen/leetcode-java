package written_examination.ByteDance2;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Main1 {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        if(N == 0){
            System.out.println(0);
            return;
        }
        int [] array = new int[N];

        for(int i = 0; i < N; i++){
            array[i] = sc.nextInt();
        }
        int [] right = findMaxRightWithStack(array);
        int [] left = findMaxLeftWithStack(array);
        long result = Long.MIN_VALUE;
        for(int i = 0; i < N; i++){
            long temp = right[i] * left[i];
            result = Math.max(result,temp);
        }
        System.out.print(result);


    }
    public static int[] findMaxLeftWithStack(int[] array) {
        int size = array.length;
        if(size == 0){
            return array;
        }
        int[] result = new int[size];
        Stack<Integer> stack = new Stack<>();
        stack.push(size - 1);
        int index = size - 2;
        while(index >= 0) {
            if(!stack.isEmpty() && array[index] > array[stack.peek()]) {
                result[stack.pop()] = index + 1;

            } else {
                stack.push(index);
                index--;
            }
        }
        if(!stack.isEmpty()) {
            result[stack.pop()] = 0;
        }
        return result;
    }
    public static int[] findMaxRightWithStack(int[] array) {
        int size = array.length;
        if(size == 0){
            return array;
        }
        int[] result = new int[size];
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        int index = 1;
        while(index < size) {
            if(!stack.isEmpty() && array[index] > array[stack.peek()]) {
                result[stack.pop()] = index + 1;
            } else {
                stack.push(index);
                index++;
            }
        }
        if(!stack.isEmpty()) {
            result[stack.pop()] = 0;
        }
        return result;
    }

}



