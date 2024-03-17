class Solution {
    public int solution(int number, int limit, int power) {
         int answer = 0;
        for(int i =1; i <= number; i++){
            int count = 0;
            // 약수의 제곱근까지 계산하기 위함
            // 약수가 홀수 일 경우 + 1
            // 짝수 +2
            for(int j=1; j * j <= i; j++){
                if(j * j == i) count++;
                else if(i % j == 0) count += 2;
            }
            answer += count > limit ? power : count;
        }
        return answer;
    }
}