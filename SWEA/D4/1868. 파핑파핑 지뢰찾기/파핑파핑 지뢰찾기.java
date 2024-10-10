import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Solution {
     // -1 0 0 1 1 -1 -1 1
     // 0 -1 1 0 1 -1 1 -1
    
    static int[] dx = {-1, 0, 0, 1, 1, -1, -1, 1};
    static int[] dy = {0, -1, 1, 0, 1, -1, 1, -1};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        for(int t=1; t<=T; t++){

            // System.out.println("==========");
            int N = Integer.parseInt(br.readLine());
            int answer = 0;
            
            char[][] map = new char[N][N];
            boolean[][] visit = new boolean[N][N];

            for(int i=0; i<N; i++){
                map[i] = br.readLine().toCharArray();
            }


            int count = 0;
            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    if(map[i][j] == '.') count++;
                    if(!visit[i][j] && map[i][j] == '.' && getPoping(i, j, map) == 0){
                        answer++;
                        count -= BFS(visit, map, i, j);
                    }
                }
            }

            // for(int i=0; i<N; i++){
            //     System.out.println(Arrays.toString(map[i]));    
            // }
            
        
            sb.append(String.format("#%d %d\n", t, answer + count));
            
        }
        System.out.println(sb);
    }


    public static int BFS(boolean[][] visit, char[][] map, int X, int Y){
        Queue<int[]> q = new ArrayDeque<>();
        int count = 0;

        q.offer(new int[]{X, Y, 0});
        visit[X][Y] = true;
        while (!q.isEmpty()) {
            int[] now = q.poll();
            count++;
            if(now[2] > 0) continue;

            for(int i=0; i<8; i++){
                int x = now[0] + dx[i];
                int y = now[1] + dy[i];

                if(!(x >=0 && x<map.length && y>=0 && y<map.length)) continue;

                
                int poping = getPoping(x, y, map);
                if(!visit[x][y] && map[x][y] == '.'){
                    visit[x][y] = true;
                    q.offer(new int[]{x, y, poping});
                }
            }
        }
        return count;
    }

    public static int getPoping(int X, int Y, char[][] map){
        int c = 0;
        for(int i=0; i<8; i++){
            int x = X + dx[i];
            int y = Y + dy[i];

            if(!(x >=0 && x<map.length && y>=0 && y<map.length)) continue;

            if(map[x][y] == '*') c++;
        }
        return c++;
        
    }
}