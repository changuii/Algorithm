import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for(int t = 0; t<T; t++){
            int N = Integer.parseInt(br.readLine());

            int[][] A = new int[2][N];
            for(int i=0; i<2; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<N; j++){
                    A[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            if(N == 1){
                sb.append(Math.max(A[0][0], A[1][0])).append("\n");
                continue;
            }
            int[][] dp = new int[2][N];
            dp[0][0] = A[0][0];
            dp[1][0] = A[1][0];
            dp[0][1] = A[1][0] + A[0][1];
            dp[1][1] = A[0][0] + A[1][1];
            for(int i=2; i<N; i++){
                dp[0][i] = Math.max(dp[1][i-1] , Math.max(dp[0][i-2], dp[1][i-2]))+ A[0][i];
                dp[1][i] = Math.max(dp[0][i-1] , Math.max(dp[0][i-2], dp[1][i-2])) + A[1][i];
            }
            // for(int i=0; i<2; i++){
            //     System.out.println(Arrays.toString(dp[i]));
            // }
            sb.append(Math.max(dp[0][N-1], dp[1][N-1])).append("\n");
            
        }
        System.out.println(sb);
        
        
        
    }
}