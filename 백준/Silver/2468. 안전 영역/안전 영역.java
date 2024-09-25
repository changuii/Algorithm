import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] map = new int[N][N];

        int max = 0;
        StringTokenizer st;
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                max = Math.max(map[i][j], max);
            }
        }

        int answer = 0;
        int c = 0;
        boolean[][] visit;
        for(int h=0; h<max; h++){
            visit = new boolean[N][N];
            c = 0;
            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    if(!visit[i][j] && map[i][j] > h){
                        BFS(map, visit, i, j, N, h);
                        c++;
                    } 
                }
            }
            answer = Math.max(answer, c);
        }
        System.out.println(answer);
        

    }

    public static void BFS(int[][] map, boolean[][] visit, int X, int Y, int N, int H){
        Queue<int[]> q = new ArrayDeque<>();

        q.offer(new int[]{X, Y});
        visit[X][Y] = true;
        while (!q.isEmpty()) {
            int[] now = q.poll();
            for(int i=0; i<4; i++){
                int x = now[0] + dx[i];
                int y = now[1] + dy[i];
                if(x >=0 && x<N && y>=0 && y<N &&
                  !visit[x][y] && map[x][y] > H){
                    q.offer(new int[]{x, y});
                    visit[x][y] = true;
                  }
            }
        }
        
        
    }
}