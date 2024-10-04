import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] A = new int[N];
        for(int i=0; i<N; i++){
            A[i] = Integer.parseInt(br.readLine());
        }

        int c = 0;
        for(int i=N-2; i>=0; i--){
            if(A[i] >= A[i+1]){
                c += (A[i] - A[i+1] +1);
                A[i] -= (A[i] - A[i+1] + 1);
            }
        }
        System.out.println(c);
        // System.out.println(Arrays.toString(A));
        
    }
}