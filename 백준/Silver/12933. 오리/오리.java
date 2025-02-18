import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] sound = br.readLine().toCharArray();
        int n = sound.length;

        if (n % 5 != 0 || sound[0] != 'q') {
            System.out.println("-1");
            return;
        }

        boolean[] visited = new boolean[n];
        char[] pattern = {'q', 'u', 'a', 'c', 'k'};

        int answer = 0;
        int remainChars = n;
        while (remainChars > 0) {
            int patternIndex = 0;
            boolean foundCycle = false;

            for (int i = 0; i < sound.length; i++) {
                if (!visited[i] && sound[i] == pattern[patternIndex]) {
                    visited[i] = true;
                    patternIndex++;

                    if (patternIndex == pattern.length) {
                        remainChars -= pattern.length;
                        patternIndex = 0;
                        foundCycle = true;
                    }
                }
            }

           if (!foundCycle) {
                System.out.println("-1");
                return;
            }
            answer++;
        }

        System.out.println(answer);
    }
}