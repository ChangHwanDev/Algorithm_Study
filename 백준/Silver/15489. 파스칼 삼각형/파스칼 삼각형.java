import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        int[][] pascal = new int[31][31];

        for (int i = 1; i <= 30; i++) {
            pascal[i][1] = 1;
            for (int j = 2; j <= i; j++) {
                pascal[i][j] = pascal[i-1][j-1] + pascal[i-1][j];
            }
        }

        int sum = 0;
        for (int i = 0; i < W; i++) {
            for (int j = 0; j <= i; j++) {
                sum += pascal[R + i][C + j];
            }
        }

        System.out.println(sum);
    }
}