import java.awt.*;
import java.util.*;

class Solution {
    
    static boolean[][] visited;
    static int[] arr;
    
    public int solution(int[][] land) {
        arr = new int[land[0].length];
        visited = new boolean[land.length][land[0].length];

        for (int i = 0; i < land.length; i++) {
            for (int j = 0; j < land[i].length; j++) {
                if(land[i][j] == 1 && !visited[i][j]) {
                    bfs(land, new Point(i,j));
                }
            }
        }

        return Arrays.stream(arr).max().orElse(0);
    }
    
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public static void bfs(int[][] land, Point start){
            Set<Integer> set = new HashSet<>();
            Queue<Point> q = new LinkedList<>();
            q.offer(start);
            visited[start.x][start.y] = true;
            int sum = 1;

            while (!q.isEmpty()){
                Point p = q.poll();
                set.add(p.y);
                
                for (int i = 0; i < 4; i++) {
                    int nx = p.x + dx[i];
                    int ny = p.y + dy[i];
                    if (nx >= 0 && nx < land.length && ny >= 0 && ny < land[0].length
                            && land[nx][ny] == 1 && !visited[nx][ny]){
                        visited[nx][ny] = true;
                        sum += 1;
                        q.offer(new Point(nx, ny));
                    }
                }
            }

            for (int idx : set) {
                 arr[idx] += sum;
            }
        }
}