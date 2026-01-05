import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Solution {
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int t=1; t<=T; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int[][] map = new int[N][N];

            for(int i=0; i<N; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int max = 0;
            for(int i=0; i<N; i++) {
                for(int j=0; j<N; j++) {
                    max = Math.max(sum(map, M, i, j), max);
                }
            }

            sb.append(String.format("#%d %d\n", t, max));
        }
        System.out.println(sb);
    }

    public static int sum(int[][] map, int M, int x, int y) {

        int sum1 = map[x][y];
        for(int i=1; i<M; i++) {
            if(x + i >= 0 && x + i < map.length) sum1 += map[x + i][y];
            if(x - i >= 0 && x - i < map.length) sum1 += map[x-i][y];
            if(y + i >= 0 && y + i <map.length) sum1+= map[x][y+i];
            if(y - i >= 0 && y - i <map.length) sum1+= map[x][y-i];
        }

        int sum2 = map[x][y];
        for(int i=1; i<M; i++) {
            if(x + i >= 0 && x + i < map.length && y + i >= 0 && y + i <map.length) sum2 += map[x + i][y+i];
            if(x + i >= 0 && x + i < map.length && y - i >= 0 && y - i <map.length) sum2 += map[x + i][y-i];
            if(x - i >= 0 && x - i < map.length && y + i >= 0 && y + i <map.length) sum2 += map[x-i][y+i];
            if(x - i >= 0 && x - i < map.length && y - i >= 0 && y - i <map.length) sum2 += map[x-i][y-i];
        }

        return Math.max(sum1, sum2);
    }
}