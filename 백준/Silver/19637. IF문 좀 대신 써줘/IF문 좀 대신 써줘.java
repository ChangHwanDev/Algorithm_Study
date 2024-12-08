import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        String[] titles = new String[n];
        int[] powerLimits = new int[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            titles[i] = st.nextToken();
            powerLimits[i] = Integer.parseInt(st.nextToken());
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            int champPower = Integer.parseInt(br.readLine());
            int idx = binarySearch(powerLimits, champPower);
            sb.append(titles[idx]).append("\n");
        
        }
        System.out.println(sb.toString());
    }
    private static int binarySearch(int[] powerLimits, int champPower) {
        int left = 0, right = powerLimits.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (champPower > powerLimits[mid]) {
                left  = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }
}