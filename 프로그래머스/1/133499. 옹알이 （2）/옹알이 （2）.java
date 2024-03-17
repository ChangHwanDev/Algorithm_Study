import java.util.Arrays;
class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        String[] allow = {"aya", "ye", "ma" , "woo"};
        String[] ban = {"ayaaya", "yeye" , "mama", "woowoo"};
        for(String b : babbling){
            for(int j=0; j< allow.length; j++){
                b = b.replaceAll(ban[j], "1").replaceAll(allow[j], " ");
            }
            if(b.trim().isEmpty()){
                answer++;
            }
        }
        return answer;
    }
}