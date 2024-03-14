// 빵은 1
// 야채 2
// 고기 3
// 1 2 3 1 이 되어야함
import java.util.Stack;
class Solution {
    public int solution(int[] ingredient) {
        int answer = solve(ingredient);

        return answer;
    }
    
    public int solve(int[] ingredient){
        Stack<Integer> stack = new Stack<>();
        int temp = 0;
        for(int i : ingredient){
            stack.push(i);
            if(stack.size() >= 4){
                if(isHamburger(stack)){
                               temp++;
                                stack.pop();
                                stack.pop();
                                stack.pop();
                                stack.pop();
                }
            }
        }
        return temp;
    }
    
    public boolean isHamburger(Stack<Integer> stack){
         int size = stack.size();
       return stack.get(size - 1)   == 1 && stack.get(size - 2) == 3 && stack.get(size - 3) == 2 && stack.get(size - 4) == 1;
    }
}