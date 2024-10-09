import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Solution {
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = 10;

        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        for(int t=1; t<=T; t++){

            br.readLine();
            int N = 16;

            char[][] map = new char[N][N];

            for(int i=0; i<N; i++){
                map[i] = br.readLine().toCharArray();
            }

            
            
            sb.append("#").append(t).append(" ")
                .append(BFS(map) ? 1 : 0).append("\n");
        }
        System.out.println(sb);
        
    }

    public static boolean BFS(char[][] map){
        Queue<int[]> q = new ArrayDeque<>();

        q.offer(new int[] {1, 1});
        while (!q.isEmpty()) {
            int[] now = q.poll();

            for(int i=0; i<4; i++){
                int x = now[0] + dx[i];
                int y = now[1] + dy[i];

                if(!(x>=0 && x<map.length && y>=0 && y<map.length)) continue;
                if(map[x][y] == '3') return true;
                
                if(map[x][y] == '0'){
                    q.offer(new int[]{x, y});
                    map[x][y] = '1';
                }
            }
            
        }
        return false;
        
    }
}