class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        
        int idx = 0;
        for (int num : nums) {
            int pastIdx = map.getOrDefault(num, -1);
            if (pastIdx == -1) {
                map.put(num, idx);
            } else if (Math.abs(pastIdx - idx) <= k) {
                return true;
            } else {
                map.put(num, idx);
            }

            idx++;
        }

        return false;
    }
}