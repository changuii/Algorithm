import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());


        char[][] map = new char[N][M];
        for(int i=0; i<N; i++){
            map[i] = br.readLine().toCharArray();
        }

        int max = 1;
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                max = Math.max(max, makeQuadrangle(map, i, j));
            }
        }
        System.out.println(max);
        
        
    }

    public static int makeQuadrangle(char[][] map, int x, int y){
            
        char target = map[x][y];
        ArrayList<Integer> next = new ArrayList<>();
        for(int j=y+1; j<map[0].length; j++){
            if(target == map[x][j]){
                next.add(j - y);
            }
        }

        int max = 0;
        for(int n : next){
            if(x + n >= map.length) continue;
            
            if(map[x + n][y] == target && map[x+n][y+n] == target){
                max = (n+1) * (n+1);
                
            }
        }
        return max;
        
    }
}