import java.util.*;
import java.io.*;

class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        for(int i=1; i<=N; i++){
            int T = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            int sum = 0;
            int result = 0;
            int[] val = new int[T];
            
            for(int j=0; j<T; j++){
                int now = Integer.parseInt(st.nextToken());
                sum += now;
                val[j] = now;
            }

            sum /= T;
            for(int x : val){
                if(x <= sum) result++;
            }
            
            sb.append("#" + i + " ")
                .append(result)
                .append("\n");
        }
        System.out.println(sb);
    }

    
}