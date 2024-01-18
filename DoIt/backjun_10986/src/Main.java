import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
//        int size = Integer.parseInt(st.nextToken());
//        int M = Integer.parseInt(st.nextToken());
//
//        int success = 0;
//        st = new StringTokenizer(br.readLine(), " ");
//
//        long[] S = new long[size+1];
//        for(int i=1; i<=size; i++){
//            S[i] = S[i-1] + Integer.parseInt(st.nextToken());
//        }
//
//        long[] C = new long[M];
//        for(int i=1; i<=size; i++){
//            int remainder = (int) S[i] % M;
//            if(remainder == 0) success++;
//            C[remainder]++;
//        }
//
//        for(int i=0; i<M; i++){
//            if(C[i] > 1){
//                success += (C[i] * (C[i] - 1)/2 );
//            }
//        }
//        System.out.println(success);
       Scanner sc = new Scanner(System.in);
       int N = sc.nextInt();
       int M = sc.nextInt();
       long[] S = new long[N];
       long[] C = new long[M];
       long answer = 0;
       S[0] = sc.nextInt();
       for(int i=1 ; i <N; i++){
           S[i] = S[i-1] + sc.nextInt();
       }
       for(int i=0; i<N; i++){
           int r = (int) (S[i] % M);
           if(r == 0) answer++;
           C[r]++;
       }
       for(int i=0; i<M; i++){
           if(C[i] > 1){
               answer += (C[i] * (C[i]-1) / 2);
           }
       }
        System.out.println(answer);


    }
}