import java.util.*;
import java.io.*;

class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            int D = Integer.parseInt(st.nextToken()) - 11;
            int H = Integer.parseInt(st.nextToken()) - 11 + (D * 24);
            int M = Integer.parseInt(st.nextToken()) - 11 + (H * 60);

            
            sb.append("#" + i + " ")
                .append(M < 0 ? "-1" : M)
                .append("\n");
        }
        System.out.println(sb);
    }

    
}