import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st= new StringTokenizer(br.readLine());
        int[] S = new int[N+1];
        S[1] = Integer.parseInt(st.nextToken());
        for(int i=2; i<=N; i++){
            S[i] = Integer.parseInt(st.nextToken()) + S[i-1];
        }

        // 2일 간격 -> 0 ~ 1, 1 ~ 2, 2 ~ 3
        // i + M - 1
        int max = 0;
        int count = 0;
        for(int i= M; i<=N; i++){
            int now = S[i] - S[i - M];
            if(max < now){
                max = now;
                count = 1;
            }else if(max==now) count++;
        }

        if(max == 0){
            System.out.println("SAD");
            return;
        }
        System.out.println(max);
        System.out.println(count);
        
        
    
    }
}