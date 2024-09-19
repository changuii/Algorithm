import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }

        // 1 2 1 3 1 2 1
        // 1 1 -> 1
        // 1 2 -> 0
        // 1 3 -> dp[a+1][b-1] == 1 && A[a] == A[b] -> 1 : 0
        // 1 4 -> 
        
        boolean[][] dp = new boolean[N+1][N+1];
        for(int i=1; i<=N; i++){
            dp[i][i] = true;
        }

        for(int i=1; i<=N; i++){
            for(int j=1; j<=N; j++){
                if(j > i) break;
                if(j+1 > i-1) dp[j][i] = A[j] == A[i];
                else dp[j][i] = dp[j+1][i-1] && A[j] == A[i];
            }
        }

        // for(int i=1; i<=N; i++){
        //     System.out.println(Arrays.toString(dp[i]));
        // }

        
        int M = Integer.parseInt(br.readLine());
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            sb.append(dp[a][b] ? 1 : 0).append("\n");
            
        }
        
        

        System.out.println(sb);
        
        
    }
}