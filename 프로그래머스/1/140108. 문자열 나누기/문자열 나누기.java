class Solution {
    public int solution(String s) {
        int answer = 1;
        int same = 1;
        int diff = 0;
        char first = s.charAt(0);
        for(int i=1; i< s.length(); i++) {
            if(first == s.charAt(i)){
                same++;
            }else{
                diff++;
            }
            if(same == diff && i < s.length() - 1) {
                answer++;
                first = s.charAt(i+1);
                same=0;
                diff=0;
            }
        }
        return answer;
    }
}