import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int N, M, K;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];
        for(int i=0; i<N; i++){
            char[] val = br.readLine().toCharArray();
            for(int j=0; j<M; j++){
                map[i][j] = val[j] - '0';
            }
        }

        System.out.println(BFS(map));
        
        
        
    }
    public static int BFS(int[][] map){
        Queue<int[]> q = new ArrayDeque<>();

        // 0은 아침, 1은 저녁
        // 벽은 아침일 때만 부술 수 있음
        // 대기하는 경우도 있음
        int[][][] answer = new int[N][M][K+1];
        q.offer(new int[]{0, 0, K, 0, 1});
        answer[0][0][K] = 1;
        while (!q.isEmpty()) {
            int[] now = q.poll();

            if(now[0] == N-1 && now[1] == M-1){
                // for(int k=K; k>=0 ; k--){
                //     for(int i=0; i<N; i++){
                //         for(int j=0; j<M; j++){
                //             System.out.print(answer[i][j][k] + " ");
                //         }
                //         System.out.println();
                //     }
                //     System.out.println();
                // }
                return now[4];
            }
                
            for(int i=0; i<4; i++){
                int x = now[0] + dx[i];
                int y = now[1] + dy[i];

                if(!(x >=0 && x<N && y>=0 && y<M)) continue;

                if(map[x][y] == 0 && answer[x][y][now[2]] == 0){
                    answer[x][y][now[2]] = now[4] + 1;
                    q.offer(new int[]{x, y, now[2], (now[3] + 1) % 2, now[4]+1 });
                }
            }

            if(now[2] == 0) continue;
            
            if(now[3] == 1)
                q.offer(new int[]{now[0], now[1], now[2], 0, now[4] + 1});

            if(now[3] == 1) continue;
            
            for(int i=0; i<4; i++){
                int x = now[0] + dx[i];
                int y = now[1] + dy[i];

                if(!(x >=0 && x<N && y>=0 && y<M)) continue;

                if(map[x][y] == 1 && answer[x][y][now[2]-1] == 0){
                    answer[x][y][now[2]-1] = now[4] + 1;
                    q.offer(new int[]{x, y, now[2]-1, 1, now[4] + 1});
                }
            }
            
            
        }


        return -1;
        
    }
}