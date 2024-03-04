import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


class Main {
    static ArrayList<Integer>[] A;
    static int[] M;
    static boolean[] V;
    static int[] count;
    public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      int N = Integer.parseInt(br.readLine());

      A = new ArrayList[N];
      V = new boolean[N];
      M = new int[N];
      for(int i=0; i<N; i++){
          A[i] = new ArrayList<>();
      }

      int root = 0;
      StringTokenizer st = new StringTokenizer(br.readLine(), " ");
      for(int i=0; i<N; i++){
          int a = Integer.parseInt(st.nextToken());

          if(a == -1) {
              root = i;
          }else{
              A[a].add(i);
              A[i].add(a);
          }
      }
      count = new int[N];
      int D = Integer.parseInt(br.readLine());
      M[root] = -1;
      mBFS(root);

      M[D] = -2;
      V = new boolean[N];
      dBFS(root);

      int answer = 0;
      for(int i=0; i<N; i++){
          if(M[i] >= -1 && count[i] == 0)
              answer++;
      }
      System.out.println(answer);







    }
    static void mBFS(int num){
        Queue<Integer> q = new LinkedList<>();

        q.add(num);
        V[num] = true;
        while (!q.isEmpty()){
            int now = q.poll();
            for(int x : A[now]){
                if(!V[x]){
                    V[x] = true;
                    M[x] = now;
                    q.add(x);
                }
            }
        }
    }

    static void dBFS(int num){
        Queue<Integer> q = new LinkedList<>();

        q.add(num);
        V[num] = true;
        while (!q.isEmpty()){
            int now = q.poll();
            for(int x : A[now]){
                if(!V[x]) {
                    if(M[x] == -2){
                        V[x] = true;
                        q.add(x);
                    }
                    else if (M[now] != -2) {
                        V[x] = true;
                        count[M[x]]++;
                        q.add(x);
                    } else if (M[now] == -2) {
                        V[x] = true;
                        q.add(x);
                        M[x] = -2;
                    }
                }
            }
        }
    }


}