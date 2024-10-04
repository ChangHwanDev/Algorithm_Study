class Solution {
    public String solution(int n) {
            String[] numbers = {"4", "1", "2"};
            StringBuilder sb = new StringBuilder();

            while (n > 0) {
                int remainder = n % 3;
                sb.append(numbers[remainder]);
                n = (n - 1) / 3;
            }
            return sb.reverse().toString();
    }
}