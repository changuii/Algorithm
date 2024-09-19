import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        // 1 -> 1
        // 2 -> 1 + 1
        // 3 -> 1 + 1 + 1
        // 4 -> 2
        // 5 -> 2 + 1
        // 6 -> 2 + 1 + 1
        // 7 -> 2 + 1 + 1 + 1
        // 8 -> 2 + 2
        // 9 -> 3
        // 10 -> 3 + 1
        // 11 -> 3 + 1 + 1
        // 12 -> 3 + 2

        // 61 -> 7^2 + 4
        // 61

        int[] dp = new int[N+1];
        dp[1] = 1;
        for(int i=2; i<=N; i++){
            int now = (int) Math.sqrt(i);
            dp[i] = dp[i - now * now] + 1;
            for(int j=now-1; j> 0; j--){
                dp[i] = Math.min(dp[i- j * j] + 1, dp[i]);
            }
        }

        // System.out.println(Arrays.toString(dp));
        System.out.println(dp[N]);
        
        
    }
}