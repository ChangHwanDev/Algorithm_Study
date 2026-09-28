class Solution {
    public int maxProfit(int[] prices) {
        int min = 100000;
        int sum = 0;

        for (int i = 1; i < prices.length; i++) {
            min = Math.min(prices[i - 1], min);
            sum = Math.max(sum, prices[i] - min);
        }

        return sum;
    }
}