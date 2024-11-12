import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];
        List<int[]> cctvs = new ArrayList<>();
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] >= 1 && map[i][j] <= 5){
                    cctvs.add(new int[]{i, j});
                }
            }
        }
        DFS(map, cctvs, 0);
        System.out.println(min);

    }

    public static void DFS(int[][] map, List<int[]> cctvs, int now){
        if(now == cctvs.size()){
            min = Math.min(min, check(map));
            return;
        }
        
        int[] cctv = cctvs.get(now);
        int type = map[cctv[0]][cctv[1]];
        if(type == 1 || type == 3 || type == 4){
            for(int i=0; i<4; i++){
                see(map, cctv, i, 1);
                DFS(map, cctvs, now + 1);
                see(map, cctv, i, -1);
            }
        } else if(type == 2){
            for(int i=0; i<2; i++){
                see(map, cctv, i, 1);
                DFS(map, cctvs, now + 1);
                see(map, cctv, i, -1);
            }
        } else if(type == 5){
            see(map, cctv, 0, 1);
            DFS(map, cctvs, now + 1);
            see(map, cctv, 0, -1);
        }

        
    }

    public static void see(int[][] map, int[] cctv, int direction, int oper){
        int type = map[cctv[0]][cctv[1]];

        if(type == 1){
            operation(map, cctv[0], cctv[1], direction, oper);
        } else if(type == 2){
            operation(map, cctv[0], cctv[1], direction, oper);
            operation(map, cctv[0], cctv[1], (direction + 2) % 4, oper);
        } else if(type == 3){
            operation(map, cctv[0], cctv[1], direction, oper);
            operation(map, cctv[0], cctv[1], (direction + 1) % 4, oper);
        } else if(type == 4){
            operation(map, cctv[0], cctv[1], direction, oper);
            operation(map, cctv[0], cctv[1], (direction + 1) % 4, oper);
            operation(map, cctv[0], cctv[1], (direction + 3) % 4, oper);
        } else if(type == 5){
            operation(map, cctv[0], cctv[1], 0, oper);
            operation(map, cctv[0], cctv[1], 1, oper);
            operation(map, cctv[0], cctv[1], 2, oper);
            operation(map, cctv[0], cctv[1], 3, oper);
        }
    }

    public static void operation(int[][] map, int x, int y, int direction, int oper){
        while (true) {
            x += dx[direction];
            y += dy[direction];
            
            if(!(x >= 0 && x < map.length && y>=0 && y<map[0].length)) break;

            if(map[x][y] == 6) break;
            if(map[x][y] == 0 || map[x][y] >= 7){
                map[x][y] += (7 * oper);
            }
        }
    }
    
    
    public static int check(int[][] map){
        int c = 0;
        for(int i=0; i<map.length; i++){
            for(int j=0; j<map[i].length; j++){
                if(map[i][j] == 0) c++;
            }
        }
        return c;
    }
}