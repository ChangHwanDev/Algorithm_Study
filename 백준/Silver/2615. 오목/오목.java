import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] matrix;
    static int[] dx = {0, 1, 1, -1};
    static int[] dy = {1, 0, 1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        matrix = new int[20][20];
        for (int i = 1; i < 20; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < 20; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 1; i < 20; i++) {
            for (int j = 1; j < 20; j++) {
                int color = matrix[j][i];
                if (color != 0){
                    for (int k = 0; k < 4; k++) {
                        if(check(j, i, k)){
                            System.out.println(color);
                            System.out.println(j + " " + i);
                            return;
                        }
                    }
                }
            }
        }
        System.out.println("0");
    }

    public static boolean check(int x, int y, int direction){
        int count = 1;

        int nx = x + dx[direction];
        int ny = y + dy[direction];
        while(isValid(nx,ny) && matrix[nx][ny] == matrix[x][y]){
            count++;
            nx += dx[direction];
            ny += dy[direction];
        }

        nx = x - dx[direction];
        ny = y - dy[direction];
        while(isValid(nx,ny) && matrix[nx][ny] == matrix[x][y]){
            count++;
            nx -= dx[direction];
            ny -= dy[direction];
        }

        return count == 5;
    }

    public static boolean isValid(int nx, int ny){
        return nx > 0 && nx < 20 && ny > 0 && ny < 20;
    }
}
