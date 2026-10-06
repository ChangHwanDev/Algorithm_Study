class Solution {
    public boolean canJump(int[] nums) {
        if (nums.length == 1) return true;
        if (nums[0] == 0) return false;
        
        boolean answer = false;
        int lastIndex = nums.length - 1;
        
        int maxJump = 0;
        for (int i = 0; i < lastIndex; i++) {
            maxJump = Math.max(nums[i], maxJump);

            if (maxJump + i >=  lastIndex) {
                answer = true;
                break;
            }

            if (maxJump == 0) return false;

            maxJump--;
        }


        return answer;
    }
}