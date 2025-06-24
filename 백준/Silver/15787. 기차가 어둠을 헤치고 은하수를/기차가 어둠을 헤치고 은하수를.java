import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] trains = new int[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int cmd = Integer.parseInt(st.nextToken());
            int trainNumber = Integer.parseInt(st.nextToken());

            if (cmd == 1) {
                int x = Integer.parseInt(st.nextToken());
                trains[trainNumber] |= (1 << (x - 1));
            } else if (cmd == 2) {
                int x = Integer.parseInt(st.nextToken());
                trains[trainNumber] &= ~(1 << (x - 1));
            } else if (cmd == 3) {
                trains[trainNumber] <<= 1;
                trains[trainNumber] &= ~(1 << 20);
            } else if (cmd == 4) {
                trains[trainNumber] >>= 1;
            }
        }

        Set<Integer> set = new HashSet<>();
        for (int i = 1; i <= N; i++) {
            set.add(trains[i]);
        }

        System.out.println(set.size());
    }
}