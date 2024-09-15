import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] A = new int[N][2];
        StringTokenizer st;
        
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b=  Integer.parseInt(st.nextToken());

            A[i][0] = a;
            A[i][1] = b;
        }

        // dp[i]는 i일부터 N일까지 상담했을 때의 최대값
        int[] dp = new int[N+1];
        for(int i=N-1; i>=0; i--){
            if(i + A[i][0] > N )
                dp[i] = dp[i+1];
            else 
                dp[i] = Integer.max(dp[i+1], A[i][1] + dp[i+A[i][0]]);
        }
        // System.out.println(Arrays.toString(dp));
        System.out.println(dp[0]);

    }
}