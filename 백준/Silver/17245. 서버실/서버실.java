import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;
        int[][] A = new int[N][N];
        long sum = 0;
        int max = 0;
        for(int i=0; i<N; i++){
            st= new StringTokenizer(br.readLine());

            for(int j=0; j<N; j++){
                A[i][j] = Integer.parseInt(st.nextToken());
                sum += A[i][j];
                max = Math.max(max, A[i][j]);
            }
        }

        long M = sum %2 == 0 ? sum /2 : sum / 2 + 1;

        int l = 0;
        int h = 5000000;
        int mid = 0;
        
        while (l <= h) {
            mid = (l + h) / 2;

            if(check(A, M, mid)){
                h = mid -1;
            }
            else{
                l = mid + 1;
            }
        }
        System.out.println(h+1);
        
    }


    public static boolean check(int[][] A, long M, int time){

        long sum = 0;

        for(int i=0; i<A.length; i++){
            for(int j=0; j<A.length; j++){
                sum += A[i][j] >= time ? time : A[i][j];
            }
        }

        // System.out.println(sum + " " + time );        
        return M <= sum;
    }
    



    
}