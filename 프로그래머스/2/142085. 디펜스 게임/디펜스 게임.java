import java.util.Collections;
import java.util.PriorityQueue;
class Solution {
    public int solution(int n, int k, int[] enemy) {
            PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
            int answer = enemy.length;
            int life = n;
            for (int i = 0; i < enemy.length; i++) {
                life -= enemy[i];
                pq.offer(enemy[i]);

                if (life < 0){
                    if (k > 0) {
                        life += pq.poll();
                        k--;
                    } else {
                        answer = i;
                        break;
                    }
                }
            }

            return answer;
    }
}