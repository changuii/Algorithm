import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        long[] dp = new long[1001];
        dp[1] = 0;
        dp[2] = 1;
        for(int i=3; i<dp.length; i++){
            dp[i] = ((i/2) * factorial(i-1) + dp[i-1] * i) % 1_000_000_007;
        }
        
        
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        for(int test=1; test<=T; test++){
            int num = Integer.parseInt(br.readLine());

            
            sb.append("#").append(test).append(" ")
                .append(dp[num]);
            if(test != T) sb.append("\n");
            
        }
        System.out.println(sb);
    }

    public static long factorial(long n){
        if(n == 1) return 1;
        else{
            return n * (factorial(n-1) % 1_000_000_007) % 1_000_000_007;
        }
    }
}