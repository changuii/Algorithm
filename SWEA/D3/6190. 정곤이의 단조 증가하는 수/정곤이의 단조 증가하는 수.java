import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.stream.Collectors;

// The main method must be in a class named "Main".
class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        for(int t=1; t<=T; t++){

            int N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());

            int[] A = new int[N];
            for(int i=0; i<N; i++){
                A[i] = Integer.parseInt(st.nextToken());
            }

            int max = 0;
            for(int i=0; i<N; i++){
                for(int j=i+1; j<N; j++){
                    if(max < A[i] * A[j]){
                        max = isIncreament(A[i] * A[j]) ? A[i] * A[j] : max;
                    }
                }
            }
            
            sb.append(String.format("#%d %d\n", t, max == 0 ? -1 : max));
        }
        System.out.println(sb);
    }

    public static boolean isIncreament(int value){
        int now = value % 10;
        value /= 10;
        
        while (value > 0) {
            if(now < value % 10) return false;
            now = value % 10;
            value /= 10;
        }
        return true;
    }
}