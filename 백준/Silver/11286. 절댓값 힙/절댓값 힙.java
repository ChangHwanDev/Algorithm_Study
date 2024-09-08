import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        HashMap<Integer, Integer> counts = new HashMap<>();
        TreeSet<Integer> map = new TreeSet<>(((o1, o2) -> {
            if(Math.abs(o1) == Math.abs(o2)) return o1 - o2;
            return Math.abs(o1) - Math.abs(o2);
        }));

        int n = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            int temp = Integer.parseInt(br.readLine());
            if(temp != 0) {
                counts.put(temp, counts.getOrDefault(temp, 0) + 1);
                map.add(temp);
            } else {
                if(map.isEmpty()){
                    System.out.println("0");
                    continue;
                }
                int min = map.first();
                System.out.println(min);
                counts.put(min, counts.get(min) -1);
                if(counts.get(min) == 0)
                    map.remove(min);
            }
        }
    }
}