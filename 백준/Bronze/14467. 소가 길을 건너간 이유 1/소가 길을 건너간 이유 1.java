import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int[] cows = new int[n+1];
        Arrays.fill(cows, 101);

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int location = Integer.parseInt(st.nextToken());

            if(cows[num] == 101) {
                cows[num] = location;
            } else if(cows[num] != 101 && cows[num] != location) {
                cnt++;
                cows[num] = location;
            }
        }

        System.out.println(cnt);
    }
}