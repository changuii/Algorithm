import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


class Main {
    static final int INF = 100000001;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine())+1;

        int[][] A = new int[N][N];

        StringTokenizer st;
        for(int i=1; i<N;i++){
            st = new StringTokenizer(br.readLine() , " ");
            for(int j=1; j<N; j++){
                A[i][j] = Integer.parseInt(st.nextToken());
            }

        }

        for(int k=1; k<N; k++){
            for(int i=1; i<N; i++){
                for(int j=1; j<N; j++){
                    if(A[i][j] < A[i][k] + A[k][j] && A[i][k] == 1 && A[k][j] == 1)
                        A[i][j] = 1;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=1; i<N; i++){
            for(int j=1; j<N; j++){
                sb.append(A[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);

    }
}