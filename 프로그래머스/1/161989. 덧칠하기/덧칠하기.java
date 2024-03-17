class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 1;
        int start = section[0];
        int end = section[0] + m -1;
       
        for(int i : section){
            if(start <= i && i <= end){
                continue;
            } else{
                answer++;
                start = i;
                end = i + m - 1;
            }
        }
        return answer;
    }
}