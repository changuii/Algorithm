import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());


        // 1 -> 1
        // 2 -> 11, 00
        // 3 -> 111, 100, 001
        // 4 -> 1111, 1001, 0011,  ->  1100, 0000
        // 5 -> 11111, 10011, 00111, 11001, 00001 ->  11100, 10000, 00100, 
        int[] dp = new int[N+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i=2; i<=N; i++){
            dp[i] = (dp[i-2] + dp[i-1]) % 15746;
        }

        System.out.println(dp[N]);
        

        
        
    }
}