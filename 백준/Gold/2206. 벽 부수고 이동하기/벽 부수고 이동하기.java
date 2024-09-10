import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static int[][] map;
    static int[][][] visit;
    static int N;
    static int M;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visit = new int[N][M][2];
        for(int i=0; i<N; i++){
            char[] val = br.readLine().toCharArray();
            for(int j=0; j<M; j++){
                map[i][j] = val[j] - '0';
            }
        }

        BFS(0, 0);
        System.out.println(min == Integer.MAX_VALUE ? -1 : min);
        
    }

    public static void BFS(int x, int y){
        Queue<int[]> q = new ArrayDeque<>();

        q.add(new int[]{x, y, 0});
        visit[x][y][0] = 1;
        while(!q.isEmpty()){
            int[] now = q.poll();
            if(now[0] == N-1 && now[1] == M-1){
                min = Math.min(min, visit[now[0]][now[1]][now[2]]);
            }
            for(int i=0; i<4; i++){
                int valueX = dx[i] + now[0];
                int valueY = dy[i] + now[1];
                if(valueX >= 0 && valueX < N && valueY >= 0 && valueY <M
                    && map[valueX][valueY] == 0 ){
                    if(visit[valueX][valueY][now[2]] == 0){
                        visit[valueX][valueY][now[2]] = visit[now[0]][now[1]][now[2]] + 1;
                        q.add(new int[]{valueX, valueY, now[2]});
                    }
                }
                else if(valueX >= 0 && valueX < N && valueY >= 0 && valueY < M
                  && map[valueX][valueY] == 1 && now[2] == 0){
                    visit[valueX][valueY][1] = visit[now[0]][now[1]][0] + 1;
                    q.add(new int[]{valueX, valueY, 1});
                }
            }
        }

        
    }
}