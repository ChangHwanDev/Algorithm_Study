import java.awt.*;
import java.util.*;

class Solution {
   
    static boolean[][] visited;
    static int[][] dist;
    static char[][] graph;
    static int n, m;
    
    public int solution(String[] maps) {
            n = maps.length;
            m = maps[0].length();

            visited = new boolean[n][m];
            dist = new int[n][m];
            graph = new char[n][m];
            HashMap<Character, Point> pointMap = new HashMap<>();
            for (int i = 0; i < n; i++) {
                char[] chars = maps[i].toCharArray();
                for (int j = 0; j < chars.length; j++) {
                    graph[i][j] = chars[j];
                    if (graph[i][j] == 'S' || graph[i][j] == 'L' || graph[i][j] == 'E') {
                        pointMap.put(chars[j], new Point(i, j));
                    }
                }
            }
            int toLever = bfs(pointMap.get('S'), 'L');
                if (toLever == -1) return -1;

            for (int i = 0; i <n; i++) {
                Arrays.fill(dist[i], 0);
                Arrays.fill(visited[i],false);
            }

            int toExit = bfs(pointMap.get('L'), 'E');
            if (toExit == -1) return -1;

            return  toLever + toExit;
    }
    
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    static int bfs(Point start, char end) {
            Queue<Point> queue = new LinkedList<>();
            queue.offer(start);
            visited[start.x][start.y] = true;

            while (!queue.isEmpty()) {
                Point point = queue.poll();

                if (graph[point.x][point.y] == end){
                   return dist[point.x][point.y];
                }

                for (int i = 0; i < 4; i++){
                    int nx = point.x + dx[i];
                    int ny = point.y + dy[i];

                    if (nx >= 0 && nx < n && ny >= 0 && ny < m &&  !visited[nx][ny] && graph[nx][ny] != 'X'){
                        visited[nx][ny] = true;
                        dist[nx][ny] = dist[point.x][point.y] + 1;
                        queue.offer(new Point(nx, ny));
                    }
                }
            }

            return  -1;
        }
}