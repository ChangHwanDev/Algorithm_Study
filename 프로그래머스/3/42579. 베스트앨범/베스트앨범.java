import java.util.*;

class Solution {
 static class Music implements Comparable<Music> {
        int index;
        int plays;

        public Music(int index, int plays) {
            this.index = index;
            this.plays = plays;
        }

        @Override
        public int compareTo(Music o) {
            if (this.plays == o.plays) return this.index - o.index;
            else return o.plays - this.plays;
        }
    }
    public int[] solution(String[] genres, int[] plays) {
            HashMap<String, Integer> map = new HashMap<>();

            for (int i = 0; i < genres.length; i++) {
                map.put(genres[i], map.getOrDefault(genres[i], 0) + plays[i]);
            }

            ArrayList<String> mapToGenres = new ArrayList<>(map.keySet());
            mapToGenres.sort((o1, o2) -> map.get(o2) - map.get(o1));
            ArrayList<Integer> answer = new ArrayList<>();
            for (String genre : mapToGenres) {
                ArrayList<Music> musics = new ArrayList<>();
                for (int i = 0; i < genres.length; i++) {
                    if (genre.equals(genres[i])) {
                        musics.add(new Music(i, plays[i]));
                    }
                }

                Collections.sort(musics);

                answer.add(musics.get(0).index);
                if (musics.size() > 1) answer.add(musics.get(1).index);
            }
        return answer.stream().mapToInt(i -> i).toArray();
    }
}