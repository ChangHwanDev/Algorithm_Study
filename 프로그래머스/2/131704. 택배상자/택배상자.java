import java.util.Stack;
class Solution {
    public int solution(int[] order) {
           int answer = 0;
           Stack<Integer> stack = new Stack<>();
            int idx = 0;
            int curBox = 1;
           
            while (idx < order.length){
               if (order[idx] == curBox){
                 answer++;
                 curBox++;
                 idx++;
               } else if (curBox < order[idx]) {
                    stack.push(curBox++);
               } else {
                   while (!stack.isEmpty() && stack.peek() == order[idx]) {
                       stack.pop();
                       answer++;
                       idx++;
                   }
                   if (idx >= order.length || order[idx] < curBox) break;
               }
            }
            return answer;
    }
}