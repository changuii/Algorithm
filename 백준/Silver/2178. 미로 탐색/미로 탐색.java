import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int[] dx=  {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N+1][M+1];
        for(int i=1; i<=N; i++) {
            char[] val = br.readLine().toCharArray();

            for(int j=1; j<=M; j++) {
                map[i][j] = val[j-1] - '0';
            }
        }

        bfs(map, N, M);
    }

    public static void bfs(int[][] map, int N, int M) {
        Deque<int[]> q = new ArrayDeque<>();

        boolean[][] visit = new boolean[map.length][map[0].length];

        visit[1][1] = true;
        q.addLast(new int[]{1, 1, 1});
        while (!q.isEmpty()) {
            int[] now = q.pollFirst();

            if(now[0] == N && now[1] == M) {
                System.out.println(now[2]);
                return;
            }

            for(int i=0; i<4; i++) {
                int x = now[0] + dx[i];
                int y = now[1] + dy[i];

                if(!(x>0 && x <map.length && y>0 && y <map[0].length)) continue;
                if(map[x][y] == 0 || visit[x][y]) continue;
                
                visit[x][y] = true;
                q.addLast(new int[]{x, y, now[2] + 1});
            }

                
        }
        
    }
}