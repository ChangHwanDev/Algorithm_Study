import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int min = Integer.MAX_VALUE;
        int max = 0;
        int[][] land = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                land[i][j] = Integer.parseInt(st.nextToken());
                min = Math.min(min, land[i][j]);
                max = Math.max(max, land[i][j]);
            }
        }
        int height = 0;
        int minTime = Integer.MAX_VALUE;
        for(int i = min; i <= max; i++){
            int blockCount = b;
            int second = 0;

            for(int j = 0; j < m; j++){
                for(int k = 0; k < n; k++){
                    int diff = land[k][j] - i;
                    if (diff > 0) {
                        blockCount += diff;
                        second += 2 * diff;
                    } else if (diff < 0) {
                        blockCount -= i - land[k][j];
                        second += i - land[k][j];
                    }
                }
            }

            if(blockCount < 0) continue;

            if(minTime >= second) {
                minTime = second;
                height = Math.max(height, i);
            }
        }
        System.out.println(minTime +" "+ height);
    }
}