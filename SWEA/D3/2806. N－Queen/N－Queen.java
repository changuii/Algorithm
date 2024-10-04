import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Solution {
    static int c = 0;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        for(int t =1; t<=T; t++){

            int N = Integer.parseInt(br.readLine());

            DFS(new boolean[N][N], 0);
            
            sb.append("#").append(t).append(" ")
                .append(c).append("\n");
            c = 0;
        }
        System.out.println(sb);
    }

    public static void DFS(boolean[][] map, int depth){
        // System.out.println(Arrays.deepToString(map));
        if(depth == map.length) c++;
        else{
            for(int i=0; i<map[0].length; i++){
                if(!map[depth][i]){
                    boolean[][] visit = new boolean[map.length][map[0].length];
                    for(int j=0; j<map.length; j++){
                        visit[j] = map[j].clone();
                    }
                    // System.out.println(depth + " " + i);
                    for(int j=depth; j<map.length; j++){
                        visit[j][i] = true;
                    }

                    for(int j=1; j< map[0].length; j++){
                        int x = depth + j;
                        int y = i + j;

                        if(!(x >=0 && x<map.length && y>=0 && y<map[0].length)) break;

                        visit[x][y] = true;
                    }

                    for(int j=1; j< map[0].length; j++){
                        int x = depth + j;
                        int y = i - j;

                        if(!(x >=0 && x<map.length && y>=0 && y<map[0].length)) break;

                        visit[x][y] = true;
                    }

                    
                    DFS(visit, depth+ 1);
                }
            }
        }
    }

    
}