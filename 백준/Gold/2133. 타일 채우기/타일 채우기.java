import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        if(N % 2 == 1){
            System.out.println(0);
            return;
        }

        N /= 2;
        int[] dp = new int[16];
        dp[0] = 1;
        dp[1] = 3;
        dp[2] = 11;
        for(int i=3; i<=N; i++){
            dp[i] = dp[i-1] * dp[1];
            for(int j=i-2; j>=0; j--){
                dp[i] += dp[j] * 2;
            }
        }
        System.out.println(dp[N]);
        
    }
}