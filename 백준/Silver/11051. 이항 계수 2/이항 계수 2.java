import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine() , " ");

        int N = Integer.parseInt(st.nextToken())+1;
        int K = Integer.parseInt(st.nextToken());

        int[][] D = new int[N][N];

        for(int i=0; i<N; i++){
            D[i][i] = 1;
            D[i][0] = 1;
            D[i][1] = i;
        }

        for(int i=1; i<N; i++){
            for(int j=1; j<i; j++){
                D[i][j] = (D[i-1][j] + D[i-1][j-1])%10007;
            }
        }

        System.out.println(D[N-1][K]);
    }

}