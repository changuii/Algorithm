import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine())+1;
        int divide = 1_000_000_000;
        long[][] A = new long[N][11];

        for(int i=1; i<10; i++){
            A[1][i] = 1;
        }

        for(int i=2; i<N; i++){
            A[i][0] = A[i-1][1];
            A[i][9] = A[i-1][8];
            for(int j=1; j<= 8; j++){
                A[i][j] = (A[i-1][j-1] + A[i-1][j+1] )%divide;
            }
        }

        long sum = 0;
        for(int i=0; i<10; i++){
            sum = (sum + A[N-1][i]) % divide;
        }
        System.out.println(sum);
    }

}