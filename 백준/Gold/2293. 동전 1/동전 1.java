import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] A = new int[N];
        for(int i=0; i<N; i++){
            A[i] = Integer.parseInt(br.readLine());
        }

        // dp[i] = i원을 만드는 경우의 수 
        
        int[] dp = new int[K+1];
        
        dp[0] = 1;
        for(int i=0; i<N; i++){
            for(int j=A[i]; j<K+1; j++){
                dp[j] = dp[j] + dp[j - A[i]];
            }
        }

        
        System.out.println(dp[K]);
    }
}