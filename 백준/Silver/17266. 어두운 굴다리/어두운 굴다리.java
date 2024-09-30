import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] A = new int[M];
        for(int i=0; i<M; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }

        int l = 0;
        int h = N;
        int mid = 0;
        while (l <= h) {
            mid = (l + h) / 2;

            // System.out.println(l + " " + h);
            if(check(A, mid, N)){
                h = mid - 1;
            }
            else{
                l = mid + 1;
            }
        }
        System.out.println(l);
    }

    public static boolean check(int[] A, int distance, int N){

        // System.out.println(distance + " ----------");
        int before = 0;
        for(int i=0; i<A.length; i++){
            // System.out.println(before + " " + A[0]);
            if(A[i] - distance > before) return false;
            else{
                before = A[i] + distance;
            }
        }

        // System.out.println("before :" + before);
        if(before < N) return false;

        return true;
        
        
    }
}