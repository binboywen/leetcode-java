package ThreadPool;

public class Main {
    public static void main(String [] args){
        String aa = "aaa;bbb;ccc ;";
        String [] bb = aa.split(" ;");
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < bb.length;i++){
            sb.append(bb[i]);
        }
        System.out.println(sb.toString());
    }
}
