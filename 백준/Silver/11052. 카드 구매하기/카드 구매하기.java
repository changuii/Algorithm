import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] A = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }

        // 2 -> 1 + 1, 2
        // 3 -> 1 + 1 + 1, 2 + 1, 3
        // 4 -> 1 + 1 + 1 + 1, 2 + 1 + 1, 2 + 2, 3 + 1, 4
        // 5 -> 1 + 1 + 1 + 1, 2 + 1 + 1 + 1, 2 + 2 + 1, 3 + 2
        
        int[] dp = new int[N+1];
        dp[1] = A[1];
        for(int i=2; i<=N; i++){
            dp[i] = Math.max(dp[i-1] + dp[1], A[i]);
            for(int j=i-2; j>1; j--){
                dp[i] = Math.max(dp[i], dp[j] + dp[i-j]);
            }
        }

        // System.out.println(Arrays.toString(dp));
        System.out.println(dp[N]);
        

        
        
    }
}