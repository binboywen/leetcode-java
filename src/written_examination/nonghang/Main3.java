package written_examination.nonghang;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main3 {
    public String [] getPokerOrder(String [] cards){
        List<Integer> L_K = new ArrayList<>();
        List<Integer> L_S = new ArrayList<>();
        List<Integer> L_H = new ArrayList<>();
        List<Integer> L_P = new ArrayList<>();
        List<Integer> L_Q = new ArrayList<>();
        for(String temp_card : cards){
            if(temp_card.charAt(0) == 'k'){
                L_K.add(Integer.valueOf(temp_card.charAt(1)- '0'));
            }
            if(temp_card.charAt(0) == 's'){
                L_S.add(Integer.valueOf(temp_card.charAt(1)- '0'));
            }
            if(temp_card.charAt(0) == 'h'){
                L_H.add(Integer.valueOf(temp_card.charAt(1)- '0'));
            }
            if(temp_card.charAt(0) == 'p'){
                L_P.add(Integer.valueOf(temp_card.charAt(1)- '0'));
            }
            if(temp_card.charAt(0) == 'q'){
                L_Q.add(Integer.valueOf(temp_card.charAt(1)- '0'));
            }
        }
        Collections.sort(L_K);
        Collections.sort(L_S);
        Collections.sort(L_H);
        Collections.sort(L_P);
        Collections.sort(L_Q);
        int result = 0;
        int width = cards.length;
        while(result < width){
            for(int i = 0; i < L_K.size(); i++,result++){
                cards[result] = "k" + L_K.get(i);
            }
            for(int i = 0; i < L_S.size(); i++,result++){
                cards[result] = "s" + L_S.get(i);
            }
            for(int i = 0; i < L_H.size(); i++,result++){
                cards[result] = "h" + L_H.get(i);
            }
            for(int i = 0; i < L_P.size(); i++,result++){
                cards[result] = "p" + L_P.get(i);
            }
            for(int i = 0; i < L_Q.size(); i++,result++){
                cards[result] = "q" + L_Q.get(i);
            }
        }
        return cards;
    }
}
