import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] money = new int[4];
        money[0] = 0;
        money[1] = Integer.parseInt(st.nextToken());
        money[2] = Integer.parseInt(st.nextToken()) * 2;
        money[3] = Integer.parseInt(st.nextToken()) * 3;


        int[][] v = new int[3][2];
        for(int i=0; i<3; i++){
            st = new StringTokenizer(br.readLine());

            v[i][0] = Integer.parseInt(st.nextToken());
            v[i][1] = Integer.parseInt(st.nextToken());
        }

        int m = 0;
        boolean[] visit = new boolean[3];
        for(int i=1; i<=100; i++){

            int c = 0;
            for(int j=0; j<3; j++){
                c += visit[j] ? 1 : 0;
                
                if(v[j][0] == i){
                    visit[j] = true;
                }

                if(v[j][1] == i){
                    visit[j] = false;
                }
            }

            m += money[c];
        }
        
        
        System.out.println(m);
        
    }
}