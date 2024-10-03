class Solution {
    public long solution(long k, long d) {
            long answer = 0;

            for (int x = 0; x <= d; x += k) {
                double y = Math.sqrt(Math.pow(d, 2) - Math.pow(x, 2));
                answer += (long) y / k + 1;
            }

            return answer;
    }
}