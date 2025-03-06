import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {

    static BigInteger[][] dp = new BigInteger[101][101];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        System.out.println(combi(n, m));
    }

    public static BigInteger combi (int n, int m) {
        if (m == 0 || n == m) return BigInteger.ONE;

        if (dp[n][m] != null) {
            return dp[n][m];
        }

        return dp[n][m] = combi(n - 1, m - 1).add(combi(n - 1, m ));
    }
}