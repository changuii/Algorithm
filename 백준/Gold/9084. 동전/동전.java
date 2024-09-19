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
            int[][] dp = new int[M+1][N];
            for(int i=0; i<N; i++){
                dp[0][i] = 1;
            }
            
            for(int i=1; i<=M; i++){
                for(int j=0; j<N; j++){
                    if(i - A[j] >= 0)
                       for(int k=j; k>=0; k--){
                           dp[i][j] += dp[i - A[j]][k];
                           if(i - A[j] == 0) break;
                       }
                }
            }
            // for(int i=0; i<M; i++){
            //     System.out.println(Arrays.toString(dp[i]));
            // }
            int answer = 0;
            for(int i=0; i<N; i++){
                answer += dp[M][i];
            }

            sb.append(answer).append("\n");
        }

        System.out.println(sb);
        
        
    }
}