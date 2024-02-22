import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


class Main {
    static final int INF = 100000001;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine())+1;
        int M = Integer.parseInt(br.readLine());

        int[][] A = new int[N][N];
        for(int i=1; i<N; i++){
            for(int j=1; j<N; j++){
                if(i == j) A[i][j] = 0;
                else A[i][j] = INF;
            }
        }

        StringTokenizer st;
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            A[a][b] = A[a][b] > w ? w : A[a][b];
        }

        for(int i=1; i<N; i++){
            for(int j=1; j<N; j++){
                for(int k=1; k<N; k++){
                    if(A[j][k] > A[j][i] + A[i][k]) {
                        A[j][k] = A[j][i] + A[i][k];
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=1; i<N; i++){
            for(int j=1; j<N; j++){
                sb.append(A[i][j] != INF ? A[i][j] : 0).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}