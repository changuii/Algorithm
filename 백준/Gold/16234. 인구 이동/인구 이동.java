import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static int N;
    static int L;
    static int R;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int[][] map;
    static boolean[][][] isOpen;
    static boolean[][] visit;
    static boolean isProgress = true;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        visit = new boolean[N][N];
        isOpen = new boolean[N][N][4];
        
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int c = 0;
        while(isProgress){
            isProgress = false;
            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    searchLine(i, j);
                }
            }

            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    if(!visit[i][j])
                        updatePopulation(i, j);
                }
            }

            if(isProgress) c++;
            visit = new boolean[N][N];
            isOpen = new boolean[N][N][4];
        }
        System.out.println(c);
    
    }

    public static void updatePopulation(int x, int y){

        Queue<int[]> q = new LinkedList<>();
        List<int[]> list = new LinkedList<>();
        visit[x][y] = true;
        q.add(new int[]{x, y});
        int c = 1;
        int sum = 0;
        while(!q.isEmpty()){
            int[] now = q.poll();
            sum += map[now[0]][now[1]];
            for(int i=0; i<4; i++){
                if(!isOpen[now[0]][now[1]][i]) continue;
                int xValue = now[0] + dx[i];
                int yValue = now[1] + dy[i];
                if(isInsider(xValue, yValue) && !visit[xValue][yValue]){
                    c++;
                    visit[xValue][yValue] = true;
                    q.add(new int[]{xValue, yValue});
               }
            }
            list.add(now);
        }

        int population = sum / c;
        for(int[] n : list){
            map[n[0]][n[1]] = population;
        }
    }

    public static void searchLine(int x, int y){
        for(int i=0; i<4; i++){
            int xValue = x + dx[i];
            int yValue = y + dy[i];
            if(isInsider(xValue, yValue) && isRange(x, y, xValue, yValue)){
                isOpen[x][y][i] = true;
                isProgress = true;
            }
        }
    }

    public static boolean isInsider(int x, int y){
        return (x < N && x >= 0 && y < N && y >= 0);
    }

    public static boolean isRange(int x1, int y1, int x2, int y2){
        int minus = Math.abs(map[x1][y1]- map[x2][y2]);
        return (minus >= L && minus <= R);
    }


    
}