import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int[] ddx = {2, 2, -2, -2, 1, -1, 1, -1};
    static int[] ddy = {1, -1, 1, -1, 2, 2, -2, -2};
    static int N, M, K;  
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        K = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        if(map[0][0] == 1){
            System.out.println(-1);
            return;
            
        }

        System.out.println(BFS(map));
        
    }

    public static int BFS(int[][] map){
        Queue<int[]> q = new ArrayDeque<>();
        int[][][] answer = new int[N][M][K+1];

        q.offer(new int[]{0, 0, K});
        answer[0][0][K] = 0;
        while (!q.isEmpty()) {
            int[] now = q.poll();

            if(now[0] == N-1 && now[1] == M-1) return answer[now[0]][now[1]][now[2]];
            
            for(int i=0; i<4; i++){
                int x = now[0] + dx[i];
                int y = now[1] + dy[i];
                if(!(x>=0 && x<N && y>=0 && y<M)) continue;

                if(map[x][y] == 0 && answer[x][y][now[2]] == 0){
                    q.offer(new int[]{x, y, now[2]});
                    answer[x][y][now[2]] = answer[now[0]][now[1]][now[2]] + 1;
                }
            }

            if(now[2] == 0) continue;
            
            for(int i=0; i<8; i++){
                int x = now[0] + ddx[i];
                int y = now[1] + ddy[i];
                if(!(x>=0 && x<N && y>=0 && y<M)) continue;

                if(map[x][y] == 0 && answer[x][y][now[2] - 1] == 0){
                    q.offer(new int[]{x, y, now[2] - 1});
                    answer[x][y][now[2] - 1] = answer[now[0]][now[1]][now[2]] + 1;
                }
            }
            
            
        }
        return -1;
        
    }
}