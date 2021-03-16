package hu.nive.ujratervezes.zarovizsga.digitscounter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DigitsCounter {
    public int getCountOfDigits(String s) {
        if(s==null || "".trim().equals(s)){
            return 0;
        }

        List<Integer> numbers = new ArrayList<>();
        addNumbers(s, numbers);

        Map<Integer, Integer> counter = counter(numbers);

        return counter.size();
    }

    private void addNumbers(String s, List<Integer> numbers) {
        for(char c: s.toCharArray()){
            if(c>=48 && c <=57){
                numbers.add(Character.getNumericValue(c));
            }
        }
    }

    private Map<Integer, Integer> counter(List<Integer> numbers) {
        Map<Integer, Integer> counter = new HashMap<>();
        for (int i : numbers){
            if(counter.containsKey(i)){
                counter.put(i, counter.get(i)+1);
            } else {
                counter.put(i, 1);
            }
        }
        return counter;
    }
}
