import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = 10;
        int[] dx = {-1, -2, 1, 2};
        
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        for(int t = 1; t<=T; t++){
            sb.append("#").append(t).append(" ");

            int N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());

            int[] home = new int[N];
            for(int i=0; i<N; i++){
                home[i] = Integer.parseInt(st.nextToken());
            }

            int answer = 0;
            for(int i=2; i<N-2; i++){
                int min = 256;
                for(int j=0; j<4; j++){
                    min = Math.min(min, home[i] - home[i+dx[j]]);
                }
                if(min > 0) answer+=min;
            }
            
            
            
            sb.append(answer).append("\n");
        }
        System.out.println(sb);
    }

}