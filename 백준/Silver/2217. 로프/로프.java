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

        int max = 0;
        Arrays.sort(A);

        for(int i=0; i<N; i++){
            max = Math.max(max, A[i] * (N-i));
        }

        
        System.out.println(max);

        
        
    }
}