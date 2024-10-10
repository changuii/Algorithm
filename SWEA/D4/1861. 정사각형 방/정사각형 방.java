import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Solution {
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        for(int t=1; t<=T; t++){
            int N = Integer.parseInt(br.readLine());


            int[][] map = new int[N][N];

            for(int i=0; i<N; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<N; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int[] min = {0, 0};
            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    int now = BFS(map, i, j);
                    if(now == min[1] && map[i][j] < min[0]){
                        min[0] = map[i][j];
                        min[1] = now;
                    }
                    else if(now > min[1]){
                        min[0] = map[i][j];
                        min[1] = now;
                    }
                }
            }
            
        
            sb.append(String.format("#%d %d %d\n", t, min[0], min[1]));
            
        }
        System.out.println(sb);
    }

    public static int BFS(int[][] map, int X, int Y){
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{X, Y, 1});
        
        int c = 0;
        while (!q.isEmpty()) {
            int[] now = q.poll();
            c= now[2];
            for(int i=0; i<4; i++){
                int x = now[0] + dx[i];
                int y = now[1] + dy[i];

                if(!(x >= 0 && x<map.length && y>=0 && y<map.length)) continue;

                if(map[now[0]][now[1]] + 1 == map[x][y]){
                    q.offer(new int[]{x, y, now[2] + 1});
                }
            }
            
        }
        return c;
    }
}