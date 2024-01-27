import java.util.*;
import java.lang.*;
import java.io.*;


class Main {
    public static LinkedList<Integer>[] A;
    public static boolean[] VD;
    public static boolean[] VB;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken())+1;
        int E = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());

        VD = new boolean[N];
        VB = new boolean[N];
        A = new LinkedList[N];
        for(int i=1; i<N; i++){
            A[i] = new LinkedList<>();
        }

        for(int i=0; i<E; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            A[x].add(y);
            A[y].add(x);
        }
        for(int i=1; i<N; i++){
            Collections.sort(A[i]);
        }

        DFS(s);
        sb.append("\n");
        BFS(s);
        System.out.println(sb);
        }

    private static void DFS(int num){
        if(VD[num]) return;
        VD[num] = true;
        sb.append(num).append(" ");

        for(int x : A[num]){
            if(!VD[x]) DFS(x);
        }
    }
    private static void BFS(int num){
        Queue<Integer> q = new LinkedList<>();
        q.add(num);
        VB[num] = true;
        while (!q.isEmpty()){
            int current = q.poll();
            sb.append(current).append(" ");
            for(int x : A[current]){
                if(!VB[x]){
                    q.add(x);
                    VB[x] = true;
                }
            }

        }


    }


}