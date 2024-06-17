import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        
        int[][] map = new int[H][W];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<W; i++){
            int now = Integer.parseInt(st.nextToken());
            for(int j=H-1; now > 0; j--){
                map[j][i] = 1;
                now--;
            }
        }

        int answer = 0;
        for(int i=H-1; i>=0; i--){
            int count = 0;
            int wall = 0;
            boolean flag = false;
            for(int j=0; j<W; j++){
                if(map[i][j] == 1){
                    if(wall > 0){
                        answer += count;
                        count = 0;
                        flag = true;
                    }else{
                        wall++;
                    }
                }else if(wall > 0){
                    count++;
                }
            }
            if(!flag) break;
        }

        System.out.println(answer);
        
    }
}