import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Players implements Comparable<Players> {
        int level;
        String name;

        public Players(int level, String name) {
            this.level = level;
            this.name = name;
        }

        @Override
        public int compareTo(Players p) {
            return this.name.compareTo(p.name);
        }
    }

    static class Rooms {
        int baseLevel;
        List<Players> players = new ArrayList<>();

        public Rooms(int baseLevel) {
            this.baseLevel = baseLevel;
        }

        public boolean canEnter(int level) {
            return baseLevel - 10 <= level && level <= baseLevel + 10;
        }

        public boolean isFull(int limit) {
            return players.size() == limit;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int p = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<Rooms> rooms = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < p; i++) {
            st = new StringTokenizer(br.readLine());
            int level = Integer.parseInt(st.nextToken());
            String name = st.nextToken();

            Players player = new Players(level, name);
            boolean hasRoom = false;

            for (Rooms room : rooms) {
                if (!room.isFull(m) && room.canEnter(level)) {
                    room.players.add(player);
                    hasRoom = true;
                    break;
                }
            }

            if (!hasRoom) {
                Rooms room = new Rooms(level);
                room.players.add(player);

                rooms.add(room);
            }
        }

        for (Rooms room : rooms) {
            if (room.isFull(m)) {
                sb.append("Started!\n");
            } else {
                sb.append("Waiting!\n");
            }

            Collections.sort(room.players);
            for (Players player : room.players) {
                sb.append(player.level).append(" ").append(player.name).append("\n");
            }
        }

        System.out.println(sb.toString());
    }
}