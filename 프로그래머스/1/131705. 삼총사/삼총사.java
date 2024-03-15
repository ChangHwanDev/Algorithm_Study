// 3명의 정수 번호를 더햇서 0 이 되면 삼총사 
// 삼총사를 만들수 있는 케이스
class Solution {
    public int solution(int[] number) {
        return solve(number);
        
    }
    
    public int solve(int[] number){
        int answer = 0;
        for (int i = 0; i < number.length -2; i++) {
            for(int j = 1 + i; j< number.length - 1; j++){
                for(int k = 1 + j; k < number.length; k++){
                    if(number[i] + number[j] + number[k] == 0) answer++;
                }
            }
        }
        return answer;
    }
}