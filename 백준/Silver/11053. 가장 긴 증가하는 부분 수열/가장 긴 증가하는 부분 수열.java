import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

         // dp[i], i를 포함해서 이전 최댓값을 더했을 때, 가장 큰 값
        int[] A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        for(int i=0; i<N; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[N];
        dp[0] = 1;
        int answer = 1;
        for(int i=1; i<N; i++){
            for(int j=i-1; j>=0; j--){
                if(A[j] < A[i]){
                    dp[i] = Math.max(dp[j], dp[i]);
                }
            }
            dp[i]++;
            answer = Math.max(answer, dp[i]);
        }

        // System.out.println(Arrays.toString(dp));
        System.out.println(answer);        
    }
}