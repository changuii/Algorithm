import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[N];
        int max = 0;
        for(int i=0; i<N; i++){
            dp[i] = 1;
            int x = 0;
            for(int j=i-1; j>=0; j--){
                if(A[i] > A[j]){
                    x = Math.max(x, dp[j]);
                }
            }
            dp[i] += x;
            max = Math.max(max, dp[i]);
        }

        System.out.println(max);
        int val = 0;
        StringBuilder sb = new StringBuilder();
        for(int i=N-1; i>=0; i--){
            if(max == dp[i]){
                sb.insert(0, A[i] + " ");
                max--;
            }
        }

        System.out.println(sb);
        
        
    }
}