import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int F = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int G = Integer.parseInt(st.nextToken());
        int U = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        if (S == G) {
            System.out.println(0);
            return;
        }

        if ((S < G && U == 0) || (S > G && D == 0)) {
            System.out.println("use the stairs");
            return;
        }

        boolean[] visited = new boolean[F + 1];
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{S, 0});
        visited[S] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int currentFloor  = cur[0];
            int steps = cur[1];

            if (currentFloor == G) {
                System.out.println(steps);
                return;
            }

            int nextUp = currentFloor + U;
            if (nextUp <= F && !visited[nextUp]) {
                visited[nextUp] = true;
                q.offer(new int[]{nextUp, steps + 1});
            }

            int nextDown = currentFloor - D;
            if (nextDown >= 1 && !visited[nextDown]) {
                visited[nextDown] = true;
                q.offer(new int[]{nextDown, steps + 1});
            }
        }
        System.out.println("use the stairs");
    }
}