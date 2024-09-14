import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static int[][] map, temp, dp;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        temp = new int[2][M];
        dp = new int[N][M];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = Integer.MIN_VALUE;
            }
        }

        // 1. 오른쪽으로 가면서 첫 번째 DP 배열을 만들어준다.
        // 2. 마지막까지 반복하는데 다음과 같다.
        // 2-1. 오른쪽으로가면서 왼쪽, 위쪽 중 큰 값을 찾는다.
        // 2-2. 왼쪽으로 가면서 우측울 비교해서 최대값을 찾는다.
        dp[0][0] = map[0][0];
        for(int i=1; i<M; i++){
            dp[0][i] = dp[0][i-1] + map[0][i];
        }

        for(int i=1; i<N; i++){

            temp[0][0] = dp[i-1][0] + map[i][0];
            for(int j=1; j<M; j++){
                temp[0][j] = Math.max(temp[0][j-1], dp[i-1][j]) + map[i][j];
            }

            temp[1][M-1] = dp[i-1][M-1] + map[i][M-1];
            for(int j=M-2; j>=0; j--){
                temp[1][j] = Math.max(temp[1][j+1], dp[i-1][j]) + map[i][j];
            }

            for(int j=0; j<M; j++){
                dp[i][j] = Math.max(temp[0][j] , temp[1][j]);
            }
        }

        System.out.println(dp[N-1][M-1]);
    }
}