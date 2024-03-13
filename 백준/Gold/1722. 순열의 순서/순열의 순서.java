import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


class Main {
    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

       int N = Integer.parseInt(br.readLine());

       long[] F = new long[21];
       int[] S = new int[21];
       boolean[] V = new boolean[21];



       StringTokenizer st = new StringTokenizer(br.readLine() , " ");
       int Q = Integer.parseInt(st.nextToken());
       F[0] = 1;
       for(int i=1; i<= N; i++){
           F[i] = F[i-1] * i;
       }

       StringBuilder sb = new StringBuilder();
       // 순서 -> 값
       if(Q == 1){
           long K = Long.parseLong(st.nextToken());
           // 1의 자리수부터 N자리 까지 
           for(int i=1; i<=N; i++){
               int cnt = 1;
               // K가 현재 자리수에서 몇 번째인지 찾는다. ()
               for(int j=1; j<=N; j++){
                   if(V[j]) continue;
                   // N = 4이고, 
                   if(K <= cnt * F[N-i]){
                       K -= ((cnt - 1) * F[N-i]);
                       S[i] = j;
                       V[j] = true;
                       break;
                   }
                   cnt++;
               }
           }
           for(int i=1; i<=N; i++){
               sb.append(S[i]).append(" ");
           }
       // 값 -> 순서
       }else{
           long K = 1;
           for(int i=1; i<= N; i++){
               S[i] = Integer.parseInt(st.nextToken());
               long cnt = 0;
               for(int j=1; j<S[i]; j++){
                   if(!V[j]) cnt++;
               }
               K += cnt * F[N - i];
               V[S[i]] = true;
           }
           sb.append(K);
       }
        System.out.println(sb);
    }

}