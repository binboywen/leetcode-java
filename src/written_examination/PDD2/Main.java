package written_examination.PDD2;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int [][]arr=new int[n][n];
        change(arr);
        for (int i= 0;i<arr.length;i++){
            for (int j=0;j<arr.length;j++){
                if (j==arr.length-1){
                    System.out.print(arr[i][j]+"");
                    System.out.println();
                }else
                    System.out.print(arr[i][j]+" ");
            }
        }
    }
    public static void change(int [][]arr){
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                if(i==j||i+j==arr.length-1){
                    arr[i][j]=0;
                }else if(arr.length%2!=0){
                    if (i==arr.length/2||j==arr.length/2){
                        arr[i][j]=0;
                    }else if(j>arr.length/2&&i+j<arr.length-1){
                        arr[i][j]=1;
                    }else if (j<arr.length/2&&j>i){
                        arr[i][j]=2;
                    }else if(i<arr.length/2&&j<i){
                        arr[i][j]=3;
                    }else if (i>arr.length/2&&i+j<arr.length-1){
                        arr[i][j]=4;
                    }else if (j<arr.length/2&&i+j>arr.length-1){
                        arr[i][j]=5;
                    }else if (j>arr.length/2&&j<i){
                        arr[i][j]=6;
                    }else if(i>arr.length/2&&j>i){
                        arr[i][j]=7;
                    }else
                        arr[i][j]=8;
                }else
                {
                    if(j>=arr.length/2&&i+j<arr.length-1){
                        arr[i][j]=1;
                    }else if (j<arr.length/2&&j>i){
                        arr[i][j]=2;
                    }else if(i<arr.length/2&&j<i){
                        arr[i][j]=3;
                    }else if (i>=arr.length/2&&i+j<arr.length-1){
                        arr[i][j]=4;
                    }else if (j<arr.length/2&&i+j>arr.length-1){
                        arr[i][j]=5;
                    }else if (j>=arr.length/2&&j<i){
                        arr[i][j]=6;
                    }else if(i>=arr.length/2&&j>i){
                        arr[i][j]=7;
                    }else
                        arr[i][j]=8;
                }
            }
        }
    }
}
