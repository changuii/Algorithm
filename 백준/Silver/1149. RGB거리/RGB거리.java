import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;
        int[][] A = new int[N][3];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<3; j++){
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // dp[i][j], j=1일경우, i-1은 0 또는 2에서 와야한다.

        int[][] dp = new int[N][3];
        dp[0][0] = A[0][0];
        dp[0][1] = A[0][1];
        dp[0][2] = A[0][2];
        for(int i=1; i<N; i++){
            dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + A[i][0];
            dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2])+ A[i][1];
            dp[i][2] = Math.min(dp[i-1][1], dp[i-1][0])+ A[i][2];
        }

        System.out.println(Math.min(dp[N-1][0], Math.min(dp[N-1][1], dp[N-1][2])));
        
    }
}