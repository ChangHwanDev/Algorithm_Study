import java.util.*;
class Solution {
    public int solution(int[][] jobs) {
            Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]);

            PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);

            int currentTime = 0;
            int completedJobs = 0;
            int totalWaitTime = 0;
            int idx = 0;

            while (completedJobs < jobs.length) {
                while (idx < jobs.length && jobs[idx][0] <= currentTime) {
                    pq.add(jobs[idx]);
                    idx++;
                }

                if (pq.isEmpty()) {
                    currentTime = jobs[idx][0];
                } else {
                    int[] job = pq.poll();
                    currentTime += job[1];
                    totalWaitTime += currentTime - job[0];
                    completedJobs++;
                }
            }

            return totalWaitTime / jobs.length;
    }
}