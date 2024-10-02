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
        long h = Integer.MAX_VALUE;
        long mid = 0;
        while (l <= h) {
            mid = (l + h) / 2;

            if(check(A, mid, M)){
                l = mid + 1;
            }
            else{
                
                h = mid - 1;
            }
        }

        System.out.println(l - 1);
        
        
        
    }

    public static boolean check(int[] A, long level, int K){

        long k = 0;
        for(int i=0; i<A.length; i++){
            if(A[i] < level){
                k += level - A[i];
            }
            if(k > K) return false;
        }

        return true;
    }
    
}