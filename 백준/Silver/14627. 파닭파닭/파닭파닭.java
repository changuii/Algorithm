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
        int max = 0;
        for(int i=0; i<N; i++){
            A[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, A[i]);
        }

        long l = 1;
        long h = max;
        long mid = 0;
        while (l <= h) {
            mid = (l + h) / 2;

            if(check(A, M, mid)){
                l = mid + 1;
            }
            else{
                h = mid -1;
            }
        }

        long answer = 0;
        for(int x : A){
            answer += x;
        }

        
        System.out.println(answer - (l-1) * M);
        
    }


    public static boolean check(int[] A, int M, long distance){

        int c = 0;
        for(int i=0; i<A.length; i++){
            c += A[i] / distance;
        }

        return c >= M;
    }
}