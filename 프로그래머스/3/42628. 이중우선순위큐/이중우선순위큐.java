import java.util.*;
class Solution {
    public int[] solution(String[] operations) {
            TreeMap<Integer, Integer> map = new TreeMap<>((o1, o2) -> o1 - o2);

            for (String operation : operations) {
                String[] s = operation.split(" ");
                String command = s[0];
                int num = Integer.parseInt(s[1]);

                if (command.equals("I")) {
                    map.put(num, map.getOrDefault(num, 0) + 1);
                } else if (command.equals("D")) {
                    if(map.isEmpty()) continue;
                    if (num == 1) {
                        int key = map.lastKey();
                        if (map.get(key) == 1){
                            map.remove(key);
                        } else if (map.get(key) > 1){
                            map.put(key, map.get(key) - 1);
                        }
                    }
                    else if (num == -1) {
                        int key = map.firstKey();
                        if (map.get(key) == 1){
                            map.remove(key);
                        } else if (map.get(key) > 1){
                            map.put(key, map.get(key) - 1);
                        }
                    }
                }
            }
            int min = 0;
            int max = 0;
            if(!map.isEmpty()) {
                min = map.firstKey();
                map.remove(min);
                max = min;
            }
            if(!map.isEmpty()) {
                max = map.lastKey();
            }
            return new int[]{max, min};
    }
}