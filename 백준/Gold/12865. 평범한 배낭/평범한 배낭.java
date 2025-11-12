import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] item = new int[N][2];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());

            item[i][0] = Integer.parseInt(st.nextToken());
            item[i][1] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[N+1][K+1];
        for(int i=0; i<dp.length; i++) {
            dp[0][i] = 0;
            dp[i][0] = 0;
        }

        for(int i=1; i<=N; i++) {
            int[] it = item[i-1];
            for(int j=0; j<=K; j++) {
                if(j < it[0]) {
                    dp[i][j] = dp[i-1][j];
                }
                else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-it[0]] + it[1]);
                }
            }
        }

        System.out.println(dp[N][K]);
        
    }
}