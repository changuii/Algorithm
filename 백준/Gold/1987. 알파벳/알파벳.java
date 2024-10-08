import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static char[][] map;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int max = 0;
    static boolean[] set = new boolean[26];
    static int R;
    static int C;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        
        for(int i=0; i<R; i++){
            String now = br.readLine();
            for(int j=0; j<C; j++){
                map[i][j] = now.charAt(j);
            }
        }

        set[map[0][0] - 'A'] = true;
        DFS(0, 0, 1);
        System.out.println(max);
        
        
        
    }

    public static void DFS(int x, int y, int now){
        set[map[x][y] - 'A'] = true;
        max = Math.max(max, now);

        for(int i=0; i<4; i++){
            int xValue = x + dx[i];
            int yValue = y + dy[i];
            if(xValue >= 0 && xValue < R && yValue >=0 && yValue < C
                  && !set[map[xValue][yValue] - 'A']){
                DFS(xValue, yValue, now+1);
            }
        }
        set[map[x][y] - 'A'] = false;
        
        
    }
}