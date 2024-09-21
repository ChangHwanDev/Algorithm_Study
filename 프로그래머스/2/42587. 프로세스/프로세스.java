import java.util.*;
class Solution {
    
    public int solution(int[] priorities, int location) {
            Queue<int[]> q = new LinkedList<>();

            for (int i = 0; i < priorities.length; i++) {
                q.offer(new int[] { priorities[i], i });
            }

            int answer = 0;

            while (!q.isEmpty()) {
                int[] current = q.poll();
                boolean hasHigherPriority = false;

                for (int[] process : q) {
                    if (process[0] > current[0]) {
                        hasHigherPriority = true;
                        break;
                    }
                }

                if (hasHigherPriority) {
                    q.offer(current);
                } else {
                    answer++;
                    if (current[1] == location) {
                        return answer;
                    }
                }
            }

            return answer;
    }
}