import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        int[][] D = new int[n+1][n+1];

        for(int i=0; i<n+1; i++){
            // i중 1개를 뽑는 경우의 수는 i
            D[i][1] = i;
            // i중 0개도 선택하지 않는 경우의 수는 1개
            D[i][0] = 1;
            // i개 중 1개도 선택하지 않는 경우의 수는 1개
            D[i][i] = 1;
        }

        for(int i=1; i<n+1; i++){
            for(int j=1; j<=i; j++){
                D[i][j] = D[i-1][j] + D[i-1][j-1];
            }
        }

        System.out.println(D[n][r]);

    }

}