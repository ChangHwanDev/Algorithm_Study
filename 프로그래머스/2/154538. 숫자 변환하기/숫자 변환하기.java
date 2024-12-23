import java.util.*;
class Solution {
        public int solution(int x, int y, int n) {
            if (x == y) return 0;

            boolean[] visited = new boolean[y + 1];
            Queue<int[]> queue = new LinkedList<>();
            queue.offer(new int[]{x, 0});

            while (!queue.isEmpty()) {
                int[] current = queue.poll();
                int currentX = current[0];
                int operations = current[1];

                if (currentX == y) {
                    return operations;
                }

                if (visited[currentX]) continue;
                visited[currentX] = true;

                if (currentX + n <= y && !visited[currentX + n]) {
                    queue.offer(new int[]{currentX + n, operations + 1});
                }
                if (currentX * 2 <= y && !visited[currentX * 2]) {
                    queue.offer(new int[]{currentX * 2, operations + 1});
                }
                if (currentX * 3 <= y && !visited[currentX * 3]) {
                    queue.offer(new int[]{currentX * 3, operations + 1});
                }
            }

            return -1;
        }
}