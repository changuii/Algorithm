import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 0는 대각선, 1은 직선, 2는 우측 대각선
        int[][][] dp = new int[N][M][3];
        for(int i=0; i<M; i++){
            dp[0][i][0] = map[0][i];
            dp[0][i][1] = map[0][i];
            dp[0][i][2] = map[0][i];
        }

        for(int i=1; i<N; i++){
            for(int j=0; j<M; j++){
                int val1 = 0;
                int val2 = 0;
                int val3 = dp[i-1][j][2];
                if(j != 0){
                    val1 = dp[i-1][j-1][0];
                }else val1 = Integer.MAX_VALUE;
                if(j != M-1){
                    val2 = dp[i-1][j+1][1];
                }else val2 = Integer.MAX_VALUE;
                
                dp[i][j][0] = Math.min(val3, val2) + map[i][j];
                dp[i][j][1] = Math.min(val1, val3) + map[i][j];
                dp[i][j][2] = Math.min(val1, val2) + map[i][j];
            }
        }

        // for(int i=0; i<N; i++){
        //     System.out.println(Arrays.deepToString(dp[i]));
        // }

        int min = Integer.MAX_VALUE;
        for(int i=0; i<M; i++){
            min = Math.min(Math.min(min, dp[N-1][i][0]), Math.min(dp[N-1][i][1], dp[N-1][i][2]));
        }

        System.out.println(min);
        
    }
}