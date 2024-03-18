class Solution {
    public String solution(String X, String Y) {
        int[] xList = new int[10];
        int[] yList = new int[10];
        StringBuilder sb = new StringBuilder();
        for(String xTemp : X.split("")){
            xList[Integer.parseInt(xTemp)]++;
        }
        for(String yTemp : Y.split("")){
            yList[Integer.parseInt(yTemp)]++;
        }
        for(int i=9; i >= 0; i--){
            while(xList[i] > 0 && yList[i] > 0) {
                sb.append(i);
                xList[i]--;
                yList[i]--;
            }
        }
        String answer = sb.toString();
        
        if(answer.length() == 0) return "-1";
        else if(answer.startsWith("0")) return "0";
        else {
           return answer;
        }
    }
}