import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {

    // 대각 가로 세로
    static int[] dx = {1, 0, 1};
    static int[] dy = {1, 1, 0};
    
    static int[][] map;
    static int[][][] dp;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        dp = new int[N][N][3];
        StringTokenizer st;
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                dp[i][j][0] = -1;
                dp[i][j][1] = -1;
                dp[i][j][2] = -1;
            }
        }

        dp[N-1][N-1][0] = 1;
        dp[N-1][N-1][1] = 1;
        dp[N-1][N-1][2] = 1;

        System.out.println(dfs(0, 1, 1));
    }


    public static int dfs(int x, int y, int d) {
        if(dp[x][y][d] != -1) {
            return dp[x][y][d];
        }

        int sum = 0;
        // 대각
        if(d == 0) {

            for(int i=0; i<dx.length; i++) {
                int X = x + dx[i];
                int Y = y + dy[i];

                if(!check(X, Y)) continue;
                if(!checkDiag(i, x, y)) continue;

                sum += dfs(X, Y, i);
            }
            
        }
        // 가로
        else if(d == 1) {
            for(int i=0; i<dx.length; i++) {
                if(i == 2) continue;
                
                int X = x + dx[i];
                int Y = y + dy[i];

                if(!check(X, Y)) continue;
                if(!checkDiag(i, x, y)) continue;

                sum += dfs(X, Y, i);
            }
        }

        // 세로
        else if(d == 2) {
            for(int i=0; i<dx.length; i++) {
                if(i == 1) continue;
                
                int X = x + dx[i];
                int Y = y + dy[i];

                if(!check(X, Y)) continue;
                if(!checkDiag(i, x, y)) continue;

                sum += dfs(X, Y, i);
            }
        }

        return dp[x][y][d] = sum;
    }

    public static boolean check(int x, int y) {
        if(!(x >= 0 && x< map.length && y>=0 && y<map.length)) return false;

        return map[x][y] == 0;
    }

    public static boolean checkDiag(int idx, int beforeX, int beforeY) {
        if(idx != 0) return true;
        
        if(beforeX + 1 >= 0 && beforeX + 1 < map.length && map[beforeX + 1][beforeY] == 1) return false;

        return beforeY + 1 >=0 && beforeY + 1 <map.length && map[beforeX][beforeY + 1] == 0;
    }
}