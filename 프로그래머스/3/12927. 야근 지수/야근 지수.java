import java.util.*;
class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
              PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
            for (int work : works) {
                pq.add(work);
            }

            while (n-- > 0){
                pq.offer(pq.poll() - 1);
            }

            while (!pq.isEmpty()) {
                int tmp = pq.poll();
                if (tmp <= 0) continue;
                answer +=  Math.pow(tmp, 2);
            }
        return answer;
    }
}