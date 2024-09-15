import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static int[] dp;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        dp = new int[N+1];
        
        // dp[i][j], i에서 1로 만드는 0은 경로, 1은 값
        for(int i=2; i<=N; i++){
            dp[i] = dp[i-1] + 1;
            if(i % 2== 0) dp[i] = Math.min(dp[i], dp[i/2] + 1);
            if(i % 3== 0) dp[i] = Math.min(dp[i], dp[i/3] + 1);
        }
        StringBuilder sb = new StringBuilder(dp[N] + "\n");
        int val = 0;
        for(int i=N; i>0; i = val){
            if(i % 2 == 0 && dp[i/2] +1 == dp[i]){
                sb.append(i).append(" ");
                val = i/2;
            } 
            else if(i % 3 == 0 && dp[i/3] +1 == dp[i]){
                sb.append(i).append(" ");
                val = i/3;
            } 
            else{
                sb.append(i).append(" ");
                val = i-1;
            }
        }

        System.out.println(sb);
        
    }
}