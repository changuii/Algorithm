import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] A = new int[N][M];
        Set<Node> set = new HashSet<>();
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                A[i][j] = Integer.parseInt(st.nextToken());
                if(A[i][j] > 0){
                    set.add(new Node(i, j));
                }
            }
        }

        int day = 0;
        
        while (set.size() > 0) {
            int c = 0;
            boolean[][] visit = new boolean[N][M];

            ArrayList<Node> l = new ArrayList<>();
            day++;
            for(Node n : set){
                if(oper(A, n.x, n.y, set)){
                    l.add(new Node(n.x, n.y));
                }
            }
            for(Node n : l){
                set.remove(n);
            }            

            for(Node n : set){
                if(!visit[n.x][n.y]){
                    BFS(A, n.x, n.y, visit);
                    c++;
                }
                if(c >= 2){
                    System.out.println(day);
                    return;
                }
            }
            
        }

        System.out.println(0);
    }

    public static void BFS(int[][] A, int X, int Y, boolean[][] visit){
        Queue<Node> q = new ArrayDeque<>();

        q.offer(new Node(X, Y));
        visit[X][Y] = true;
        while (!q.isEmpty()) {
            Node now = q.poll();
            for(int i=0; i<4; i++){
                int x = now.x + dx[i];
                int y = now.y + dy[i];
                
                if(!(x >=0 && x<A.length && y>=0 && y<A[0].length)) continue;

                if(A[x][y] > 0 && !visit[x][y]){
                    q.offer(new Node(x, y));
                    visit[x][y] = true;
                }
            }
        }
    }

    public static boolean oper(int[][] A, int x, int y, Set<Node> set){
        for(int i=0; i<4; i++){
            int X = x + dx[i];
            int Y = y + dy[i];

            if(!(X >=0 && X<A.length && Y>=0 && Y<A[0].length)) continue;

            if(A[X][Y] == 0 && !set.contains(new Node(X, Y))){
                A[x][y]--;
                if(A[x][y] == 0){
                    return true;
                }
            }
        }
        return false;
        
    }
    

    static class Node{
        int x;
        int y;
        public Node(int x, int y){
            this.x=x;
            this.y=y;
        }
        
        @Override
        public boolean equals(Object no){
            Node n = (Node) no;
            return (n.x == this.x && n.y == this.y);
        }

        @Override
        public int hashCode(){
            return x+y;
        }
        
        public String toString(){
            return "["+this.x + " " + this.y +"]";
        }
    }
}