import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 1. 특정 간선을 지나는 노드는 간선의 아래 있는 노드들이다.

        int N = Integer.parseInt(br.readLine());


        ArrayList<ArrayList<Integer>> A = new ArrayList<>();
        for(int i=0; i<=N; i++){
            A.add(new ArrayList<>());
        }

        StringTokenizer st;
        for(int i=0; i<N-1; i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            A.get(a).add(b);
            A.get(b).add(a);
        }

        int[] leafCount = new int[N+1];
        long answer = 0;
        DFS(A, leafCount, 1, 1);

        for(int i=2; i<=N; i++){
            int X = N - leafCount[i];
            answer += (1L * N * (N-1) / 2) - (1L * X * (X-1) / 2);
        }        
        System.out.println(answer);
    }

    public static int DFS(ArrayList<ArrayList<Integer>> A, int[] leafCount, int now, int parent){
        leafCount[now] = 1;
        for(int x : A.get(now)){
            if(x != parent){
                leafCount[now] += DFS(A, leafCount, x, now);
            }
        }
        return leafCount[now];
    }
}