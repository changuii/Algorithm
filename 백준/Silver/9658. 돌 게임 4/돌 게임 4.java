import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        boolean[] dp = new boolean[N > 4 ? N+1 : 5];
        dp[1] = false;
        dp[2] = true;
        dp[3] = false;
        dp[4] = true;
        for(int i=5; i<dp.length; i++){
            if(!dp[i-1] || !dp[i-3] || !dp[i-4]){
                dp[i] = true;
            }
        }

        System.out.println(dp[N] ? "SK" : "CY");
        
    }
}