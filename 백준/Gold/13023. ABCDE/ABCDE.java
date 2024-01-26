import java.util.*;
import java.lang.*;
import java.io.*;


class Main {

    public static ArrayList<Integer>[] A;
    public static boolean V[];
    public static boolean flag = false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        A = new ArrayList[N];
        V = new boolean[N];
        for(int i=0; i<N; i++){
            A[i] = new ArrayList<>();
        }

        for(int i = 0; i<e; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            A[x].add(y);
            A[y].add(x);
        }

        for(int i=0; i<N; i++){
            DFS(i, 1);
            if(flag) break;
        }
        if(flag) System.out.println("1");
        else System.out.println("0");
    }

    private static void DFS(int num, int depth){
        if(flag || depth == 5) {
            flag = true;
            return;
        }

        V[num] = true;
        for (int x : A[num]){
          if(!V[x]){
              DFS(x, depth+1);
          }
        }
        V[num] = false;
    }
}