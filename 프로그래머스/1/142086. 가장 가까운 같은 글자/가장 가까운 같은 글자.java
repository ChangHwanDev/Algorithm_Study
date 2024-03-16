// 자신의 앞에 있는 글자가 있는지 확인 필요
class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        answer[0] = -1;
        for(int i=1;i<s.length();i++){
            int idx = s.substring(0,i).lastIndexOf(s.charAt(i));
            if(idx != -1){
                answer[i] = i-idx;

            } else{
                answer[i] = idx;
            }
        }
        return answer;
    }
}