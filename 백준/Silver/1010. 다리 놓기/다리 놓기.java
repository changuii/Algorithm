import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        int[][] A = new int[31][31];

        for(int i=0; i<A.length; i++){
            A[i][i] = 1;
            A[i][0] = 1;
            A[i][1] = i;
        }

        for(int i=1; i<A.length; i++){
            for(int j = 1; j<A.length; j++){
                A[i][j] = A[i-1][j-1] + A[i-1][j];
            }
        }

        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        for(int i=0; i<T; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            sb.append(A[b][a]).append("\n");
        }
        System.out.println(sb);

    }
}