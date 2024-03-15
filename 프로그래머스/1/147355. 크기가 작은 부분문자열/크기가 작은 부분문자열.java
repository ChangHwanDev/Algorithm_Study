// t 와 p 길이가 같은 부분 중
//  t의 수가 p 보다 작거나 같으면 ++
class Solution {
    public int solution(String t, String p) {
        int tLen = t.length();
        int pLen = p.length();
        int answer = 0;

        for(int i=0; i <= tLen - pLen; i++){
            Long tempNum = Long.parseLong(t.substring(i, pLen + i));
            if(tempNum <= Long.parseLong(p)){
                answer++;
            }
        }

        return answer;
    }
}