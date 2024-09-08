import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Problem implements Comparable<Problem> {
        int l;
        int p;

        public Problem(int l, int p) {
            this.l = l;
            this.p = p;
        }

        @Override
        public int compareTo(Problem o) {
            if(this.l == o.l) return this.p - o.p;
            return this.l - o.l;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        TreeSet<Problem> map = new TreeSet<>();
        HashMap<Integer, Integer> levelMap = new HashMap<>();

        int n = Integer.parseInt(st.nextToken());
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            map.add(new Problem(l, p));
            levelMap.put(p, l);
        }

        st = new StringTokenizer(br.readLine());
        int commandCount = Integer.parseInt(st.nextToken());
        for(int i = 0; i < commandCount; i++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            if("add".equals(command)) {
                int p = Integer.parseInt(st.nextToken());
                int l = Integer.parseInt(st.nextToken());
                levelMap.put(p, l);
                map.add(new Problem(l, p));
            } else if ("recommend".equals(command)) {
                int num = Integer.parseInt(st.nextToken());
                if(num == 1){
                    System.out.println(map.last().p);
                } else if (num == -1){
                    System.out.println(map.first().p);
                }
            }  else {
                int p = Integer.parseInt(st.nextToken());
                map.remove(new Problem(levelMap.get(p), p));
            }
        }
    }
}