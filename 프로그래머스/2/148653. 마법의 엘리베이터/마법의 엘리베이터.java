class Solution {
    public int solution(int storey) {
            int answer = 0;

            while (storey != 0){
                int temp = storey % 10;
                if (temp > 5 || (temp == 5 && (storey / 10) % 10 >= 5)){
                    answer += 10 - temp;
                    storey = (storey + 10 - temp) / 10;
                } else {
                    answer += temp;
                    storey = storey / 10;
                }
            }
            return answer;
    }
}