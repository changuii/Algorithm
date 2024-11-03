import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        char[][] map = new char[N][M];
        int x = 0;
        int y = 0;

        List<int[]> fire = new ArrayList<>();
        for(int i=0; i<N; i++){
            char[] val = br.readLine().toCharArray();
            for(int j=0; j<M; j++){
                map[i][j] = val[j];
                if(map[i][j] == 'J'){
                    x = i;
                    y = j;
                }
                else if(map[i][j] == 'F'){
                    fire.add(new int[]{i, j});
                }
            }
        }

        int result = BFS(map, x, y, fire);
        System.out.println(result < 0 ? "IMPOSSIBLE" : result);
    }

    public static int BFS(char[][] map, int X, int Y, List<int[]> fire){
        Queue<int[]> q = new ArrayDeque<>();

        boolean[][] visit = new boolean[map.length][map[0].length];
        q.offer(new int[]{X, Y, 0, 0});
        for(int[] f : fire){
            q.offer(new int[]{f[0], f[1], 1});
        }

        while (!q.isEmpty()) {
            int[] now = q.poll();

            if(now[2] == 0 && map[now[0]][now[1]] == 'F') continue;

            if(now[2] == 0 && (now[0] == 0 || now[0] == map.length-1 || now[1] == 0 || now[1] == map[0].length-1))
                return now[3] + 1;


            for(int i=0; i<4; i++){
                int x = now[0] + dx[i];
                int y = now[1] + dy[i];

                if(now[2] == 0){
                    operationJihun(map, q, x, y, now[3]);
                }
                else{
                    operationFire(map, q, x, y);
                }
            }
            
        }
        return -1;
    }

    public static void operationJihun(char[][] map, Queue<int[]>  q, int x, int y, int dis){
        if(map[x][y] == '.'){
            map[x][y] = 'J';
            q.offer(new int[]{x, y, 0, dis + 1});
        }
    }

    public static void operationFire(char[][] map, Queue<int[]> q, int x, int y){
        if((x >=0 && x < map.length && y >= 0 && y<map[0].length) && map[x][y] != '#' && map[x][y] != 'F'){
            map[x][y] = 'F';
            q.offer(new int[]{x, y, 1});
        }
    }
}