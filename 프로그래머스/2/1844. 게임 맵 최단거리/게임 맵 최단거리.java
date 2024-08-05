import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int[][] maps) {
        return BFS(new Point(0,0), maps);
    }
    
    public int BFS(Point point, int[][] maps) {
                Queue<Point> queue = new LinkedList<>();
        queue.offer(point);
        int[] dx = {1, -1 , 0, 0};
        int[] dy = {0, 0, 1, -1};
        int n = maps.length;
        int m = maps[0].length;
        int[][] ch = new int[n][m];
        int[][] dis = new int[n][m];
        dis[0][0] = 1;
        ch[0][0] = 1;
        while(!queue.isEmpty()){
            Point p = queue.poll();
            for(int i =0; i<4; i++){
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                if(nx >= 0 && nx < n && ny >= 0 && ny < m && maps[nx][ny] == 1 && ch[nx][ny] == 0){
                    ch[nx][ny] = 1;
                    queue.offer(new Point(nx,ny));
                    dis[nx][ny] = dis[p.x][p.y] + 1;
                }
            }
        }
      return dis[n - 1][m - 1] == 0 ? -1 : dis[n - 1][m - 1];
    }
}

class Point {
    public int x, y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

