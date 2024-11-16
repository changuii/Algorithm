import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.stream.Collectors;

// The main method must be in a class named "Main".
class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        for(int t=1; t<=T; t++){
            int N = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine());
            int[] A = new int[N];

            for(int i=0; i<N; i++){
                A[i] = Integer.parseInt(st.nextToken());
            }
            
            sb.append(String.format("#%d %d\n", t, solution(A)));
        }
        System.out.println(sb);
    }

    public static int solution(int[] A){
        int solution = 0;
        int[] dp = new int[A.length];
        Arrays.fill(dp, 1);
        for(int i=1; i<dp.length; i++){
            int max = 0;
            for(int j=i-1; j>=0; j--){
                if(A[j] <= A[i]){
                    max = Math.max(max, dp[j]);
                }
            }
            dp[i] += max;
            solution = Math.max(dp[i], solution);
        }
        return solution;
    }
}