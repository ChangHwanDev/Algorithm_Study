import java.util.*;
class Solution {
    
    static class Node{
        String word;
        int count;

        public Node(String word, int count) {
            this.word = word;
            this.count = count;
        }
    }
    
    public int solution(String begin, String target, String[] words) {
        return BFS(begin, target, words);
    }
    
    public int BFS(String begin, String target, String[] words) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(begin, 0));
        boolean[] visited = new boolean[words.length];

        while(!queue.isEmpty()){
            Node currentNode = queue.poll();
            String currentWord = currentNode.word;
            int count = currentNode.count;

            if(currentWord.equals(target)){
                return count;
            }

            for(int i = 0; i < words.length; i++){
                if(!visited[i] && isOneCharDifference(currentWord, words[i])){
                    visited[i] = true;
                    queue.offer(new Node(words[i], count + 1));
                }
            }
        }

        return 0;
    }

    public boolean isOneCharDifference(String word1, String word2){
        int count = 0;
        for(int i = 0; i < word1.length(); i++){
            if(word1.charAt(i) != word2.charAt(i)){
                count++;
            }
        }
        return count == 1;
    }
}