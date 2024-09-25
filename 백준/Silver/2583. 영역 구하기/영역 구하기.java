import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];
        
        for(int i=0; i<K; i++){
            st = new StringTokenizer(br.readLine());

            int y1 = Integer.parseInt(st.nextToken());
            int x1 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            // 0, 2 -> 4, 4
            // 
            
            // System.out.println(x1 + " " + y1 + " " + x2 + " " + y2);
            for(int k=x1; k<x2; k++){
                for(int j=y1; j<y2; j++){
                    // System.out.println(k + " " + j);
                    map[k][j] = 1;
                }
            }
        }

        ArrayList<Integer> answer = new ArrayList<>();
        for(int i=0; i<N;i++){
            for(int j=0; j<M; j++){
                if(map[i][j] == 0){
                    answer.add(BFS(map, i, j, N, M));
                }
            }
        }

        Collections.sort(answer);
        
        StringBuilder sb = new StringBuilder();
        sb.append(answer.size()).append("\n");
        for(int x : answer){
            sb.append(x).append(" ");
        }
        System.out.println(sb);
    }

    public static int BFS(int[][] map, int X, int Y, int N, int M){
        Queue<int[]> q = new ArrayDeque<>();

        int c = 0;
        q.offer(new int[]{X, Y});
        map[X][Y] = 2;
        while (!q.isEmpty()) {
            int[] now = q.poll();
            c++;
            for(int i=0; i<4; i++){
                int x = now[0] + dx[i];
                int y = now[1] + dy[i];
                if(x >= 0 && x<N && y>=0 && y<M &&
                  map[x][y] == 0){
                    q.offer(new int[]{x, y});
                    map[x][y] = 2;
                  }
            }
        }

        return c;
        
    }
}