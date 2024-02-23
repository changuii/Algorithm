import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


class Main {
    static final int INF = 100000001;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N =Integer.parseInt(br.readLine())+1;
        int M = Integer.parseInt(br.readLine());

        int[][] D = new int[N][N];

        for(int i=1; i<N; i++){
            for(int j=1; j<N; j++){
                if(i == j) D[i][j] = 0;
                else D[i][j] = INF;
            }
        }

        StringTokenizer st;
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());


            D[a][b] = D[a][b] > w ? w : D[a][b];
        }


        for(int k = 1; k<N; k++){
            for(int i =1; i<N; i++){
                for(int j=1; j<N; j++){
                    if(D[i][j] > D[i][k] + D[k][j]){
                        D[i][j] = D[i][k] + D[k][j];
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=1; i<N; i++){
            for(int j=1; j<N; j++){
                sb.append(D[i][j] != INF ? D[i][j] : 0).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);

    }
}