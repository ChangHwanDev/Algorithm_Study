class Solution {
        static int[] dx = {-1, 0, 1, 0};
        static int[] dy = {0, 1, 0, -1};
    public int solution(String dirs) {
            int answer = 0;
            boolean[][][] visited = new boolean[11][11][4];
            int x = 5, y = 5;
            int d = 0;
            
            for (char c : dirs.toCharArray()) {
                if (c == 'U') {
                    d = 0;
                } else if (c == 'R') {
                    d = 1;
                } else if (c == 'D') {
                    d = 2;
                } else if (c == 'L') {
                    d = 3;
                }

                int nx = x + dx[d];
                int ny = y + dy[d];
                if (nx < 0 || ny < 0 || nx >= 11 || ny >= 11) continue;
                if (!visited[nx][ny][d]){
                    visited[nx][ny][d] = true;
                     visited[x][y][(d + 2) % 4] = true;
                    answer++;
                }
                x = nx;
                y = ny;
            }
        return answer;
    }
}