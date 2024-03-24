import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


class Main {
    static int[][] A;
    static int count = 0;
    static int[] xValue = {-1, 0, 1, 0};
    static int[] yValue = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        A = new int[N][M];

        st = new StringTokenizer(br.readLine(), " ");
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        // 0 북쪽, 1 동쪽, 2 남쪽, 3 서쪽
        int d = Integer.parseInt(st.nextToken());

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<M; j++){
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        BFS(new Coordinate(a, b, d));
        System.out.println(count);


    }

    public static void BFS(Coordinate start){
        if(A[start.x][start.y] == 1) return;
        Queue<Coordinate> q = new LinkedList<>();

        count++;
        A[start.x][start.y] = 2;
        q.add(start);
        while (!q.isEmpty()){
            Coordinate now = q.poll();
            int c = 0;
            for(int i=0; i<4; i++){
                int a = now.x + xValue[i];
                int b = now.y + yValue[i];
                if(A[a][b] == 0){
                    c++;
                    now.rotateDirection();
                    break;
                }
            }
            if(c == 0 &&
                    (A[now.x + xValue[now.backDirection()]][now.y + yValue[now.backDirection()]] == 0 ||
                    A[now.x + xValue[now.backDirection()]][now.y + yValue[now.backDirection()]] == 2)){
                q.add(new Coordinate(now.x + xValue[now.backDirection()],now.y+ yValue[now.backDirection()], now.d));
                continue;
            }else if(c == 0 && A[now.x + xValue[now.backDirection()]][now.y + yValue[now.backDirection()]] == 1){
                return ;
            }
            if(A[now.x + xValue[now.d]][now.y + yValue[now.d]] == 0){
                A[now.x + xValue[now.d]][now.y + yValue[now.d]] = 2;
                count++;
                q.add(new Coordinate(now.x + xValue[now.d], now.y + yValue[now.d], now.d));
                continue;
            }
            q.add(now);
        }

    }

    static class Coordinate{
        int x;
        int y;
        int d;
        public Coordinate(int x, int y, int d){
            this.x = x;
            this.y = y;
            this.d = d;
        }

        public void rotateDirection(){
            if(this.d == 0) d = 3;
            else{
                this.d--;
            }
        }

        public int backDirection(){
            if(this.d == 0) return 2;
            if(this.d == 1) return 3;
            if(this.d == 2) return 0;
            return 1;
        }
    }
}