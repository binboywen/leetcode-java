package written_examination.huawei;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main2 {
    public static void main(String [] args){
        double [] teamA = {10,20};
        double [] teamB = {15,30};
        System.out.println(getMax(teamA,teamB));    }
    public static double getHashSetMean(Set<Double> A){
        double result = 0;
        for(double num : A){
            result += num;}
        return result / A.size();}
    public static int getMax(double [] teamA, double [] teamB){
        Set<Double> SetA = new HashSet<>();
        Set<Double> SetB = new HashSet<>();
        for(double num : teamA){
            SetA.add(num);}
        for(double num : teamB){
            SetB.add(num);}
        double meanA = getHashSetMean(SetA);
        double meanB = getHashSetMean(SetB);
        int count = 0;
        int size = SetA.size();
        while(SetA.size() > 1){
            for(double num : teamA){
                if(num < meanA && num > meanB){
                    if(!SetB.contains(num)){
                        SetA.remove(num);
                        SetB.add(num);
                        count++;
                        break; }}}
            meanA = getHashSetMean(SetA);
            meanB = getHashSetMean(SetB);
            if(SetA.size() == size){
                break;}
            size = SetA.size();}
        return count;
    }
}
