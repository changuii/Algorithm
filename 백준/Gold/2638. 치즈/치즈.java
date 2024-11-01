import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());


        int[][] map = new int[N][M];
        List<int[]> cheese = new ArrayList<>();
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 1){
                    cheese.add(new int[]{i, j});
                }
            }
        }
        
        System.out.println(BFS(map, cheese));
    }

    public static int BFS(int[][] map, List<int[]> cheese){
        Queue<int[]> q = new ArrayDeque<>();

        for(int[] c : cheese){
            q.offer(new int[]{c[0], c[1], 1});
        }
        
        Queue<int[]> q2 = init(map);
        boolean[][] visit = new boolean[map.length][map[0].length];
        
        int t = 0;
        int index = 1;
        List<int[]> delete = new ArrayList<>();
        while (!q.isEmpty()) {
            int[] now = q.poll();

            if(index == now[2]){
                index++;
                for(int[] n : delete){
                    map[n[0]][n[1]] = 0;
                    for(int i=0; i<4; i++){
                        int x = dx[i] + n[0];
                        int y = dy[i] + n[1];
        
                        if(!(x >=0 && x<map.length && y>= 0 && y<map[0].length)) continue;
        
                        if(visit[x][y]){
                            q2.offer(new int[]{n[0], n[1]});
                            break;
                        }
                    }
                }

                // for(int i=0; i<map.length; i++){
                //     System.out.println(Arrays.toString(map[i]));
                // }
                // for(int i=0; i<map.length; i++){
                //     System.out.println(Arrays.toString(visit[i]));
                // }
            }

            getInner(map, visit, q2);
            
            t = now[2];

            int c = 0;
            for(int i=0; i<4; i++){
                int x = dx[i] + now[0];
                int y = dy[i] + now[1];

                if(!(x >=0 && x<map.length && y>= 0 && y<map[0].length)) continue;

                if(map[x][y] == 1 || (map[x][y] == 0 && !visit[x][y])){
                    c++;
                }
            }
            
            if(c > 2){
                q.offer(new int[]{now[0], now[1], now[2] + 1});
            }
            else{
                delete.add(new int[]{now[0], now[1]});
            }
        }

        return t;
    }

    public static void getInner(int[][] map, boolean[][] visit, Queue<int[]> q){
        while (!q.isEmpty()) {
            int[] now = q.poll();

            if(visit[now[0]][now[1]]) continue;
            visit[now[0]][now[1]] = true;

            for(int i=0; i<4; i++){
                int x = dx[i] + now[0];
                int y = dy[i] + now[1];

                if(!(x >=0 && x<map.length && y>= 0 && y<map[0].length)) continue;

                if(map[x][y] == 0){
                    q.offer(new int[]{x, y});
                }
            }
        }
    }

    public static Queue<int[]> init(int[][] map){
        Queue<int[]> q = new ArrayDeque<>();
        for(int i=0; i<map[0].length; i++){
            if(map[0][i] == 0){
                q.offer(new int[]{0, i});    
            }
            if(map[map.length-1][i] == 0 ){
                q.offer(new int[]{map.length-1, i});
            }
        }
        for(int i=0; i<map.length; i++){
            if(map[i][0] == 0){
                q.offer(new int[]{i, 0});
            }
            if(map[i][map[0].length-1] == 0){
                q.offer(new int[]{i, map[0].length-1});
            }
        }
        return q;
    }
}