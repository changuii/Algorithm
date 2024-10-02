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

        int[] A = new int[N];
        for(int i=0; i<N; i++){
            A[i] = Integer.parseInt(br.readLine());
        }

        long l = 1;
        long h = 10_000_000_000L;
        long mid = 0;

        while (l <= h) {
            mid = (l + h) / 2;

            if(check(A, mid, M)){
                h = mid -1;
            }
            else{
                l = mid + 1;
            }
        }
        System.out.println(h+1);
        
        
    }

    public static boolean check(int[] A, long K, int M){

        long now = K;
        int c = 1;
        for(int i=0; i<A.length; i++){
            if(A[i] > K) return false;

            if(A[i] > now){
                now = K;
                now -= A[i];
                c++;
            }
            else{
                now -= A[i];
            }
        }

        // System.out.println(K + " " + c);
        return c<=M;
        
    }
}