import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            dp[i] = Integer.parseInt(st.nextToken());
        }

        // dp[i], i를 포함해서 이전 최댓값을 더했을 때, 가장 큰 값
        int max = dp[0];
        for(int i=1; i<N; i++){
            dp[i] = Math.max(dp[i-1] + dp[i], dp[i]);
            max = Math.max(dp[i], max);
        }
        
        // System.out.println(Arrays.toString(dp));
        System.out.println(max);        
    }
}