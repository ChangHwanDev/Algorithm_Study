import java.util.HashMap;
class Solution {
    public String[] solution(String[] players, String[] calling) {
       HashMap<String, Integer> playerMap = new HashMap<>();
        for(int i = 0; i< players.length; i++){
            playerMap.put(players[i], i);
        }

        for(int i = 0; i< calling.length; i++){
            int rank = playerMap.get(calling[i]);
            String callingPlayer = calling[i];
            String frontPlayer = players[rank -1];
            
            playerMap.replace(frontPlayer, rank);
            players[rank] = frontPlayer;
           
            playerMap.replace(callingPlayer, rank - 1);
            players[rank -1] = callingPlayer;
        }
        return players;
        
    }
}