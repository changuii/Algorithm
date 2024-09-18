import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        // 1 -> 0, 1, 2, 3, 4, 5, 6, 7, 8, 9
        // 2 -> 
        // 2-0 -> 00, 01, 02, 03, 04, 05, 06, 07, 08, 09
        // 2-1 -> 11, 12, 13, 14, 15, 16, 17, 18, 19
        // 2-2 -> 22, 23, 24, 25, 26, 27, 28 ,29
        // 2-3 -> 33, 34, 35, 36, 37, 38, 39
        // 2-4 -> 44, 45, 46, 47, 48, 49
        // 2-5 -> 55, 56, 57, 58, 59
        // 2-6 -> 66, 67, 68, 69
        // 2-7 -> 77, 78, 79
        // 2-8 -> 88, 89
        // 2-9 -> 99

        // dp[i][0] = dp[i-1][0] + 10;
        // dp[i][1] = dp[i-1][1] + 9;
        // dp[i][2] = dp[i-1][2] + 8;
        
        int[][] dp = new int[N+1][10];

        for(int i=0; i<10; i++){
            dp[1][i] = 1;
        }

        for(int i=2; i<=N; i++){
            for(int j=0; j<10; j++){
                dp[i][j] += dp[i-1][j] % 10_007;
                for(int k=j+1; k<10; k++){
                    dp[i][k] += dp[i-1][j] % 10_007; 
                }
            }
        }

        int answer = 0;
        for(int i=0; i<10; i++){
            answer = (answer + dp[N][i]) % 10_007;
        }
        // for(int i=1; i<=N; i++){
        //     System.out.println(Arrays.toString(dp[i]));
        // }

        System.out.println(answer) ;
        

        
        
    }
}