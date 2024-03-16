class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        while(true){
            answer += b *(n / a);
            n = b * (n/a) + n % a;

            if(n < a)break;
        }
        return answer;
    }
}