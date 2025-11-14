import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] val = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            val[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp1 = new int[N];
        int[] dp2 = new int[N];
        int max = 0;

        for(int i=0; i<N; i++) {
            dp1[i] = 1;

            for(int j=0; j<i; j++) {
                if(val[i] > val[j]) {
                    dp1[i] = Math.max(dp1[i], dp1[j] + 1);
                } 
            }
        }

        for(int i=N-1; i>=0; i--) {
            dp2[i] = 1;

            for(int j=N-1; j>i ;j--) {
                if(val[i] > val[j]) {
                    dp2[i] = Math.max(dp2[i], dp2[j] + 1);
                }
            }
        }

        for(int i=0; i<N; i++) {
            max = Math.max(max, dp1[i] + dp2[i] - 1);
        }
        
        System.out.println(max);
    }
}