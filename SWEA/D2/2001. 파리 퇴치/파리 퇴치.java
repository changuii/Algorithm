import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        for(int t=1; t<=T; t++){
            st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int[][] map = new int[N][N];
            for(int i=0; i<N; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<N; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int max = 0;
            for(int i=0; i<N-M+1; i++){
                for(int j=0; j<N-M+1; j++){
                    max = Math.max(max, getFly(map, i, j, M));
                }
            }
            
            sb.append(String.format("#%d %d\n", t, max));
        }

        System.out.println(sb);
        
    }

    public static int getFly(int[][] map, int x, int y, int M){
        int sum = 0;
        for(int i=x; i<x+M; i++){
            for(int j=y; j<y+M; j++){
                sum += map[i][j];
            }
        }
        return sum;
    }
}