import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        for(int T=0; T<3; T++){
            int N = Integer.parseInt(br.readLine());

            // dp[X][N] X원을 N코인으로 만들 수 있는가
            boolean[][] dp = new boolean[50001][N+1];
            StringTokenizer st;
            ArrayList<int[]> list = new ArrayList<>();
            int sum = 0;
            for(int i=0; i<N; i++){
                st = new StringTokenizer(br.readLine());
                int price = Integer.parseInt(st.nextToken());
                int count = Integer.parseInt(st.nextToken());
                list.add(new int[]{price, count});
                sum += price * count;
            }

            if(sum % 2 == 1){
                sb.append("0\n");
            }
            else{
                sum /= 2;
                dp[0][0] = true;
                for(int i=1; i<=N; i++){
                    int[] now = list.get(i-1);
                    for(int j=0; j<=sum; j++){
                        if(dp[j][i-1]) {
                            for(int k=0; k<=now[1]; k++){
                                int val = j + now[0] * k;
                                if(val <= sum){
                                    dp[val][i] = true;
                                }
                            }
                        }
                    }
                }
                if(dp[sum][N]) sb.append("1\n");
                else sb.append("0\n");
            }
        }
        System.out.println(sb);
    }
}