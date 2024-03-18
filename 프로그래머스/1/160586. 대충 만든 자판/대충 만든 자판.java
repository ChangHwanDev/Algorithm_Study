import java.util.HashMap;

class Solution {
    public int[] solution(String[] keyMap, String[] targets) {
        int[] result = new int [targets.length];
        HashMap<String, Integer> keyValue = new HashMap<>();
        
        for(int i=0; i < keyMap.length; i++){
            for(int j = 0; j<keyMap[i].length();j++){
                String temp = String.valueOf(keyMap[i].charAt(j));

                if(keyValue.getOrDefault(temp,0) == 0 || keyValue.getOrDefault(temp,0) > j + 1){
                    keyValue.put(temp, j + 1);
                }
            }
        }
        
        for(int i=0; i< targets.length; i++){
            int sum = 0;
            for(int j=0; j< targets[i].length(); j++){
                int temp = keyValue.getOrDefault(String.valueOf(targets[i].charAt(j)),-1);
                if(temp == -1){
                    sum = -1;
                    break;
                } else{
                    sum += temp;
                }
            }
             result[i] = sum;
        }
        return result;
    }
}