import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


class Main {
    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

       String target = br.readLine();

       int N = Integer.parseInt(br.readLine());

       int[][] A = new int[target.length()+1][26];

       for(int i=0; i<target.length(); i++){
           int T = target.charAt(i) - 'a';
           for(int j= 0; j<A[i].length; j++){
               A[i+1][j] = A[i][j] + (T == j ? 1 : 0);
           }
       }


       StringBuilder sb = new StringBuilder();
       StringTokenizer st;
       for(int i=0; i<N; i++){
           st = new StringTokenizer(br.readLine() , " ");
           int T = st.nextToken().charAt(0) - 'a';
           int x = Integer.parseInt(st.nextToken())+1;
           int y = Integer.parseInt(st.nextToken())+1;

           sb.append(A[y][T] - A[x-1][T]).append("\n");
       }
        System.out.println(sb);
    }

}