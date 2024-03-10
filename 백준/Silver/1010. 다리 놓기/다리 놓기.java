import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


class Main {
    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

       int T = Integer.parseInt(br.readLine());

       int[][] D = new int[31][31];
       for(int i=0; i<D.length; i++){
           D[i][1] = i;
           D[i][0] = 1;
           D[i][i] = 1;
       }

       for(int i=1; i<D.length; i++){
           for(int j=1; j<i; j++){
               D[i][j] = D[i-1][j] + D[i-1][j-1];
           }
       }

       StringBuilder sb = new StringBuilder();
       StringTokenizer st;
       for(int i=0; i<T; i++){
           st = new StringTokenizer(br.readLine() ," ");
           int N = Integer.parseInt(st.nextToken());
           int M = Integer.parseInt(st.nextToken());
           sb.append(D[M][N]).append("\n");
       }
        System.out.println(sb);



    }

}