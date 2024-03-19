class Solution {
    public int[] solution(String[] park, String[] routes) {
               int height = park.length;
        int weight = park[0].length();
        int startX = 0;
        int startY = 0;

        for (int i = 0; i < park.length; i++) {
            if (park[i].indexOf('S') != -1) {
                startX = park[i].indexOf('S');
                startY = i;
            }
        }

        for (int i = 0; i < routes.length; i++) {
            String[] s = routes[i].split(" ");
            String vector = s[0];
            int distance = Integer.parseInt(s[1]);
            int currX = startX;
            int currY = startY;
            boolean flag = true;

            if (vector.equals("N")) {
                for (int j = 0; j < distance; j++) {
                    currY--;
                    if (currY < 0 || park[currY].charAt(currX) == 'X') {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    startY = currY;
                }
            } else if (vector.equals("S")) {
                for (int j = 0; j < distance; j++) {
                    currY++;
                    if (currY >= height || park[currY].charAt(currX) == 'X') {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    startY = currY;
                }
            } else if (vector.equals("W")) {
                for (int j = 0; j < distance; j++) {
                    currX--;
                    if (currX < 0 || park[currY].charAt(currX) == 'X') {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    startX = currX;
                }
            } else if (vector.equals("E")) {
                for (int j = 0; j < distance; j++) {
                    currX++;
                    if (currX >= weight || park[startY].charAt(currX) == 'X') {
                        flag = false;
                        break;
                    }

                }
                if (flag) {
                    startX = currX;
                }
            }
        }
       return new int[]{startY, startX};
    }
}