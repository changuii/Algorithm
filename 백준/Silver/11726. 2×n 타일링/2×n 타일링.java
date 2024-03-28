import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int N = Integer.parseInt(br.readLine())+1;
        int divide = 10_007;

        long[] A = new long[N];
        for(int i=1; i<N && i < 3; i++){
            A[i] = i;
        }
        for(int i=3; i<N; i++){
            A[i] = (A[i-1] + A[i-2] ) % divide;
        }
        System.out.println(A[N-1]);
    }

}