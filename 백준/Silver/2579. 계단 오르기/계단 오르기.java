import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static int[][] map, temp, dp;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] A = new int[N];
        for(int i=0; i<N; i++){
            A[i] = Integer.parseInt(br.readLine());
        }

        if(N == 1){
            System.out.println(A[0]);
            return;
        }
            
        // dp[i][j] = i번째 계단의 j번 계단횟수의 최댓값
        int[][] dp = new int[N][2];
        dp[0][0] = A[0];
        dp[1][1] = A[0] + A[1];
        dp[1][0] = A[1];
        for(int i=2; i<N; i++){
            dp[i][1] = dp[i-1][0] + A[i];
            dp[i][0] = Math.max(dp[i-2][0], dp[i-2][1]) + A[i];
        }
        
        // for(int i=0; i<N; i++){
        //     System.out.println(Arrays.toString(dp[i]));
        // }

        System.out.println(Math.max(dp[N-1][0], dp[N-1][1]));
        
        
        
    }
}