import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int N = Integer.parseInt(br.readLine())+1;

        long[] A = new long[N];
        A[1] = 1;
        for(int i=2; i<5 && i < N; i++ ) {
            A[i] = i - 1;
        }
        for(int i=5; i<N; i++){
            int now = i - 2;
            while (now > 2){
                A[i] += A[now--];
            }
            A[i] += 3;
        }
        System.out.println(A[N-1]);



    }

}