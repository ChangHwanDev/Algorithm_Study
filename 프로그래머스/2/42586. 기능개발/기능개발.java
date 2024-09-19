import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
Queue<Integer> queue = new LinkedList<>();
            for (int progress : progresses) {
                queue.add(progress);
            }

         int stackCount = 0;
            int days = 0;
            List<Integer> answers = new ArrayList<>();

            while (!queue.isEmpty()) {
                int answer = 0;
                while (!queue.isEmpty() && queue.peek() + days * speeds[stackCount] >= 100){
                    queue.poll();
                    stackCount++;
                    answer++;
                }
                days++;
                if (answer != 0) answers.add(answer);
            }

               int[] answer = new int[answers.size()];
            for (int i =0; i < answers.size(); i++) {
                answer[i] = answers.get(i);
            }

            return answer;
        
    }
}