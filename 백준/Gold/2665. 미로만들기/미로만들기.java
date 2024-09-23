import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
public class Main {
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    public static void main(String[] args) throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        boolean[][] map = new boolean[N][N];
        boolean[][] visit = new boolean[N][N];

        for(int i=0; i<N; i++){
            String[] val = br.readLine().split("");
            for(int j=0; j<N; j++){
                map[i][j] = val[j].equals("1");
            }
        }

        PriorityQueue<int[]> q = new PriorityQueue<>((o1, o2) ->{
            return o1[2] - o2[2];
        });

        q.add(new int[]{0, 0, 0});
        while (!q.isEmpty()) {
            int[] now = q.poll();
            if(now[0] == N-1 && now[1] == N-1){
                System.out.println(now[2]);
                return;
            }

            for(int i=0; i<4; i++){
                int x = now[0] + dx[i];
                int y = now[1] + dy[i];
                if(x >=0 && x<N && y>=0 && y<N 
                   && !visit[x][y] ){
                    q.offer(new int[]{x, y, now[2] + (map[x][y] ? 0 : 1)});
                    visit[x][y] = true;
               }
            }
        }
        
        
        
    }
}