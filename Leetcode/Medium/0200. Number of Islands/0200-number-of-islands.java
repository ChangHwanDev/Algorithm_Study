class Solution {

    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, -1, 0, 1};

    public int numIslands(char[][] grid) {
        int answer = 0;
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && grid[i][j] == '1') {
                    visited[i][j] = true;
                    bfs(i, j, grid, visited);
                    answer++;
                }
            }
        }

        return answer;
    }

    void bfs(int startX, int startY, char[][] grid, boolean[][] visited) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{startX, startY});

        while (!q.isEmpty()) {
            int[] p = q.poll();
            int x = p[0];
            int y = p[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];


                if (nx >= 0 && ny >= 0 && nx < grid.length && ny < grid[0].length) {
                    if (!visited[nx][ny] && grid[nx][ny] == '1') {
                        visited[nx][ny] = true;
                        q.add(new int[]{nx, ny});
                    }
                }
            }
        }
    }
}