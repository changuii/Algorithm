import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] A = new int[N];
        for(int i=0; i<N; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }

        long l = 0;
        long h = 1_000_000 * 1_000_000L;
        long mid = 0;

        while (l <= h) {
            mid = (l + h) / 2;

            if(check(A, mid, M)){
                h = mid - 1;
            }
            else{
                l = mid + 1;
            }
        }

        System.out.println(h + 1);


        
    }


    public static boolean check(int[] A, long time, int M){

        long c = 0;
        for(int i=0; i<A.length; i++){
            c += time / A[i];
        }
        // System.out.println(c);
        return c >= M;
        
    }
}