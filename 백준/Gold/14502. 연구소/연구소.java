import java.util.*;
import java.util.stream.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int max = 0;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];
        List<int[]> virus = new ArrayList<>();
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 2){
                    virus.add(new int[]{i, j});
                }
            }
        }

        DFS(map, new boolean[N][M], 0, 0, 0, virus);

        System.out.println(max);

        
        
    }

    public static void DFS(int[][] map, boolean[][] visit, int x, int y, int depth, List<int[]> virus){
        if(depth == 3){
            int safe = BFS(map, virus);
            max = Math.max(safe, max);
            return;
        }
        
        for(int i=x; i<map.length; i++){
            for(int j=(i == x ? y : 0); j<map[0].length; j++){
                if(!visit[i][j] && map[i][j] == 0){
                    visit[i][j] = true;
                    map[i][j] = 1;
                    int nextX = i + (j + 1) / map[0].length;
                    int nextY = (j + 1) % map[0].length;
                    DFS(map, visit, nextX, nextY, depth + 1, virus);
                    map[i][j] = 0;
                    visit[i][j] = false;
                }
            }
        }
        
    }

    public static int BFS(int[][] map, List<int[]> virus){
        Queue<int[]> q = new ArrayDeque<>();

        boolean[][] visit = new boolean[map.length][map[0].length];
        for(int[] v : virus){
            visit[v[0]][v[1]] = true;
            q.offer(new int[]{v[0], v[1]});
        }
        
        while (!q.isEmpty()) {
            int[] now = q.poll();

            for(int i=0; i<4; i++){
                int x = dx[i] + now[0];
                int y = dy[i] + now[1];

                if(!(x >=0 && x<map.length && y>= 0 && y<map[0].length)) continue;

                if(!visit[x][y] && map[x][y] == 0){
                    q.offer(new int[]{x, y});
                    visit[x][y] = true;
                }
            }
        }

        int c = 0;
        for(int i=0; i<map.length; i++){
            for(int j=0; j<map[0].length; j++){
                if(map[i][j] == 0 && !visit[i][j]){
                    c++;
                }
            }
        }

        return c;
    }
}