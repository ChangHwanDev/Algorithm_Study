import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        Deque<int[]> q = new ArrayDeque<>();

        n = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            int num = Integer.parseInt(st.nextToken());
            q.add(new int[] {(i), num});
        }

        int in = q.poll()[1];
        int[] nxt;
        sb.append("1 ");
        while(!q.isEmpty()) {
            if(in >0) {
                for(int i=1; i<in; i++) {
                    q.add(q.poll());
                }

                nxt = q.poll();
            } else {
                for(int i=1; i<-in; i++	) {
                    q.addFirst(q.pollLast());
                }

                nxt = q.pollLast();
            }
            
            in = nxt[1];
            sb.append(nxt[0]).append(" ");
        }

        System.out.println(sb);
    }
}