class Solution {
    static int count;
    public int solution(int[] numbers, int target) {
        count = 0;
        dfs(0, 0, numbers, target);
        
        return count;
    }
    
    public void dfs(int depth, int sum, int[] nums, int target) {
        if (depth == nums.length) {
            if (sum == target) {
                count++;
                return;
            }
        } else {
                dfs(depth + 1, sum + nums[depth], nums, target);
                dfs(depth + 1, sum - nums[depth], nums, target);
        }
    }
}