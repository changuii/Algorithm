import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());
        int answer = 0;

        int[] A = new int[N];

        for(int i=0; i<N; i++){
            A[i] = Integer.parseInt(br.readLine());
        }

        while (T != 0){
            for(int i=N-1; i >=0 ; i--){
                if(A[i] <= T){
                    answer += T/A[i];
                    T = T%A[i];
                    break;
                }
            }
        }
        System.out.println(answer);

    }
}