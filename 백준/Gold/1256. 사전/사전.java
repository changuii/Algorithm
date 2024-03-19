import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        long K = Integer.parseInt(st.nextToken());

        int size = N + M+1;
        long[][] A = new long[size][size];
        for(int i=0; i<size; i++){
            A[i][i] = 1;
            A[i][1] = i;
            A[i][0] = 1;
        }


        for(int i=1; i<size; i++){
            for(int j=1; j<size; j++){
                A[i][j] = A[i-1][j-1] + A[i-1][j];
                if(A[i][j] > 1000000000) A[i][j] = 1000000001;
            }
        }

        StringBuilder sb = new StringBuilder();
        if(A[N+M][M] < K)
            sb.append("-1");
        else{
            while (!(N == 0 && M == 0)){
                if(A[N-1 + M][M] >= K){
                    sb.append("a");
                    N--;
                }else{
                    sb.append("z");
                    K = K - A[N-1+M][M];
                    M--;
                }
            }
        }
        System.out.println(sb);






    }

}