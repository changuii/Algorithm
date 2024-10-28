import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Solution {
    static boolean flag;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = 10;

        StringBuilder sb = new StringBuilder();
        for(int t=1; t<=T; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int test = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());

            flag = false;
            int[][] map = new int[100][2];
            for(int i=0; i<100; i++){
                map[i][0] = -1;
                map[i][1] = -1;
            }
            st = new StringTokenizer(br.readLine());
            while(st.hasMoreTokens()){
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                if(map[x][0] == -1){
                    map[x][0] = y;
                }else{
                    map[x][1] = y;
                }
            }
            DFS(map, new boolean[100], 0);
            
            
            sb.append(String.format("#%d %d\n", test, flag ? 1 : 0));
        }
        System.out.println(sb);
    }

    public static void DFS(int[][] map, boolean[] visit, int now){
        // System.out.println(now + " : " + Arrays.toString(map[now]));
        if(now == 99){
            flag = true;
            return;
        }

        if(flag) return;
        if(map[now][0] != -1 && !visit[map[now][0]]){
            visit[map[now][0]] = true;
            DFS(map, visit, map[now][0]);
            visit[map[now][0]] = false;
        }
        if(map[now][1] != -1 && !visit[map[now][1]]){
            visit[map[now][1]] = true;
            DFS(map, visit, map[now][1]);
            visit[map[now][1]] = false;
        }
        
        
        
    }
}