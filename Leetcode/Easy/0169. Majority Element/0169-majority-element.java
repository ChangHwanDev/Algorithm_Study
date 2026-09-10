class Solution {
    public int majorityElement(int[] nums) {
        int numberBar = nums.length / 2;
        Map<Integer, Integer> map = new HashMap<>();

        for (int n : nums) {
            int count = map.getOrDefault(n, 0);
            map.put(n, ++count);

            if (count > numberBar) return n;
        }

        return 0;
    }
}