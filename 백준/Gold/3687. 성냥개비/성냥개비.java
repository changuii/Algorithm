import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static long[] dp = new long[101];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Arrays.fill(dp, Long.MAX_VALUE);
        dp[2] = 1; 
        dp[3] = 7; 
        dp[4] = 4;
        dp[5] = 2;
        dp[6] = 6;
        dp[7] = 8; 
        dp[8] = 10;

        String[] arr = {"0", "0", "1", "7", "4", "2", "0", "8"};
        for(int i=9; i<dp.length; i++){
            for(int k=2; k<=7; k++){
                dp[i] = Math.min(dp[i], 
                                Long.parseLong(dp[i-k]+ arr[k]));
            }
        }
        

        StringBuilder sb = new StringBuilder();
        for(int t=0; t<N; t++){
            int now = Integer.parseInt(br.readLine());


            sb.append(dp[now]).append(" ")
                .append(getMax(now)).append("\n");
        }
        System.out.println(sb);
    }

    static String getMax(int x){
        StringBuilder sb = new StringBuilder();
        while (x > 0) {
            if(x % 2== 0){
                sb.append("1");
                x-=2;
            }
            else{
                sb.append("7");
                x-=3;
            }
        }
        return sb.toString();
    }

}