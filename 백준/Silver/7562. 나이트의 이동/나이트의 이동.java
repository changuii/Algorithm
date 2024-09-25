import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    // 
    static int[] dx = {2, 2, -2, -2, 1, -1, 1, -1};
    static int[] dy = {1, -1, 1, -1, 2, 2, -2, -2};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        for(int t=0; t<T; t++){

            int N = Integer.parseInt(br.readLine());
            
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            int[][] map = new int[N][N];
            BFS(map, N, x1, y1, x2, y2);

            sb.append(map[x2][y2]).append("\n");
        }
        System.out.println(sb);
        

        
    }

    public static void BFS(int[][] map, int N, int x1, int y1, int x2, int y2){
        Queue<int[]> q = new ArrayDeque<>();

        boolean[][] visit = new boolean[N][N];
        q.offer(new int[]{x1, y1});
        visit[x1][y1] = true;
        while (!q.isEmpty()) {
            int[] now = q.poll();
            if(now[0] == x2 && now[1] == y2) return;
            for(int i=0; i<8; i++){
                int x = now[0] + dx[i];
                int y = now[1] + dy[i];
                if(x >=0 && x<N && y>=0 && y<N &&
                  !visit[x][y]){
                    visit[x][y] = true;
                    q.offer(new int[]{x, y});
                    map[x][y] = map[now[0]][now[1]] + 1;
                }
            }
            
        }
        
        
    }
}