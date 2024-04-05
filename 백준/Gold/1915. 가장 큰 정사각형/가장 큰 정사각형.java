import java.io.*;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken())+1;
        int M = Integer.parseInt(st.nextToken())+1;

        int[][] A = new int[N][M];
        int answer = 0;

        for(int i=1; i<N; i++){
            char[] value = br.readLine().toCharArray();
            for(int j=1; j<M; j++){
                A[i][j] = Integer.parseInt(value[j-1]+"") == 0 ? 0 : Math.min(Math.min(A[i-1][j], A[i][j-1]), A[i-1][j-1]) + 1;
                answer = Math.max(answer, A[i][j]);
            }
        }
        System.out.println(answer * answer);
    }


}