import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());


        int[][][] dp = new int[N][2][W+1];
        dp[0][0][W] = Integer.parseInt(br.readLine()) == 1 ? 1 : 0;
        dp[0][1][W-1] = dp[0][0][W] == 1 ? 0 : 1;
        for(int i=1; i<N; i++){
            int now = Integer.parseInt(br.readLine());

            dp[i][0][W] = dp[i-1][0][W] + (now == 1 ? 1 : 0);
            
            for(int w = W-1; w >= W-i && w >= 0; w--){
                dp[i][0][w] = Math.max(dp[i-1][1][w+1], dp[i-1][0][w]) + (now == 1 ? 1 : 0);
                dp[i][1][w] = Math.max(dp[i-1][0][w+1], dp[i-1][1][w]) + (now == 2 ? 1 : 0);
            }
        }
        // for(int i=0; i<N; i++){
        //     System.out.println(i+"초 : " + Arrays.deepToString(dp[i]));
        // }
        
        int max = 0;
        for(int i=0; i<=W; i++){
            max = Math.max(max, Math.max(dp[N-1][0][i],dp[N-1][1][i]));
        }
        System.out.println(max);
        
        
        
    }
}