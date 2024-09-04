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
            int L = Integer.parseInt(st.nextToken());
            int U = Integer.parseInt(st.nextToken());
            int X = Integer.parseInt(st.nextToken());

            
            sb.append("#" + i + " ")
                .append(X > U ? -1 : X < L ? L - X : 0)
                .append("\n");
        }
        System.out.println(sb);
    }
}