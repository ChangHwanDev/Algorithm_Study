import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Edge implements Comparable<Edge>{
        int p;
        int w;

        public Edge(int p, int w) {
            this.p = p;
            this.w = w;
        }

        @Override
        public int compareTo(Edge o) {
            return this.w - o.w;
        }
    }
    static int n, m;
    static long budget;
    static List<Edge>[] vectors;
    static int[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        vectors = new List[n + 1];
        visited = new int[n + 1];
        for (int i =0; i < n +1; i++){
            vectors[i] = new ArrayList<>();
        }

        for(int i = 1; i <= m; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int from = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            vectors[start].add(new Edge(from,v));
            vectors[from].add(new Edge(start,v));
            budget += v;
        }
        long result = solve();
        boolean isConnect = true;
        for (int i = 1; i <= n; i++) {
            if(visited[i]!= 1){
                isConnect = false;
                break;
            }
        }
        System.out.println(isConnect ? budget - result : -1);
    }

    public static long solve(){
        PriorityQueue<Edge> pQueue = new PriorityQueue<>();
        pQueue.offer(new Edge(1,0));
        long answer = 0;
        while (!pQueue.isEmpty()){
            Edge tmp = pQueue.poll();
            int next = tmp.p;
            int value = tmp.w;

            if(visited[next] == 0){
                visited[next] = 1;
                answer += value;
                for(int i = 0; i < vectors[next].size(); i++){
                    Edge nVex = vectors[next].get(i);
                    if(visited[nVex.p] == 0){
                        pQueue.offer(nVex);
                    }
                }
            }
        }
        return answer;
    }
}