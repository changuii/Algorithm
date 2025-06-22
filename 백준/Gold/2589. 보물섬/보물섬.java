import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int max = 0;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];
        for(int i=0; i<N; i++){
            char[] v = br.readLine().toCharArray();
            for(int j=0; j<M; j++){
                map[i][j] = v[j] == 'W' ? 0 : 1;
            }
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(map[i][j] == 0) continue;

                bfs(map, i, j, N, M);
            }
        }
        
        System.out.println(max);
    }

    public static void bfs(int[][] map, int x, int y, int N, int M){
        Deque<int[]> q = new ArrayDeque<>();

        boolean[][] visit = new boolean[N][M];
        q.addFirst(new int[]{x, y, 0});
        visit[x][y] = true;

        while(!q.isEmpty()){
            int[] now = q.poll();

            for(int i=0; i<4; i++){
                int X = now[0] + dx[i];
                int Y = now[1] + dy[i];

                if((X < 0 || X >= N || Y < 0 || Y >= M)) continue;

                if(visit[X][Y] || map[X][Y] == 0) continue;

                visit[X][Y] = true;
                q.addLast(new int[]{X, Y, now[2] + 1});
            }

            max = Math.max(max, now[2]);
        }
        
    }
}