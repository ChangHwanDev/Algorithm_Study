import java.util.*;
class Solution {
    static ArrayList<String> pass = new ArrayList<>();
    static boolean[] visited;
    
    public String[] solution(String[][] tickets) {
        Arrays.sort(tickets, (a, b) -> {
            if (a[0].equals(b[0])) {
                return a[1].compareTo(b[1]);
            }
            return a[0].compareTo(b[0]);
        });

        visited = new boolean[tickets.length];
        pass.add("ICN");

        dfs(0, "ICN", tickets);

        return pass.toArray(new String[0]);
    }

    public static boolean dfs(int lv, String current, String[][] tickets) {
        if (lv == tickets.length) {
            return true;
        }

        for (int i = 0; i < tickets.length; i++) {
            if (!visited[i] && tickets[i][0].equals(current)) {
                visited[i] = true;
                pass.add(tickets[i][1]);

                if (dfs(lv + 1, tickets[i][1], tickets)) {
                    return true;
                }

                visited[i] = false;
                pass.remove(pass.size() - 1);
            }
        }

        return false;
    }
}