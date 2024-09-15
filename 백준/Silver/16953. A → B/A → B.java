import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static long answer;
    static long n, m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        bfs();
    }

    static void bfs() {
        Queue<Long> q = new LinkedList<>();
        answer = 0;
        q.add(n * 10 + 1);
        q.add(n * 2);

        while(!q.isEmpty()) {
            answer++;
            int size = q.size();

            for (int i = 0; i < size; i++) {
                long now = q.poll();
                if(now > m) continue;
                if(now == m) {
                    System.out.println(answer+1);
                    return;
                }
                q.add(now*2);
                q.add(now*10+1);
            }
        }

        System.out.println(-1);
    }
}