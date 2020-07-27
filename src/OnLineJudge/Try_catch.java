package OnLineJudge;

public class Try_catch {
    public static void main(String [] args){
        try{
            System.out.println(0);
            return;
        }catch(Exception s){}
        finally{
            System.out.println(1);
            return;
        }
    }
}
