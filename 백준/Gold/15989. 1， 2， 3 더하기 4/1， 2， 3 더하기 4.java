import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] A = new int[N];
        int max = 0;
        for(int i=0; i<N; i++){
            A[i] = Integer.parseInt(br.readLine());
            max = Math.max(A[i], max);
        }


        int[][] dp = new int[10001][3];
        dp[1][0] = 1;
        dp[2][0] = 1;
        dp[2][1] = 1;
        dp[3][0] = 1;
        dp[3][1] = 1;
        dp[3][2] = 1;
        for(int i=4; i<=max; i++){
            dp[i][0] = dp[i-1][0];
            dp[i][1] = dp[i-2][0] + dp[i-2][1];
            dp[i][2] = dp[i-3][0] + dp[i-3][1] + dp[i-3][2];
        }

        StringBuilder sb = new StringBuilder();

        for(int i=0; i<N; i++){
            sb.append(dp[A[i]][0] + dp[A[i]][1] + dp[A[i]][2]).append("\n");
        }

        System.out.println(sb);


        
        

        
    }
}