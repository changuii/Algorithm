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
        long[] dp = new long[max+1];

        dp[0] = 1;
        dp[1] = 1;
        if(max == 1){
            System.out.println(1);
            return;
        }
        dp[2] = 2;
        for(int i=3; i<dp.length; i++){
            dp[i] = (dp[i-3] + dp[i-2] + dp[i-1]) % divide;
        }

        // System.out.println(Arrays.deepToString(dp));
        StringBuilder sb  = new StringBuilder();
        for(int i=0; i<N; i++){
            sb.append(dp[A[i]]).append("\n");
        }

        System.out.println(sb);
    }
}