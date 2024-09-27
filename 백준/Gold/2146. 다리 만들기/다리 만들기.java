import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int N;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        int[][] map = new int[N][N];
        StringTokenizer st;
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        boolean[][] visit = new boolean[N][N];
        int answer = Integer.MAX_VALUE;
        int city = 1;
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(!visit[i][j] && map[i][j] == 1){
                    answer = Math.min(BFS(map, i, j, visit), answer);
                }
            }
        }

        System.out.println(answer);

        
    }

    public static int BFS(int[][] map, int X, int Y, boolean[][] visit){
        Queue<int[]> q = new ArrayDeque<>();

        ArrayList<int[]> list = new ArrayList<>();
        q.offer(new int[]{X, Y});
        visit[X][Y] = true;
        list.add(new int[]{X, Y});
        while (!q.isEmpty()) {
            int[] now = q.poll();

            for(int i=0; i<4; i++){
                int x = now[0] + dx[i];
                int y = now[1] + dy[i];

                if(!(x>=0 && x<N && y>=0 && y<N)) continue;

                if(!visit[x][y] && map[x][y] == 1){
                    list.add(new int[]{x, y});
                    q.offer(new int[]{x, y});
                    visit[x][y] = true;
                }
            }
        }

        boolean[][] v = new boolean[N][N];
        for(int[] x : list){
            q.offer(new int[]{x[0], x[1], 0});
            v[x[0]][x[1]] = true;
        }
        
        while (!q.isEmpty()) {
            int[] now = q.poll();

            for(int i=0; i<4; i++){
                int x = now[0] + dx[i];
                int y = now[1] + dy[i];

                if(!(x>=0 && x<N && y>=0 && y<N)) continue;

                if(!v[x][y] && map[x][y] == 0){
                    q.offer(new int[]{x, y, now[2] + 1});
                    v[x][y] = true;
                }
                else if(!v[x][y] && visit[x][y] && map[x][y] == 1){
                    // System.out.println(now[0] + " " + now[1] + " -> " + x + " " + y);
                    return now[2];
                }
            }
        }
        return 1_000_000;
        
    }
}