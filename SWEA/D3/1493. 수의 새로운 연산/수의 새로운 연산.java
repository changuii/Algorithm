import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Solution {

    static int min;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        int N = 10_001;
        int[] range = new int[N];
        int val = 1;
        range[1] = 1;
        for(int i=2; i<N; i++){
            range[i] = range[i-1] + val++;
        }
        
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        for(int t=1; t<=T; t++){

            st = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            int[] coordinateA = findXY(range, A);
            int[] coordinateB = findXY(range, B);

            int result = findValue(range, coordinateA[0] + coordinateB[0], coordinateA[1] + coordinateB[1]);
            
            sb.append(String.format("#%d %d\n", t, result));
        }
        System.out.println(sb);
    }
    
    public static int[] findXY(int[] range, int value){
        int y = 0;
        for(int i=1; i<range.length; i++){
            if(range[i] > value){
                y = i-1;
                break;
            }
        }
        int x = value - range[y] + 1;
        y -= value - range[y];
        return new int[]{x, y}; 
    }

    public static int findValue(int[] range, int x, int y){
        int depth = x - 1;
        y += depth;
        return range[y] + depth;
    }
}