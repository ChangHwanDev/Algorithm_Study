import java.util.*;
class Solution {
    public int[] solution(int[] numbers) {
            int n = numbers.length;
            int[] answer = new int[n];
            Stack<Integer> stack = new Stack<>();

            for (int i = 0; i < n; i++) {
                while (!stack.isEmpty() && numbers[i] > numbers[stack.peek()]) {
                    answer[stack.peek()] = numbers[i];
                    stack.pop();
                }

                stack.push(i);
            }

            while (!stack.isEmpty()) {
                answer[stack.peek()] = -1;
                stack.pop();
            }
        return answer;
    }
}