import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());
        for(int i = 0; i < T; i++) {
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            st = new StringTokenizer(br.readLine());
            int count = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < count; j++) {
                int tmp = Integer.parseInt(st.nextToken());
                if(tmp < min) {
                    min = tmp;
                }

                if(tmp > max) {
                    max = tmp;
                }
            }
            System.out.println(min + " " + max);
        }
    }
}