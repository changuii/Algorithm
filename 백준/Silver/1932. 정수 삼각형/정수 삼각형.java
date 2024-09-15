import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        int[][] map = new int[N][N];
        // dp[i][j] = i층 j에서의 최댓값
        StringTokenizer st;
        for(int i=0; i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j < i+1; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] dp = new int[N][N];
        dp[0][0] = map[0][0];
        for(int i=0; i<N-1; i++){
            for(int j=0; j < i+1; j++){
                for(int k=0; k<2; k++){
                    dp[i+1][j+k] = Math.max(dp[i+1][j+k], dp[i][j] + map[i+1][j+k]);
                }
            }
        }

        int max = 0;
        for(int i=0; i<N; i++){
            max = Math.max(dp[N-1][i], max);
        }
        System.out.println(max);
        
        
    }
}