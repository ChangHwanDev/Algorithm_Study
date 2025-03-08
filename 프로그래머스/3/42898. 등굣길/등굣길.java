class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int MOD = 1_000_000_007;
        int[][] dp = new int[m][n];
        
        for (int i = 0; i < puddles.length; i++) {
            dp[puddles[i][0] - 1][puddles[i][1] - 1] = -1;
        }
        
        dp[0][0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dp[i][j] == -1) {
                    continue;
                }
                
                if (i > 0 && dp[i - 1][j] != -1) {
                    dp[i][j] = (dp[i][j] + dp[i - 1][j]) % MOD;
                }
                
                if (j > 0 && dp[i][j - 1] != -1) {
                    dp[i][j] = (dp[i][j] + dp[i][j - 1]) % MOD;
                }
            }
        }
        return dp[m - 1][n -1];
    }
}