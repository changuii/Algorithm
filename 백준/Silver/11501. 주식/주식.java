import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        for(int i=0; i<T; i++){
            int N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            int[] m = new int[N];
            for(int x=0; x<N; x++){
                m[x] = Integer.parseInt(st.nextToken());
            }

            long answer = 0;
            long max = m[N-1];
            for(int x=N-2; x>=0; x--){
                max = Math.max(max, m[x]);
                answer += (max - m[x]);
            }
            sb.append(answer).append("\n");
        }
        System.out.println(sb);
        
    }
}