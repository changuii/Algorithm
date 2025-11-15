import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int[][] map;
    static int[][] answer;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        answer = new int[N][M];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine()); 
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                answer[i][j] = -1;
            }
        }
        answer[N-1][M-1] = 1;

        
        
        System.out.println(dfs(0, 0));
    }

    public static int dfs(int x, int y) {
        if(answer[x][y] != -1) {
            return answer[x][y];
        }


        int sum = 0;
        for(int i=0; i<4; i++) {
            int X = x + dx[i];
            int Y = y + dy[i];

            if(!(X >= 0 && X < map.length && Y >=0 && Y<map[0].length)) continue;
            if(map[X][Y] >= map[x][y]) continue;

            sum += dfs(X, Y);
        }

        answer[x][y] = sum;
        return sum;
        
    }
}