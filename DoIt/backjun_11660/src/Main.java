import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        /* 내가 푼 것
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int size = Integer.parseInt(st.nextToken());
        int testcase = Integer.parseInt(st.nextToken());

        long[] S = new long[(int) (Math.pow(size, 2)+1)];
        for(int i =1; i<S.length; i++){
            if(i%size == 1) st = new StringTokenizer(br.readLine(), " ");
            S[i] = S[i-1] + Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<testcase; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int start = (Integer.parseInt(st.nextToken())-1)*size + Integer.parseInt(st.nextToken());
            int end = (Integer.parseInt(st.nextToken())-1)*size + Integer.parseInt(st.nextToken());
            System.out.println(S[end] - S[start-1]);

        }

         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine(), " ");
        int size = Integer.parseInt(st.nextToken());
        int testcase = Integer.parseInt(st.nextToken());

        int[][] A = new int[size+1][size+1];
        int[][] D = new int[size+1][size+1];
        for(int i=1; i<=size; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=1; j<=size; j++){
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=1; i<=size; i++){
            for(int j=1; j<=size; j++){
                D[i][j] = D[i][j-1] + D[i-1][j] + A[i][j] - D[i-1][j-1];
            }
        }

        for(int i=0; i<testcase; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            System.out.println(D[x2][y2] - D[x1-1][y2] - D[x2][y1-1] + D[x1-1][y1-1]);
        }





    }
}