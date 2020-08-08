package written_examination.jingdong;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {
    public static float getNumber(float number){
        DecimalFormat df = new DecimalFormat("#.####");
        float f = Float.valueOf(df.format(number));
        return f;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double f = 1.0/5;
        boolean flag = true;
        for (int i = 1; i <= 2*n; i++) {
            double temp = 1.0 / (5  * i);
            if (flag) {
                temp = -temp;
            }
            f+=temp;
            flag = !flag;
        }
        double result = (double) Math.round(f * 10000)/10000;
        String format = new DecimalFormat("0.0000").format(result);
        System.out.println(format);
    }
}
