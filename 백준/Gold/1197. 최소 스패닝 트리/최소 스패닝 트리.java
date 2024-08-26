import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n,m;
    static int[] unf;
    static ArrayList<Edge> tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        unf = new int[n+1];
        tree = new ArrayList<>();

        for(int i =1; i<=n; i++){
            unf[i] = i;
        }

        for(int i =0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            tree.add(new Edge(a,b,c));
        }

        Collections.sort(tree);
        long answer = 0;
        long maxCnt = n - 1;
        int cnt = 0;
        for(Edge edge : tree){
            if(maxCnt == cnt) break;
            int fa = find(edge.v1);
            int fb = find(edge.v2);
            if(fa != fb){
                answer += edge.cost;
                union(edge.v1, edge.v2);
                cnt++;
            }
        }
        System.out.println(answer);
    }

    static int find(int v1){
        if(v1 == unf[v1]) return v1;
        else return unf[v1] = find(unf[v1]);
    }

    static void union(int v1, int v2){
        int fa = find(v1);
        int fb = find(v2);
        if(fa != fb) unf[fa] = fb;
    }
}

class Edge implements Comparable<Edge>{
    int v1;
    int v2;
    int cost;

    public Edge(int v1, int v2, int cost) {
        this.v1 = v1;
        this.v2 = v2;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge o) {
        return this.cost - o.cost;
    }
}