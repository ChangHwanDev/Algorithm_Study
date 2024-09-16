import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static class sortNum implements Comparable<sortNum> {
        int key;
        int count;

        public sortNum(int key, int count) {
            this.key = key;
            this.count = count;
        }

        @Override
        public int compareTo(sortNum o) {
            if(this.count == o.count) return key - o.key;
            return o.count - this.count;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<sortNum> pq = new PriorityQueue<sortNum>();
        HashMap<Integer ,Integer> map = new HashMap<>();
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        double sum = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
            map.put(arr[i],map.getOrDefault(arr[i], 0) + 1);
            pq.add(new sortNum(arr[i], map.get(arr[i])));
        }

        int answer = solve(pq);
        Arrays.sort(arr);
        System.out.println(Math.round(sum / n));
        System.out.println(arr[n / 2]);
        System.out.println(answer);
        System.out.println(arr[n-1] - arr[0]);
    }

    public static int solve(PriorityQueue<sortNum> pq) {
        int answer = 0;
        while (!pq.isEmpty()) {
            sortNum v1 = pq.poll();
            sortNum v2 = pq.poll();
            if (v2 == null){
                answer = v1.key;
                break;
            } else if (v1.count == v2.count) {
                answer = v2.key;
                break;
            } else if (v1.count > v2.count) {
                answer = v1.key;
                break;
            }
        }
        return answer;
    }
}