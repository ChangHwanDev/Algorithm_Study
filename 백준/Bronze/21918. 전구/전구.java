import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] light = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            light[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken()) - 1;
            int r = Integer.parseInt(st.nextToken());

            switch (command) {
                case 1:
                    light[l] = r;
                    break;
                case 2:
                    toggleLights(light, l, r);
                    break;
                case 3:
                    setLights(light, l, r, 0);
                    break;
                case 4:
                    setLights(light, l, r, 1);
                    break;
            }
        }
        for (int i : light) {
            sb.append(i).append(" ");
        }

        System.out.println(sb);
    }

    private static void toggleLights(int[] light, int l, int r) {
        for (int i = l; i < r; i++) {
            light[i] = light[i] == 0 ? 1 : 0;
        }
    }

    private static void setLights(int[] light, int l, int r, int value) {
        for (int i = l; i < r; i++) {
            light[i] = value;
        }
    }
}