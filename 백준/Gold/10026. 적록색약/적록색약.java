import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main {
    static int[] dx = { 0, 1, 0, -1 };
    static int[] dy = { 1, 0, -1, 0 };
    static int n;
    static boolean[][] visited;
    static char[][] ch;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        ch = new char[n][n];
        for (int i = 0; i < n; i++) {
            ch[i] = br.readLine().toCharArray();
        }

        visited = new boolean[n][n];
        int answer1 = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(!visited[i][j]){
                    DFS(i, j, ch[i][j]);
                    answer1++;
                }
                if(ch[i][j] == 'G')
                    ch[i][j] = 'R';
            }
        }

        visited = new boolean[n][n];
        int answer2 = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(!visited[i][j]){
                    DFS(i, j, ch[i][j]);
                    answer2++;
                }
            }
        }
        System.out.println(answer1 + " " + answer2);
    }

    public static void DFS(int x, int y, char target) {
        if(visited[x][y]) return;

        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < n && ny >= 0 && ny < n && ch[nx][ny]== target) {
                DFS(nx, ny, ch[nx][ny]);
            }
        }
    }
}
