import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int t=0; t<T; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            char[][] map = new char[N][M];
            List<int[]> start = new ArrayList<>();
            for(int i=0; i<N; i++){
                char[] val = br.readLine().toCharArray();
                for(int j=0; j<M; j++){
                    map[i][j] = val[j];
                }
            }
            char[] val = br.readLine().toCharArray();
            Set<Character> key = new HashSet();
            for(char k : val){
                key.add(Character.toUpperCase(k));
            }
            for(int i=0; i<N; i++){
                for(int j=0; j<M; j++){
                     if((i == 0 || i == N-1) && 
                        (map[i][j] == '.' || map[i][j] == '$'|| (map[i][j] >= 'A' && map[i][j] <= 'Z'))){
                        start.add(new int[]{i, j});
                    }
                    else if((i == 0 || i == N-1) && map[i][j] >= 'a' && map[i][j] <= 'z'){
                        start.add(new int[]{i, j});
                        key.add(Character.toUpperCase(map[i][j]));
                    }
                    else if((j == 0 || j == M-1) && (map[i][j] == '.' || map[i][j] == '$' || (map[i][j] >= 'A' && map[i][j] <= 'Z'))){
                        start.add(new int[]{i, j});
                    }
                    else if((j == 0 || j == M-1) && map[i][j] >= 'a' && map[i][j] <= 'z'){
                        start.add(new int[]{i, j});
                        key.add(Character.toUpperCase(map[i][j]));
                    }
                }
            }
            
            sb.append(BFS(map,start,key)).append("\n");
        }
        System.out.println(sb);
    }

    public static int BFS(char[][] map, List<int[]> start, Set<Character> key){
        Queue<int[]> q = new PriorityQueue<>((o1, o2) -> {
            if(o1[3] == 1 && o2[3] == 1){
                return key.contains(map[o1[0]][o1[1]]) ? -1 : 1;
            }
            return o1[3] - o2[3];
        });


        boolean[][] visit = new boolean[map.length][map[0].length];
        for(int[] s : start){
            if(map[s[0]][s[1]] >= 'A' && map[s[0]][s[1]] <= 'Z'){
                q.offer(new int[]{s[0], s[1], 0,  key.contains(map[s[0]][s[1]]) ? 0 : 1});
            }
            else{ 
                q.offer(new int[]{s[0], s[1], 0, 0});
            }
            visit[s[0]][s[1]] = true;
        }

        int document = 0;
        while (!q.isEmpty()) {
            int[] now = q.poll();

            if(map[now[0]][now[1]] >= 'A' && map[now[0]][now[1]] <= 'Z' && !key.contains(map[now[0]][now[1]])){
                if(now[3] == 100) continue;
                q.offer(new int[]{now[0], now[1], 0, now[3] + 1});
                continue;
            }
            if(map[now[0]][now[1]] == '$') document++; 

            for(int i=0; i<4; i++){
                int x = now[0] + dx[i];
                int y = now[1] + dy[i];

                if(!(x>=0 && x<map.length && y>=0 && y<map[0].length) || map[x][y] == '*') continue;

                if(visit[x][y]) continue;
                
                if(map[x][y] == '.'){
                    visit[x][y] = true;
                    q.offer(new int[]{x, y, now[2] + 1, 0});
                }
                else if(map[x][y] >= 'A' && map[x][y] <= 'Z'){
                    visit[x][y] = true;
                    q.offer(new int[]{x, y, now[2] + 1 , key.contains(map[x][y]) ? 0 : 1});
                }
                else if(map[x][y] >= 'a' && map[x][y] <= 'z'){
                    visit[x][y] = true;
                    q.offer(new int[]{x, y, now[2] + 1, 0});
                    key.add(Character.toUpperCase(map[x][y]));
                }
                else if(map[x][y] == '$'){
                    visit[x][y] = true;
                    q.offer(new int[]{x, y, now[2] + 1, 0});
                }
            }   
        }
        return document;
    }
}