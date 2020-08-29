package written_examination.nonghang;

public class Main2 {
    public int get_index(String [] points){
        int TSum = points.length;
        double x_m = 0;
        double y_m = 0;
        double x_s = 0;
        double y_s = 0;
        for(String str : points){
            x_s += Double.valueOf(str.charAt(0) - '0');
            y_s += Double.valueOf(str.charAt(2) - '0');
        }
        x_m = x_s / TSum;
        y_m = y_s / TSum;
        int index = -1;
        double m_dis = Double.MAX_VALUE;
        for(int i = 0; i < points.length; i++){
            double x = Double.valueOf(points[i].charAt(0) - '0');
            double y = Double.valueOf(points[i].charAt(2) - '0');
            double temp = Math.sqrt(Math.pow(x-x_m,2) + Math.pow(y-y_m,2));
            if(temp < m_dis){
                index = i;
                m_dis = temp;
            }
        }
        return index;
    }
}






















