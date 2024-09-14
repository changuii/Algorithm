import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        boolean[] visit = new boolean[100_001];
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<N; i++){
            int now = Integer.parseInt(br.readLine());
            if(visit[now]) continue;
            
            list.add(now);
            visit[now] = true;
        }


        int[] dp = new int[K+1];
        Arrays.fill(dp, 100_001);
        dp[0] = 0;
        for(int i=0; i<list.size(); i++){
            for(int j=list.get(i); j<K+1; j++){
                dp[j] = Math.min(dp[j], dp[j - list.get(i)]+1);
            }
        }
        // System.out.println(Arrays.toString(dp));
        System.out.println(dp[K] == 100_001 ? -1 : dp[K]);
        
        
    }
}