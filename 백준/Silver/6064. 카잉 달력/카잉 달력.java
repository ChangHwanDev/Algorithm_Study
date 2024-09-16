import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            System.out.println(findYear(M, N, x, y));
        }
    }

    public static int findYear(int M, int N, int x, int y) {
        x -= 1;
        y -= 1;

        for (int k = x; k < (long) M * N; k += M) {
            if (k % N == y) {
                return k + 1;
            }
        }

        return -1;
    }
}