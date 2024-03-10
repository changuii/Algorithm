import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int M = Integer.parseInt(br.readLine());
        int[] N = new int[M];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int T = 0;
        for(int i=0; i<M; i++){
           N[i] = Integer.parseInt(st.nextToken());
           T += N[i];
        }
        int K = Integer.parseInt(br.readLine());

        double answer = 0;
        for(int i=0; i<N.length; i++){
            double value = 1.0;
            for(int j=0; j<K; j++){
                value *= (double) (N[i]-j)/(T-j);
            }
            answer += value;
        }

        System.out.println(answer);

    }

}