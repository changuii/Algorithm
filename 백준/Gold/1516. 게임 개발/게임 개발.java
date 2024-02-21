import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


class Main {
    public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      int N = Integer.parseInt(br.readLine())+1;

      ArrayList<Integer>[] A = new ArrayList[N];
      int[] D = new int[N];
      int[] time = new int[N];
        int[] answer = new int[N];

      for(int i=1; i<N; i++){
          A[i] = new ArrayList<>();
          D[i] = 0;
          time[i] = 0;
          answer[i] = 0;
      }

      for(int i=1; i<N; i++){
          StringTokenizer st = new StringTokenizer(br.readLine(), " ");
          time[i] = Integer.parseInt(st.nextToken());

          while (true){
              int pre = Integer.parseInt(st.nextToken());
              if(pre == -1) break;
              A[pre].add(i);
              D[i]++;
          }
      }


      for(int i=1; i<N; i++){
          int now = 0;
          for(int j=1; j<N; j++){
              if(D[j] == 0){
                  now = j;
                  D[j] = -1;
                  break;
              }
          }
          for (int x : A[now]){
              D[x]--;
              answer[x] = Math.max(answer[x], time[now] + answer[now]);
          }
      }

      StringBuilder sb = new StringBuilder();
      for(int i=1; i<N; i++){
          sb.append(answer[i] + time[i]).append("\n");
      }
        System.out.println(sb);


    }
}