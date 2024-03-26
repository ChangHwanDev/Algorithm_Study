import java.util.*;
class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        ArrayList<Integer> test = new ArrayList<>();
        HashMap<String, Integer> tempMap = new HashMap<>();
        for(int i = 0; i < clothes.length; i++){
            tempMap.put(clothes[i][1],tempMap.getOrDefault(clothes[i][1],0) + 1 );
        }
        for(String key : tempMap.keySet()){
            answer *= tempMap.get(key) +1;
        }
        answer -= 1;
        return answer;
    }
}