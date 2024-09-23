import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        if(N <=4){
            System.out.println(N == 4 ? -1 : 1);
            return ;
        }
        int[] dp = new int[N+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[3] = 1;
        dp[5] = 1;
        for(int i=6; i<=N; i++){
            if(dp[i-5] == Integer.MAX_VALUE && dp[i-3] == Integer.MAX_VALUE) continue;
            dp[i] = Math.min(dp[i-5], dp[i-3]) + 1;
        }

        System.out.println(dp[N] == Integer.MAX_VALUE ? -1 : dp[N]);
        
    }
}