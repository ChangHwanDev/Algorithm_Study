import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int[][] maps) {
        return bfs(0, 0, maps);
    }
    
    public int bfs(int startX, int startY, int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        
        int[][] distance = new int[n][m];
        
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(startX, startY));
        
        distance[startX][startY] = 1;
        
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        
        while (!queue.isEmpty()) {
            Point current = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];
                
                if (nx >= 0 && ny >= 0 && nx < n && ny < m && maps[nx][ny] == 1 && distance[nx][ny] == 0) {    
                    distance[nx][ny] = distance[current.x][current.y] + 1;
                    queue.offer(new Point(nx, ny));
                }
            }
        }
        
        return distance[n - 1][m - 1] == 0 ? -1 : distance[n - 1][m - 1];
    }
}

class Point {
    int x, y;
    
    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}