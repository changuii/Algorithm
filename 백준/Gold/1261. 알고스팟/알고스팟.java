import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
public class Main {
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static int min = Integer.MAX_VALUE;
    static int N, M;
    static boolean[][] visit;
    public static void main(String[] args) throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());;

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][M];
        visit = new boolean[N][M];

        for(int i=0; i<N; i++){
            String[] val = br.readLine().split("");
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(val[j]);
            }
        }
        
        System.out.println(BFS(map));
        
    }

    public static int BFS(int[][] map){
        PriorityQueue<int[]> q = new PriorityQueue<>((o1, o2) ->{
           return o1[2] - o2[2]; 
        });

        q.offer(new int[]{0, 0, 0});
        while(!q.isEmpty()){
            int[] now = q.poll();
            if(now[0] == N-1 && now[1] == M-1) return now[2];

            for(int i=0; i<4; i++){
                int x = now[0] + dx[i];
                int y = now[1] + dy[i];

                if(x >=0 && x<N && y>=0 && y<M && !visit[x][y]){
                    visit[x][y] = true;
                    q.offer(new int[]{x, y, map[x][y] == 1 ? now[2] + 1 : now[2]});
                }
            }
        }
        return 0;
    }
}