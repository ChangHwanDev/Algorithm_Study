import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Long> pq = new PriorityQueue<>();

        for (int work : scoville) {
            pq.add((long) work);
        }

        while (pq.size() > 1) {
            Long minimumScoville = pq.poll();

            if (minimumScoville >= K) break;
            Long secondScoville = pq.poll();
            Long mixedScoville = minimumScoville + secondScoville * 2;
            pq.offer(mixedScoville);
            answer++;
        }

        if (!pq.isEmpty() && pq.peek() < K) answer = -1;

        return answer;
    }
}