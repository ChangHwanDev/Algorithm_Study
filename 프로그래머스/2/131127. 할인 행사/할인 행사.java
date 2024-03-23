import java.util.*;
class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        HashMap<String, Integer> wantMap = new HashMap<>();
        for(int i = 0; i < number.length; i++){
            wantMap.put(want[i], number[i]);
        }
        
        for(int i = 0; i < discount.length -9; i++){
            HashMap<String, Integer> tempMap = new HashMap<>();
            for(int j =0; j < 10; j++){
                tempMap.put(discount[j + i],tempMap.getOrDefault(discount[j + i],0) +1);
            }
            Boolean isSame = true;
            
            for(String key : tempMap.keySet()){
                if(tempMap.get(key) != wantMap.get(key)){
                    isSame = false;
                    break;
                }
            }
            
            answer += isSame ? 1 : 0;
        }
        return answer;
    }
}