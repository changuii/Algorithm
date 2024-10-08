import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = 10;
        StringBuilder sb= new StringBuilder();
        StringTokenizer st;
        for(int t=1; t<=T; t++){

            int N = Integer.parseInt(br.readLine());
            
            int[][] map = new int[N][N];
            for(int i=0; i<N; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<N; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int answer = 0;
            for(int i=0; i<N; i++){
                int val = 0;
                int before = 0;
                for(int j=0; j<N; j++){
                    if(map[j][i] == 0){
                        continue;
                    }
                    
                    if(before == 1 && map[j][i] == 2){
                        val++;
                    }
                    before = map[j][i];
                }
                answer+=val;
            }
            
           
            
            sb.append("#").append(t).append(" ")
                .append(answer).append("\n");
        }
        System.out.println(sb);
        
    }
}