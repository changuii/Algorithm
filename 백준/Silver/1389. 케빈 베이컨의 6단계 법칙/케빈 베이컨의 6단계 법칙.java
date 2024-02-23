import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


class Main {
    static final int INF = 100000001;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken())+1;
        int M = Integer.parseInt(st.nextToken());

        int[][] D = new int[N][N];
        for(int i=1; i<N; i++){
            for(int j=1; j<N; j++){
                if(i == j) {
                    D[i][j] = 0;
                }
                else {
                    D[i][j] = INF;
                }
            }
        }


        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            D[a][b] = 1;
            D[b][a] = 1;
        }


        for(int k=1; k<N; k++){
            for(int i=1; i<N; i++){
                for(int j=1; j<N; j++){
                    if(D[i][j] > D[i][k] + D[k][j])
                        D[i][j] = D[i][k] + D[k][j];
                }
            }
        }

        int min = INF;
        int answer = 0;
        for(int i=1; i<N;i++){
            int sum = 0;
            for(int j=1; j<N; j++)
                sum += D[i][j];
            if(min > sum) {
                min = sum;
                answer = i;
            }
        }

        System.out.println(answer);

    }
}