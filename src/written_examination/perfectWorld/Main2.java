package written_examination.perfectWorld;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double x = sc.nextDouble();
        double y = sc.nextDouble();
        double r = sc.nextDouble();
        int result = 1;
        if (60.0 - y <= r) {
            result++;
        }
        if (y - 30.0 <= r) {
            result++;
        }
        if (60.0 - x <= r) {
            result++;
        }
        if (x - 30.0 <= r) {
            result++;
        }
        if (getDistance(x, y, 30.0, 30.0) <= r) {
            result++;
        }
        if(getDistance(x,y,60.0,60.0) <= r){
            result++;
        }
        if(getDistance(x,y,30.0,60.0) <= r){
            result++;
        }
        if(getDistance(x,y,60.0,30.0) <= r){
            result++;
        }
        System.out.println(result);
    }
    public static double getDistance ( double x, double y, double x1, double y1){
        double distance = 0.0;
        distance = Math.pow(x - x1, 2) + Math.pow(y - y1, 2);
        return Math.sqrt(distance);
    }
}
