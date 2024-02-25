import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st  = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken())+1;
        int M = Integer.parseInt(st.nextToken());
        int INF = 100000001;

        int[][] A = new int[N][N];

        for(int i=1; i<N; i++){
            for(int j=1; j<N; j++){
                if( i==j) A[i][j] = 0;
                else A[i][j] = INF;
            }
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            A[a][b] = 1;
            A[b][a] = 1;
        }

        for(int k=1; k<N; k++){
            for(int i=1; i<N; i++){
                for(int j=1;j<N; j++){
                    if(A[i][j] > A[i][k] + A[k][j]){
                        A[i][j] = A[i][k] + A[k][j];
                    }
                }
            }
        }

        int answer = 1;
        int value = INF;
        for(int i=1; i<N; i++){
            int sum = 0;
            for(int j=1; j<N; j++){
                sum += A[i][j];
            }
            if(value > sum){
                value = sum;
                answer = i;
            }
        }
        System.out.println(answer);

    }
}