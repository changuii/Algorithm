import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken())+1;
        int M = Integer.parseInt(st.nextToken())+1;

        int[][] A = new int[N][M];

        for(int i=1; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<M; j++){
                A[i][j] = A[i][j-1] + A[i-1][j] - A[i-1][j-1] + Integer.parseInt(st.nextToken());
            }
        }

        int test = Integer.parseInt(br.readLine());
        for(int i=0; i<test; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            System.out.println(A[x2][y2] - A[x1-1][y2] - A[x2][y1-1] + A[x1-1][y1-1]);
        }





    }
}