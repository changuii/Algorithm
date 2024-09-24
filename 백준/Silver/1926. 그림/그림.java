import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static int max = 0;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static boolean[][] visit;
    static int c = 0;
    static int N, M;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];
        visit = new boolean[N][M];
        
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(map[i][j] != 0 && !visit[i][j]){
                    c++;
                    BFS(map, i, j);
                }
            }
        }

        
        System.out.println(c);
        System.out.println(max);
        
    }

    public static void BFS(int[][] map, int X, int Y){
        Queue<int[]> q = new ArrayDeque<>();
        

        int size = 0;
        q.add(new int[]{X, Y});
        visit[X][Y] = true;
        while (!q.isEmpty()) {
            int[] now = q.poll();
            size++;
            for(int i=0; i<4; i++){
                int x = now[0] + dx[i];
                int y = now[1] + dy[i];
                if(x >=0 && x<N && y>=0 && y<M &&
                  !visit[x][y] && map[x][y] != 0){
                    visit[x][y] = true;
                    q.offer(new int[]{x, y});
                  }
            }
        }
        max = Math.max(max, size);
    }
}