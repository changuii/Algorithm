import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine())+1;

        int[] T = new int[N];
        int[] P = new int[N];
        int[] D = new int[N+1];

        StringTokenizer st;
        for(int i=1 ;i<N; i++){
            st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }


        for(int i=N-1; i>0;i--){
            if(T[i] + i > N){
                D[i] = D[i+1];
            }else{
                D[i] = Math.max(P[i] + D[i+T[i]], D[i+1]);
            }
        }
        System.out.println(D[1]);




    }

}