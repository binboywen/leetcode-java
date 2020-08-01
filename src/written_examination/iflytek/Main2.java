package written_examination.iflytek;

import java.util.Scanner;
public class Main2{

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length=scanner.nextInt();
        int []array=new int[length];
        for(int i=0;i<length;i++){
            array[i]=scanner.nextInt();
        }
        Quicksort(array,0,length-1);
    }

    public static int partition(int[] array,int left,int right) {
        int key = array[left];//初始坑
        int i=left+1;
        int j=right;
        while(true){
            while(i<=j&&array[i]<=key) i++;
            while(i<=j&&array[j]>=key) j--;
            if(i>=j){
                break;
            }
            int temp =array[i];
            array[i]=array[j];
            array[j]=temp;
        }
        array[left]=array[j];
        array[j]=key;
        return j;
    }

    public static void Quicksort(int array[], int left, int right) {
        if(left < right){
            int pos = partition(array, left, right);
            for(int i:array){
                System.out.print(i+" ");
            }
            System.out.println("");
            Quicksort(array, left, pos - 1);
            Quicksort(array, pos + 1, right);
        }
    }
}

