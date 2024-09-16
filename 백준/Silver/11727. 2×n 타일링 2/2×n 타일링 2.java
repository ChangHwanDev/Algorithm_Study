import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        dp = new int[n + 1];


        int answer = solve(n);
        System.out.println(answer);
    }
    public static int solve(int n) {
        if(n == 1) return 1;
        else if (n == 2) return 3;
        else if (n == 3) return 5;
        if(dp[n] != 0) return dp[n];
        else return dp[n] = (solve(n - 1) + solve(n - 2) + solve(n - 2)) % 10007;
    }
}