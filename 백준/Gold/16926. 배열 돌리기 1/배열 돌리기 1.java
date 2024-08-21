import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, m, r;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < Math.min(n, m) / 2; j++) {
                int temp = map[j][j];

                for (int k = j; k < m - j - 1; k++) {
                    map[j][k] = map[j][k + 1];
                }

                for (int k = j; k < n - j - 1; k++) {
                    map[k][m - j - 1] = map[k + 1][m - j - 1];
                }
                for (int k = m - j - 1; k > j; k--) {
                    map[n - j - 1][k] = map[n - j - 1][k - 1];
                }

                for (int k = n - j - 1; k > j; k--) {
                    map[k][j] = map[k - 1][j];
                }

                map[j + 1][j] = temp;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int num = map[i][j];
                sb.append(num).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}