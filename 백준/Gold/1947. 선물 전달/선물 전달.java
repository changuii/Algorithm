import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine())+1;
        final int D = 1_000_000_000;


        long[] A = new long[N];
        if(N > 2) A[2] = 1;
        for(int i=3; i<N; i++){
            A[i] = ((i-1) * (A[i-2] + A[i-1])) % D;
        }
        System.out.println(A[N-1]);
    }

}