import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static int[][] dp;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        dp = new int[N+1][2];
        
        // dp[i][j], i에서 1로 만드는 0은 경로, 1은 값
        dp[1][1] = 0;
        for(int i=2; i<=N; i++){
            int x = 100_001;
            int y = 100_001;
            int z = 100_001;
            if(i % 2== 0){
                x = dp[i / 2][1];
            }
            if(i % 3 == 0){
                y = dp[i/3][1];
            }
            z = dp[i-1][1];

            if(x <= y && x <= z){
                dp[i][0] = i/2;
                dp[i][1] = x+1;
            }
            else if(y <= x && y <= z){
                dp[i][0] = i/3;
                dp[i][1] = y+1;
            }
            else{
                dp[i][0] = i-1;
                dp[i][1] = z+1;
            }
        }

        StringBuilder sb = new StringBuilder(dp[N][1] +"\n");
        for(int i=N; i>0; i = dp[i][0]){
            sb.append(i).append(" ");
        }
        System.out.println(sb);
        
    }
}