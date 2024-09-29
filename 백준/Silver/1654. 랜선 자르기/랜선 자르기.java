import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        long max = 0;
        long[] A = new long[N];
        for(int i=0; i<N; i++){
            A[i] = Integer.parseInt(br.readLine());
            max = Math.max(A[i], max);
        }

        binarySearch(A, max, K);

        
    }

    public static void binarySearch(long[] A, long max, long K){
        long l = 1;
        long h = max +1;
        long mid = (l + h) / 2;
        
        while (l <= h) {
            mid = (l + h) / 2;
            if(mid == 0){
                System.out.println(0);
                return;
            }
            
            long count = 0;
            for(int i=0; i<A.length; i++){
                count += (A[i] / mid);
            }

            if(count >= K){
                l = mid + 1;
            }
            else{
                h = mid-1;
            }
        }
        System.out.println(l-1);
        
    }
}