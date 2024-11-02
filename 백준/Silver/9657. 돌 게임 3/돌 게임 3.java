import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[1001];
        dp[1] = 1;
        dp[2] = 0;
        dp[3] = 1;
        dp[4] = 1;
        for(int i=5; i<dp.length; i++){
            if(dp[i-4] == 0 || dp[i-3] == 0 || dp[i-1] == 0){
                dp[i] = 1;
            }
            else{
                dp[i] = 0;
            }
        }

        System.out.println(dp[N] == 1 ? "SK" : "CY");
        
    }
}