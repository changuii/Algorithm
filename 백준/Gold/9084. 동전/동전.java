import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int t=0; t<T; t++){
            int N = Integer.parseInt(br.readLine());

            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] A = new int[N];
            for(int i=0; i<N; i++){
                A[i] = Integer.parseInt(st.nextToken());
            }

            // 2 4 6
            // 1 -> 
            // 2 -> 2
            // 3 -> 
            // 4 -> 22, 4
            // 5 -> 
            // 6 -> 222,  || 42 || 6
            // 7 ->
            // 8 -> 2222 || 44, 422 || 62
            // 9 ->
            // 10 -> 22222 || 442, 4222|| 622, 64               22222, 2224, 244, 226, 46
            // 11
            // 12 -> 222222, 22224, 2244, 2226, 246, 444, 66
            

            int M = Integer.parseInt(br.readLine());
            int[] dp = new int[M+1];
            for (int i = 0; i < N; i++) {
                for (int j = 1; j <=M; j++) {
                    if (j - A[i] > 0) {
                        dp[j] += dp[j-A[i]];
                    } else if (j - A[i] == 0) {
                        dp[j]++;
                    }
                }
            }

            // System.out.println(Arrays.toString(dp));
            
            // for(int i=0; i<M; i++){
            //     System.out.println(Arrays.toString(dp[i]));
            // }

            sb.append(dp[M]).append("\n");
        }

        System.out.println(sb);
        
        
    }
}