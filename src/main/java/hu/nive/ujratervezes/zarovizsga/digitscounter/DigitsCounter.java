package hu.nive.ujratervezes.zarovizsga.digitscounter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DigitsCounter {
    public int getCountOfDigits(String s) {
        int result = 0;
        if(s==null || "".trim().equals(s)){
            return 0;
        }

        List<Integer> numbers = new ArrayList<>();

        for(char c:s.toCharArray()){
            if(c>=48 && c <=57){
                numbers.add(Character.getNumericValue(c));
            }
        }

        Map<Integer, Integer> counter = new HashMap<>();
        for (int i :numbers){
            if(counter.containsKey(i)){
                counter.put(i, counter.get(i)+1);
            } else {
                counter.put(i, 1);
            }
        }

        result = counter.size();
        return result;
    }
}
