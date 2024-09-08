import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);

        int n = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            int temp = Integer.parseInt(br.readLine());
            if (temp != 0) {
                pq.add(temp);
            } else {
                int result = pq.isEmpty() ? 0 : pq.poll();
                sb.append(result).append("\n");
            }
        }
        System.out.println(sb);
    }
}