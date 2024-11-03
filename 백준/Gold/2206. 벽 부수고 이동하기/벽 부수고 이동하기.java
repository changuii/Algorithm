import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];

        for(int i=0; i<N; i++){
            char[] val = br.readLine().toCharArray();
            for(int j=0; j<M; j++){
                map[i][j] = val[j] - '0';
            }
        }

        int result = BFS(map, N, M);
        System.out.println(result);
    }

    public static int BFS(int[][] map, int N, int M){
        Queue<int[]> q = new ArrayDeque<>();

        boolean[][][] visit = new boolean[N][M][2];

        q.offer(new int[]{0, 0, 0, 1});
        visit[0][0][0] = true;
        while (!q.isEmpty()) {
            int[] now = q.poll();

            if(now[0] == N-1 && now[1] == M-1) return now[3];
            
            for(int i=0; i<4; i++){
                int x = now[0] + dx[i];
                int y = now[1] + dy[i];

                if(!(x >=0 && x<N && y>=0 && y<M)) continue;

                if(!visit[x][y][now[2]] && map[x][y] == 0){
                    visit[x][y][now[2]] = true;
                    q.offer(new int[]{x, y, now[2], now[3] + 1});
                }
                if(now[2] == 0 && map[x][y] == 1 && !visit[x][y][1]){
                    visit[x][y][1] = true;
                    q.offer(new int[]{x, y, 1, now[3] + 1});
                }
                
            }
            
        }
        return -1;
        
    }
}