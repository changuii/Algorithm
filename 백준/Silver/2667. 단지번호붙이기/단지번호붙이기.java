import java.util.*;
import java.io.*;

public class Main {
    static int[][] A;
    static boolean[][] V;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static List<Integer> answer = new ArrayList<>();
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine())+2;
        A = new int[N][N];
        V = new boolean[N][N];
        N--;
        
        for(int i=1; i<N; i++){
            String value = br.readLine();
            for(int j=1; j<N; j++){
                A[i][j] = Integer.parseInt(value.charAt(j-1)+"");
            }
        }

        for(int i=1; i<N; i++){
            for(int j=1; j<N; j++){
                if(A[i][j] == 1 && !V[i][j]) {
                    BFS(new Node(i, j));
                }
            }
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append(answer.size()).append("\n");
        answer.sort((o1, o2) -> o1 - o2);
        for(int i=0; i<answer.size(); i++){
            sb.append(answer.get(i)).append("\n");
        }
        System.out.print(sb);
        
    }
    static void BFS(Node now){
        Queue<Node> q = new LinkedList<>();

        int count = 1;
        q.add(now);
        V[now.x][now.y] = true;
        while (!q.isEmpty()){
            Node value = q.poll();
            for(int i=0; i<4; i++){
                int x = value.x + dx[i];
                int y = value.y + dy[i];
                if(!V[x][y] && A[x][y] == 1){
                    q.add(new Node(x, y));
                    count++;
                    V[x][y] = true;
                }
            }
        }
        answer.add(count);

    }


    static class Node{
        int x;
        int y;

        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }

        public boolean checkLocation(){
            if(this.x == 0 || this.y == 0 || this.x == N-1 || this.y == N-1) return true;
            return false;
        }
    }

}