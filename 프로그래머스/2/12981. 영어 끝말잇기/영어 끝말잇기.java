import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = {0, 0};
        Set<String> usedWords = new HashSet<>();
        
        usedWords.add(words[0]);
        
        for (int i = 1; i < words.length; i++) {
            String currentWord = words[i];
            String prevWord = words[i - 1];
            
            char prevLastChar = prevWord.charAt(prevWord.length() - 1);
            char currStartChar = currentWord.charAt(0);
            
            if (prevLastChar != currStartChar || usedWords.contains(currentWord)) {
                answer[0] = (i % n) + 1;
                answer[1] = (i / n) + 1;
                return answer;
            }
          
            usedWords.add(currentWord);
        }

        return answer;
    }
}