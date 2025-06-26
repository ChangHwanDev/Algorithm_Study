import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        long[] dp = new long[21];

        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        dp[4] = 7;

        for(int i=5; i<=20; i++){
            dp[i] = dp[i-1]*2;
            if(i%2 == 0){
                dp[i] -= (dp[i-4] + dp[i-5]);
            }
        }
        System.out.println(dp[N]);
    }
}