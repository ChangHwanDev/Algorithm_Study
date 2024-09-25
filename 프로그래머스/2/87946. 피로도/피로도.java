class Solution {
        static boolean[] visited;
        static int answer;
    public int solution(int k, int[][] dungeons) {
            answer = 0;
            visited = new boolean[dungeons.length];

            dfs(k, dungeons, 0);
        return answer;
    }
    
    public static void dfs(int score, int[][] dungeons, int level){
            answer = Math.max(answer, level);

            for (int j = 0; j < dungeons.length; j++) {
                if (!visited[j]) {
                    if (dungeons[j][0] <= score) {
                        visited[j] = true;
                        dfs(score - dungeons[j][1], dungeons, level + 1);
                        visited[j] = false;
                    }
                }
            }
        }
}