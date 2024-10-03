class Solution {
        static int N;
        public int solution(int[][] board) {
            int answer = 0;
            N = board.length;
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    if (board[i][j] == 1) {
                        bomb(i,j, board);
                    }
                }
            }

            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    if (board[i][j] == 0) answer++;
                }
            }
            return answer;
    }
    
    static int[] dx = {-1, 0, 1, 1, 1, 0, -1, -1};
        static int[] dy = {1, 1, 1, 0, -1, -1, -1, 0};
        static void bomb(int i, int j, int[][] board) {
            for (int k = 0; k < 8; k++) {
                int nx = i + dx[k];
                int ny = j + dy[k];

                if (nx >= 0 && ny >= 0 && nx < N && ny < N && board[nx][ny] == 0) {
                    board[nx][ny] = 2;
                }
            }
    }
}