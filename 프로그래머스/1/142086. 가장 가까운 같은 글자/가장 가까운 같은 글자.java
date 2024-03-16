import java.util.HashMap;
// 자신의 앞에 있는 글자가 있는지 확인 필요
class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        HashMap<Character, Integer> tempMap = new HashMap<>();
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            answer[i] =  i - tempMap.getOrDefault(ch, i+1);
            tempMap.put(ch,i);
        }
        return answer;
    }
}