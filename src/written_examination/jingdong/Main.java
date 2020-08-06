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
        for (int i = 1; i <= n; i++) {
            double temp = 1.0 / (5 * 2 * i);
            if (flag) {
                temp = -temp;
            }
            f+=temp;
            flag = !flag;
        }
        BigDecimal a = new BigDecimal(f);
        a.setScale(4,BigDecimal.ROUND_HALF_UP);
        String format = new DecimalFormat("0.0000").format(a);
        System.out.println(format);
    }
}
