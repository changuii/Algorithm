import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[N+1];
        dp[1] = 1;
        dp[0] = 1;
        for(int i=2; i<=N; i++){
            dp[i] = dp[i-2] + dp[i-1];
        }

        int M = Integer.parseInt(br.readLine());
        int before = 0;
        int answer = 1;
        for(int i=0; i<M; i++){
            int next = Integer.parseInt(br.readLine());
            int val = next - before - 1;
            answer *= dp[val];
            before = next;
        }

        int val = N - before;
        answer *= dp[val];
        System.out.println(answer);
        
    }

}