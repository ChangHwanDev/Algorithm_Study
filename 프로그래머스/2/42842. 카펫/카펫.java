class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int carpet = brown + yellow;
        
        for (int i = 3; i < carpet; i++) {
            int width = carpet / i;
            
            if (width < 3) {
                continue;
            }
            
            if (width >= i && (width - 2) * (i - 2) == yellow) {
                answer[0] = width;
                answer[1] = i;
                
                break;
            }
        }
        
        return answer;
    }
}