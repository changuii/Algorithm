import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static int[][] map, temp, dp;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] A = new int[N+1];
        for(int i=1; i<=N; i++){
            A[i] = Integer.parseInt(br.readLine());
        }

        if(N == 1){
            System.out.println(A[1]);
            return;
        }
            
        int[] dp = new int[N+1];
        dp[1] = A[1];
        dp[2] = A[1] + A[2];
        // dp[i] = 2칸 전에서 온 값, 3칸 전에서 2칸뛰고 1칸 전에서 온 값 중 최댓값
        for(int i=3; i<=N; i++){
            dp[i] = Math.max(dp[i-2], dp[i-3] + A[i-1]) + A[i];
        }


        System.out.println(dp[N]);
        
        
        
    }
}