import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int T;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(st.nextToken());
        for (int i = 0; i < T; i++) {
            LinkedList<int[]> q = new LinkedList<>();

            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                q.offer(new int[]{j, Integer.parseInt(st.nextToken())});
            }

            int idx = 0;
            while (!q.isEmpty()) {
                int[] cur = q.poll();
                boolean isMax = true;

                for(int j = 0; j < q.size(); j++){
                    if(cur[1] < q.get(j)[1]){
                        q.offer(cur);
                        for(int k = 0; k < j; k++){
                            q.offer(q.poll());
                        }

                        isMax = false;
                        break;
                    }
                }

                if(!isMax){
                    continue;
                }

                idx++;
                if(m == cur[0]) {
                    break;
                }
            }
            sb.append(idx + "\n");
        }
        System.out.println(sb);
    }
}