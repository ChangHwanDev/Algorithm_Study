import java.util.*;
class Solution {
    public String solution(int[] numbers) {
        String[] strNums =  new String[numbers.length];
        
        for (int i = 0; i < numbers.length; i++) {
            strNums[i] = String.valueOf(numbers[i]);
        }
        
        Arrays.sort(strNums, (a ,b) -> (b + a).compareTo(a + b));
        
        if (strNums[0].equals("0")) {
            return "0";
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strNums.length; i++) {
            sb.append(strNums[i]);
        }
        
        return sb.toString();
    }
}