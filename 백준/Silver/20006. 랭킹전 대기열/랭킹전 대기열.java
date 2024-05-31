import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<Room> rooms = new ArrayList<>();
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            Player p = new Player(Integer.parseInt(st.nextToken()), st.nextToken());
            boolean isRoom = false;
            for(int j=0; j<rooms.size();j++){
                Room r = rooms.get(j);
                if(p.value >= r.min && p.value <= r.max && !r.state){
                    r.players.add(p);
                    if(r.players.size() == M) r.state = true;
                    isRoom = true;
                    break;
                }
            }
            if(!isRoom){
                Room r = new Room(p.value-10, p.value+10);
                r.players.add(p);
                if(r.players.size() == M) r.state = true;
                rooms.add(r);
            }
        }
        StringBuilder sb = new StringBuilder();
        for(Room r : rooms){
            List<Player> players = r.players;
            Collections.sort(players, (o1, o2)->o1.name.compareTo(o2.name));
            sb.append(r.state ? "Started!" : "Waiting!").append("\n");
            for(Player p : players){
                 sb.append(p.value +" " + p.name).append("\n");   
            }
        }
        
        System.out.println(sb);
    }

    static class Room{
        int min;
        int max;
        boolean state;
        List<Player> players;
        public Room(int min, int max){
            this.min=min;
            this.max=max;
            this.state=false;
            this.players = new ArrayList<>();
        }
        
    }

    static class Player{
        String name;
        int value;
        public Player(int value, String name){
            this.value=value;
            this.name=name;
        }
    }
}