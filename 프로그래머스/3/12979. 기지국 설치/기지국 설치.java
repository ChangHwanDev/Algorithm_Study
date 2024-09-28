class Solution {
    public int solution(int n, int[] stations, int w) {
            int answer = 0;
            int stationIdx = 0;
            int current = 1;

            while (current <= n) {
                if (stationIdx < stations.length && stations[stationIdx] - w <= current) {
                    current = stations[stationIdx] + w + 1;
                    stationIdx++;
                } else {
                    answer++;
                    current += w * 2 + 1;
                }
            }
        return answer;
    }
}