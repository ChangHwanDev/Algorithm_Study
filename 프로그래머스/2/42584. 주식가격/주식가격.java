import java.util.*;
class Solution {
    public int[] solution(int[] prices) {
            int n = prices.length;
            int[] answer = new int[n];
            Stack<Integer> stack = new Stack<>();

            for (int i = 0; i < n; i++) {
                while (!stack.isEmpty() && prices[i] < prices[stack.peek()]) {
                    answer[stack.peek()] = i - stack.peek();
                    stack.pop();
                }
                stack.push(i);
            }

            while (stack.size() > 0) {
                answer[stack.peek()] = n - stack.peek() - 1;
                stack.pop();
            }
        return answer;
    }
}