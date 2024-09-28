import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static int N, M;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int c = 1;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());


        int[][] map = new int[N][N];
        map[0][0] = 1;
        Map<Node, ArrayList<Node>> swi = new HashMap<>();
        
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken())-1;
            int b = Integer.parseInt(st.nextToken())-1;
            int c = Integer.parseInt(st.nextToken())-1;
            int d = Integer.parseInt(st.nextToken())-1;

            
            Node temp = new Node(a, b);
            ArrayList<Node> list = swi.getOrDefault(temp, new ArrayList<>());

            // System.out.println(temp + " -> " + c + "," + d);
            list.add(new Node(c, d));
            swi.put(temp, list);
        }
        BFS(swi, map);
        System.out.println(c);


        
    }


    public static void BFS(final Map<Node, ArrayList<Node>> swi, int[][] map){
        PriorityQueue<Node> q = new PriorityQueue<>((o1, o2) ->{
            if(swi.containsKey(o1)) return -1;
            else if(swi.containsKey(o2)) return 1;
            else return 0;
            
        });

        boolean[][] visit = new boolean[N][N];
        visit[0][0] = true;
        q.offer(new Node(0, 0));
        while (!q.isEmpty()) {
            Node now = q.poll();
            
            // System.out.println(now);
            if(map[now.x][now.y] == 0) continue;
            
            if(swi.containsKey(now)){
                for(Node on : swi.get(now)){
                    // System.out.println(now + " -> " + on);
                    if(map[on.x][on.y] == 0){
                        c++;
                        if(visit[on.x][on.y]) q.offer(on);
                    }
                    map[on.x][on.y] = 1;
                }
                swi.remove(now);
            }
            
            for(int i=0; i<4; i++){
                int x = now.x + dx[i];
                int y = now.y + dy[i];
                if(!(x>=0 && x<N && y>=0 && y<N)) continue;

                if(!visit[x][y]){
                    q.offer(new Node(x, y));
                    visit[x][y] = true;
                }
            }
        }
    }

    

    public static class Node{
        int x;
        int y;

        public Node(int x, int y){
            this.x=x;
            this.y=y;
        }

        public String toString(){
            return "[ " + this.x + "," + this.y  +" ]";
        }

        public boolean equals(Object o){
            Node n = (Node) o;
            return this.x==n.x && this.y==n.y;
        }

        public int hashCode(){
            return x + y;
        }
    }
}