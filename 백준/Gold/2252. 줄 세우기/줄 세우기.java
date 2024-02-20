import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


class Main {
    public static void main(String[] args) throws IOException {
       BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
       StringTokenizer st = new StringTokenizer(br.readLine(), " ");

       int N = Integer.parseInt(st.nextToken())+1;
       int M = Integer.parseInt(st.nextToken());

       int[] A = new int[N];
       ArrayList<Integer>[] E = new ArrayList[N];
       for(int i=1; i<N; i++){
           A[i] = 0;
           E[i] = new ArrayList<>();
       }

       for(int i=0; i<M; i++){
           st = new StringTokenizer(br.readLine(), " ");
           int a = Integer.parseInt(st.nextToken());
           int b = Integer.parseInt(st.nextToken());
           E[a].add(b);
           A[b]++;
       }

       StringBuilder sb = new StringBuilder();
       for(int i=1; i<N; i++){
           int now = 1;
           for(int j=1; j<N; j++){
               if(A[j] == 0){
                   now = j;
                   A[now] = -1;
                   break;
               }
           }
           sb.append(now).append(" ");
           for(int x : E[now]){
               A[x]--;
           }
       }
        System.out.println(sb);


    }
}