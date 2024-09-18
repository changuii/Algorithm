import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int N =Integer.parseInt(br.readLine());


        int[] A = new int[N];    
        int max = 0;
        for(int i=0; i<N; i++){
            A[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, A[i]);
        }

        int divide = 1_000_000_009;
        long[][] dp = new long[max+1][3];

        dp[0][0] = 1;
        dp[1][0] = 1;
        if(max == 1){
            System.out.println(1);
            return;
        }
        dp[2][1] = 1;
        dp[2][0] = 1;
        for(int i=3; i<dp.length; i++){
            dp[i][0] = (dp[i-1][0] + dp[i-1][1] + dp[i-1][2]) % divide;
            dp[i][1] = (dp[i-2][0] + dp[i-2][1] + dp[i-2][2]) % divide;
            dp[i][2] = (dp[i-3][0] + dp[i-3][1] + dp[i-3][2]) % divide;
        }

        // System.out.println(Arrays.deepToString(dp));
        StringBuilder sb  = new StringBuilder();
        for(int i=0; i<N; i++){
            sb.append((dp[A[i]][0] + dp[A[i]][1] + dp[A[i]][2])% divide).append("\n");
        }

        System.out.println(sb);
    }
}