import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        long[] dp = new long[N+1];
        dp[1] = 1;
        for(int i=2; i<=N; i++){
            dp[i] = dp[i-2] + dp[i-1];
        }
        System.out.println(dp[N]);

    }
}