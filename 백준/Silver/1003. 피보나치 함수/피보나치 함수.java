import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        // dp[i][j] = fibo[i]의 j 갯수
        int[][] dp = new int[41][2];
        dp[0][0] = 1;
        dp[1][1] = 1;
        for(int i=2; i<dp.length; i++){
            dp[i][0] = dp[i-2][0] + dp[i-1][0];
            dp[i][1] = dp[i-2][1] + dp[i-1][1];
        }
        
        for(int i=0; i<N; i++){
            int M = Integer.parseInt(br.readLine());            
            sb.append(dp[M][0]).append(" ").append(dp[M][1]).append("\n");
        }
        System.out.println(sb);
        
    }
}