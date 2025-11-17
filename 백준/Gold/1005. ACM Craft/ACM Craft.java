import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static List<List<Integer>> list;
    static int[] time;
    static int[] dp;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for(int t=0; t<T; t++ ){
            st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            time = new int[N];
            dp = new int[N];

            list = new ArrayList<>();
            list.add(new ArrayList<>());
            
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++) {
                time[i] = Integer.parseInt(st.nextToken());
                list.add(new ArrayList<>());
                dp[i] = -1;
            }
            

            
            for(int i=0; i<K; i++) {
                st = new StringTokenizer(br.readLine());

                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                list.get(b).add(a);
            }

            int W = Integer.parseInt(br.readLine());

            sb.append(dfs(W)).append("\n");
            
        }

        System.out.println(sb);
    }

    public static int dfs(int now) {
        if(dp[now - 1] != -1) {
            return dp[now-1];
        }
        
        if(list.get(now).size() == 0) {
            return dp[now-1] = time[now-1];
        }

        int max = 0;
        for(int next: list.get(now)) {
            max = Math.max(max, dfs(next));
        }

        return dp[now-1] = max + time[now-1];
    }
}