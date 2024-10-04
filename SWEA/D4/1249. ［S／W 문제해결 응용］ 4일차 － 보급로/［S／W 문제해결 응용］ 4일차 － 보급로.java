import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Solution {
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int t =1; t<=T; t++){

            int N = Integer.parseInt(br.readLine());

            int[][] map = new int[N][N];

            for(int i=0; i<N; i++){
                char[] val = br.readLine().toCharArray();
                for(int j=0; j<N; j++){
                    map[i][j] = val[j] - '0';
                }
            }
            
            sb.append("#").append(t).append(" ")
                .append(BFS(map)).append("\n");
        }
        System.out.println(sb);
        
            
    }


    public static int BFS(int[][] map){
        PriorityQueue<int[]> q = new PriorityQueue<>((o1, o2) ->{
           return o1[2] - o2[2]; 
        });

        boolean[][] visit = new boolean[map.length][map[0].length];

        q.offer(new int[]{0, 0, 0});
        visit[0][0] = true;
        while (!q.isEmpty()) {
            int[] now = q.poll();

            if(now[0] == map.length-1 && now[1] == map[0].length-1) return now[2];

            for(int i=0; i<4; i++){
                int x = now[0] + dx[i];
                int y = now[1] + dy[i];

                if(!(x >=0 && x<map.length && y>=0 && y<map[0].length)) continue;

                if(!visit[x][y]){
                    visit[x][y] = true;
                    q.offer(new int[]{x, y, now[2] + map[x][y]});
                }
            }
            
        }
        return 0;
        
    }
    
}