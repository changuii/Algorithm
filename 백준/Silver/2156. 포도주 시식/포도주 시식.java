import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] A = new int[N];
        for(int i=0; i<N; i++){
            A[i] = Integer.parseInt(br.readLine());
        }

        int[][] dp = new int[N][2];
        dp[0][0] = A[0];
        if(N == 1){
            System.out.println(A[0]);
            return;
        }
        
        dp[1][0] = A[1];
        dp[1][1] = A[1] + A[0];
        int max = dp[1][1];
        for(int i=2; i<N; i++){
            dp[i][0] = Math.max(Math.max(dp[i-2][1], dp[i-2][0]) + A[i], dp[i-1][1]);
            dp[i][1] = dp[i-1][0] + A[i];
            max = Math.max(max, Math.max(dp[i][0], dp[i][1]));
        }

        System.out.println(max);
        // System.out.println(Arrays.deepToString(dp));
        
        
    }
}