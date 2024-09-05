import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int[] lights = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            lights[i] = Integer.parseInt(st.nextToken());
        }

        int t = Integer.parseInt(br.readLine());
        for(int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            int gender = Integer.parseInt(st.nextToken());
            int count = Integer.parseInt(st.nextToken());
            if(gender == 1) {
                for (int j = 1; j < lights.length; j++) {
                    if (j % count == 0) {
                        lights[j] = lights[j] == 1 ? 0 : 1;
                    }
                }
            } else if(gender == 2){
                solve(lights, count);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < lights.length; i++) {
            sb.append(lights[i]).append(" ");
            if(i % 20 == 0) sb.append("\n");
        }
        System.out.println(sb);
    }

    public static void solve(int[] lights, int count) {
        lights[count] = lights[count] == 1 ? 0 : 1;
        int up = count + 1;
        int down = count - 1;
        while(up < lights.length && down > 0) {
            if(lights[up] == lights[down]){
                lights[up] = lights[up] == 1 ? 0 : 1;
                lights[down] = lights[down] == 1 ? 0 : 1;
                down--;
                up++;
            } else {
                break;
            }
        }
    }
}