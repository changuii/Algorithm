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
            int N = Integer.parseInt(br.readLine());

            int[][] map = new int[N][N];

            for(int i=0; i<N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j=0; j<N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            sb.append(String.format("#%d\n", t));

            for(int i=0; i<N; i++) {
                for(int j=N-1; j>=0; j--) {
                    sb.append(map[j][i]);
                }

                sb.append(" ");
                for(int j=N-1; j>=0; j--) {
                    sb.append(map[N-i-1][j]);
                }
    
                sb.append(" ");
                for(int j=0; j<N; j++) {
                    sb.append(map[j][N-i-1]);
                }

                sb.append("\n");
            }
        }
        System.out.println(sb);
    }
}