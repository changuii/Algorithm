import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for(int t=1; t<=T; t++){
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            int[][] dp = new int[N+1][K+1];
            int[][] item = new int[N+1][2];

            for(int i=1; i<=N; i++){
                st = new StringTokenizer(br.readLine());
                item[i][0] = Integer.parseInt(st.nextToken());
                item[i][1] = Integer.parseInt(st.nextToken());
            }

            for(int i=1; i<=N; i++){
                for(int j=1; j<=K; j++){
                    if(item[i][0] <= j){
                        dp[i][j] = Math.max(dp[i-1][j-item[i][0]] + item[i][1], dp[i-1][j]);
                    }
                    else{
                        dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                    }
                }
            }

            sb.append(String.format("#%d %d\n", t, dp[N][K]));
        }
        System.out.println(sb);
    }
}