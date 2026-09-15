class Solution {
    public int maxArea(int[] height) {
        int N = height.length;
        if (N < 2) {
            return N;
        }

        int answer = 0;
        int right = N - 1;
        int left = 0;
        while (left < right) {
            int weight = right - left;
            int currentLeft = height[left];
            int currentRight = height[right];
            int maxHeight = Math.min(currentLeft, currentRight);
            answer = Math.max(answer, weight * maxHeight);

            if (currentLeft > currentRight) {
                right--;
            } else {
                left++;
            }
        }

        return answer;
    }
}