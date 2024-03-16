import java.util.HashMap;
class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
     HashMap<String, Integer> scoreMap = new HashMap<>();
        int[] answer = new int[photo.length];
        for(int i =0; i < name.length; i++){
            scoreMap.put(name[i],yearning[i]);
        }
        for(int i=0; i< photo.length; i++){
            int score = 0;
            for(int j=0; j< photo[i].length; j++){
                score += scoreMap.getOrDefault(photo[i][j],0);
            }
            answer[i] = score;
        }
        return answer;
    }
}