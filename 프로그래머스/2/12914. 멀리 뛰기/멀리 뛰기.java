class Solution {
    public long solution(int jump) {
            int[] dp = new int[2000];

            dp[1] = 1;
            dp[2] = 2;
            for(int i = 3; i <= jump; i++) {
                 dp[i] = (dp[i - 1] + dp[i - 2]) % 1234567;
            }
            return dp[jump];
    }
}