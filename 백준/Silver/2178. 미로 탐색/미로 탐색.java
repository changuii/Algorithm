import java.util.*;
import java.lang.*;
import java.io.*;


class Main {
    public static int[][] A;
    public static boolean[][] V;
    public static int[] dx = {0, 1, 0, -1};
    public static int[] dy = {1, 0, -1, 0};
    public static int N;
    public static int M;

    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       StringTokenizer st = new StringTokenizer(br.readLine(), " ");

       N = Integer.parseInt(st.nextToken());
       M = Integer.parseInt(st.nextToken());

       V = new boolean[N][M];
       A = new int[N][M];

       for(int i=0; i<N; i++){
           char[] X = br.readLine().toCharArray();
           for(int j=0; j<M; j++){
               A[i][j] = Integer.parseInt(X[j]+"");
           }
       }
       BFS(0, 0);
        System.out.println(A[N-1][M-1]);
    }
    private static void BFS(int i, int j){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{i, j});
        V[i][j] = true;

        while (!q.isEmpty()){
            int now[] = q.poll();
            for(int k =0; k<4; k++){
                int x = now[0] + dx[k];
                int y = now[1] + dy[k];
                if(x >= 0 && y >= 0 && x < N && y < M){
                    if(A[x][y] != 0 && !V[x][y]){
                        V[x][y] = true;
                        A[x][y] = A[now[0]][now[1]] + 1;
                        q.add(new int[] {x, y});
                    }
                }
            }
        }

    }


}