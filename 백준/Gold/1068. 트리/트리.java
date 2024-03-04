import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


class Main {
    static ArrayList<Integer>[] A;
    static boolean[] V;
    static int answer =0;
    static int D = 0;
    public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      int N = Integer.parseInt(br.readLine());

      A = new ArrayList[N];
      V = new boolean[N];
      for(int i=0; i<N; i++){
          A[i] = new ArrayList<>();
      }

      int root = 0;
      StringTokenizer st = new StringTokenizer(br.readLine(), " ");
      for(int i=0; i<N; i++){
          int a = Integer.parseInt(st.nextToken());
          if(a != -1) {
              A[a].add(i);
              A[i].add(a);
          }else{
              root = i;
          }
      }

      D = Integer.parseInt(br.readLine());
      if(root == D){
          System.out.println(0);
      }else {
          DFS(root);
          System.out.println(answer);
      }
    }
    static void BFS(int num){
        if(D == 0) return;
        Queue<Integer> q = new LinkedList<>();

        q.add(num);
        V[num] = true;
        while (!q.isEmpty()){
            int now = q.poll();
            int count = 0;
            for(int x : A[now]){
                if(!V[x] && x != D){
                    V[x] = true;
                    q.add(x);
                    count++;
                }
            }
            if(count == 0) answer++;
        }
    }

    static void DFS(int num){
        V[num] = true;
        int count = 0;
        for(int x : A[num]){
            if(!V[x] && x != D){
                count++;
                DFS(x);
            }
        }
        if(count == 0) {
            answer++;
        }


    }
}