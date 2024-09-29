import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] A = new int[N];
        st = new StringTokenizer(br.readLine());
        long max = 0;
        for(int i=0; i<N; i++){
            A[i] = Integer.parseInt(st.nextToken());
            max = Math.max(A[i], max);
        }

        if(M == 0){
            System.out.println(max);
            return;
        }
        
        long min =0;
        long mid = 0;
        max++;

        while (min <= max) {
            mid = (min + max) / 2;
            // System.out.println(min + " " + max + " " + mid);

            long c = 0;
            for(int i=0; i<N; i++){
                c += (A[i] - mid) > 0 ? (A[i] - mid) : 0;
            }

            if(c >= M){
                min = mid +1;
                // System.out.println("c >= M");
            }
            else{
                // System.out.println("c < M");
                max = mid -1;
            }
        }
        System.out.println(min-1);
         
    }
}