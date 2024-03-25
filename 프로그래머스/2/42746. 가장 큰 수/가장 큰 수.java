import java.util.*;
class Solution {
    public String solution(int[] numbers) {
        String[] results = new String[numbers.length];

        for(int i =0; i < numbers.length; i++){
            results[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(results, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));
        
        if("0".equals(results[0]))
            return "0";
        
        return String.join("",results);
    }
}