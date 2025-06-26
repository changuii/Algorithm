import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static boolean e = false;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        
        int[] map = new int[9];
        for(int i=0; i<9; i++){
            map[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(map);
        dfs(map, new boolean[9], 0, 0, 0);
        
    }


    // 8 - now : 현재 남은 depth
    // depth + 현재 남은 depth < 7이라면, 일곱 난쟁이가 불가능
    public static void dfs(int[] map, boolean[] visit, int now, int sum, int depth){
        if(e || sum > 100 || depth + 9 - now < 7 || depth > 7){
            return;
        }
        if(sum == 100 && depth == 7){
            StringBuilder sb = new StringBuilder();

            for(int i=0; i<9; i++){
                if(visit[i]){
                    sb.append(map[i]).append("\n");
                }
            }
            
            System.out.println(sb);
            e = true;
            return;
        }

        for(int i=now; i<9 && !e; i++){
            if(!visit[i]){
                visit[i] = true;
                dfs(map, visit, i, sum + map[i], depth + 1);
                visit[i] = false;
            }
        }
        
    }
    
}