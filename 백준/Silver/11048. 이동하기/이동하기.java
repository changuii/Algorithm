import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static int[][] map;
    static int[][] dp;
    static int[] dx = {0, 1, 1};
    static int[] dy = {1, 0, 1};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        dp = new int[N][M];

        for(int i=0; i<N; i++ ){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = -1;
            }
        }

        dp[N-1][M-1] = map[N-1][M-1];
        System.out.println(dfs(0, 0));
    }

    public static int dfs(int x, int y) {
        if(dp[x][y] != -1) return dp[x][y];
        
        int max = 0;
        for(int i=0; i<3; i++) {
            int X = x + dx[i];
            int Y = y + dy[i];

            if(!(X>=0 && X<map.length && Y>=0 && Y<map[0].length)) continue;

            max = Math.max(max, dfs(X, Y));
        }
        return dp[x][y] = max + map[x][y];
    }
}