import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static int[] value;
    static int max = 0;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        value = new int[N];
        int[] dp = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            dp[i] = 1;
            value[i] = Integer.parseInt(st.nextToken());
        }

        
        for(int i=0; i<N; i++) {

            for(int j=i-1; j>=0; j--) {
                if(value[i] < value[j]) {
                    dp[i]= Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(dp[i], max);
        }

        System.out.println(max);
        
    }
}