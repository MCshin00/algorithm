import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        
        Map<String, Integer> rankings = new HashMap<>();
        
        for (int i=0; i<players.length; i++) {
            rankings.put(players[i], i);
        }
        
        for (int i=0; i<callings.length; i++) {
            String currentPlayer = callings[i];
            int currentPlayerRank = rankings.get(currentPlayer);
            String frontPlayer = players[currentPlayerRank - 1];
            
            rankings.replace(frontPlayer, currentPlayerRank);
            players[currentPlayerRank] = frontPlayer;
            
            rankings.replace(currentPlayer, currentPlayerRank-1);
            players[currentPlayerRank-1] = currentPlayer;
        }
            
        return players;
    }
}