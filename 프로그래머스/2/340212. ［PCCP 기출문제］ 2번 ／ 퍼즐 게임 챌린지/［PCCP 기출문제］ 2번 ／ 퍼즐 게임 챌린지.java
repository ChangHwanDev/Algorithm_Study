class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
            int low = 1;
            int high = Integer.MIN_VALUE;

            for (int diff : diffs) {
                if (diff > high) high = diff;
            }
            int answer = 0;
            while (low <= high){
                int mid = (low + high) / 2;
                long totalTime = 0;
                for (int i = 0; i < times.length; i++) {
                    if(mid >= diffs[i]) totalTime += times[i];
                    else {
                        long penalty = (long) (diffs[i] - mid) * (times[i] + (i > 0 ? times[i - 1] : 0));
                        totalTime += penalty + times[i];
                    }
                }

                if (totalTime > limit) {
                    low = mid + 1;
                }
                else {
                    answer = mid;
                    high = mid - 1;
                }
            }
        return answer;
    }
}