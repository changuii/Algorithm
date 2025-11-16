import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;
        int[][] map = new int[N][2];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());

            map[i][0] = Integer.parseInt(st.nextToken());
            map[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(map, (o1, o2) -> {
            return o1[0] - o2[0];
        });

        int[] dp = new int[N];
        int max = 0;
        for(int i=0; i<N; i++) {
            dp[i] = 1;
            
            for(int j=0; j< i; j++) {
                if(map[i][1] > map[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }
        
        System.out.println(N - max);
        
    }
}