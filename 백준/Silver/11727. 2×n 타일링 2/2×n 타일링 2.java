import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i=2; i<dp.length; i++){
            dp[i] = (dp[i-1] + 2*dp[i-2]) % 10_007;
        }
        System.out.println(dp[N]);        
    }
}