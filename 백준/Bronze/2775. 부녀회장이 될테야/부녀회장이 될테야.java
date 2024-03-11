import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        int[][] D = new int[15][15];

        for(int i=0; i<D.length; i++){
            D[0][i] = i;
        }

        for(int i=1; i<D.length; i++){
            for(int j=1; j<D.length; j++){
                D[i][j] = D[i][j-1] + D[i-1][j];
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<T; i++){
            int a = Integer.parseInt(br.readLine());
            int b = Integer.parseInt(br.readLine());

            sb.append(D[a][b]).append("\n");
        }
        System.out.println(sb);

    }
}