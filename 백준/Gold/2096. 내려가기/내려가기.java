import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static int[] dy = {0, 1, -1};
    static int[][] map;
    static int[][] dp1;
    static int[][] dp2;
    public static void main(String[] args) throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        map = new int[N][3];
        dp1 = new int[N][3];
        dp2 = new int[N][3];
        StringTokenizer st;
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());

            map[i][0] = Integer.parseInt(st.nextToken());
            map[i][1] = Integer.parseInt(st.nextToken());
            map[i][2] = Integer.parseInt(st.nextToken());

            dp1[i][0] = -1;
            dp1[i][1] = -1;
            dp1[i][2] = -1;

            dp2[i][0] = -1;
            dp2[i][1] = -1;
            dp2[i][2] = -1;
        }

        dp1[N-1][0] = map[N-1][0];
        dp1[N-1][1] = map[N-1][1];
        dp1[N-1][2] = map[N-1][2];

        dp2[N-1][0] = map[N-1][0];
        dp2[N-1][1] = map[N-1][1];
        dp2[N-1][2] = map[N-1][2];
        int max = Math.max(Math.max(dfs1(0, 0), dfs1(0, 1)), dfs1(0, 2));
        int min = Math.min(Math.min(dfs2(0, 0), dfs2(0, 1)), dfs2(0, 2));

        System.out.println(max + " " + min);
    }

    public static int dfs1(int x, int y) {
        if(dp1[x][y] != -1) {
            return dp1[x][y];
        }

        int max = 0;
        for(int i=0; i<dy.length; i++) {
            int X = x + 1;
            int Y = y + dy[i];

            if(!(X >=0 && X < map.length && Y >=0 && Y < map[0].length)) continue;
            
            max = Math.max(max, dfs1(X, Y));
        }

        return dp1[x][y] = map[x][y] + max;
    }

    public static int dfs2(int x, int y) {
        if(dp2[x][y] != -1) {
            return dp2[x][y];
        }

        int min = Integer.MAX_VALUE;
        for(int i=0; i<dy.length; i++) {
            int X = x + 1;
            int Y = y + dy[i];

            if(!(X >=0 && X < map.length && Y >=0 && Y < map[0].length)) continue;
            
            min = Math.min(min, dfs2(X, Y));
        }

        return dp2[x][y] = map[x][y] + min;
    }
}