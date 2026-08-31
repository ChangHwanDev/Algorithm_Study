import java.util.*;

class Solution {
    
    static int cacheMissCount = 5;
    
    public int solution(int cacheSize, String[] cities) {
        if (cacheSize == 0) {
            return cities.length * 5;
        }
        
        int answer = 0;
        LinkedList<String> cache = new LinkedList<>();

        for (String city : cities) {
            String target = city.toLowerCase();

            if (cache.contains(target)) {
                cache.remove(target);
                cache.add(target);
                answer ++;
            } else {
                answer += cacheMissCount;
                if (cache.size() >= cacheSize) {
                    cache.poll();
                }
                cache.add(target);
            }
        }
        return answer;
    }
}