import java.util.HashSet;
class Solution {
    static boolean[] visited;
    static HashSet<Integer> set;
    
    public int solution(String numbers) {
            int answer = 0;
            set = new HashSet<>();
            visited = new boolean[7];
            dfs(numbers,"", 0);
            for (Integer i : set) {
                if(isPrime(i)) answer++;
            }
        return answer;
    }
    
     public static void dfs(String numbers, String s, int lv){
        if(lv > numbers.length()) return;

        for (int i = 0; i < numbers.length(); i++){
            if(!visited[i]){
                visited[i] = true;
                set.add(Integer.parseInt(s + numbers.charAt(i)));
                dfs(numbers, s + numbers.charAt(i), lv + 1);
                visited[i] = false;
            }
        }
    }

    public static boolean isPrime(int n) {
        if (n <= 1) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}