import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Solution {
    static int max = 0;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int t=1; t<=T; t++){
            int N = Integer.parseInt(br.readLine());

            int[][] map = new int[N][N];
            for(int i=0; i<N; i++){
                st= new StringTokenizer(br.readLine());
                for(int j=0; j<N; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            int[][] one = rotate(map);
            int[][] two = rotate(one);
            int[][] three = rotate(two);

            sb.append(String.format("#%d\n%s", t, mapToString(one, two, three)));
        }

        System.out.println(sb);
        
    }

    public static int[][] rotate(int[][] map){
        int[][] rotatedMap = new int[map.length][map.length];

        int x=0;
        int y=0;
        for(int j=0; j<map.length; j++){
            for(int i=map.length-1; i>=0; i--){
                rotatedMap[x][y++] = map[i][j]; 
            }
            y=0;
            x++;
        }
        return rotatedMap;
    }

    public static String mapToString(int[][] one, int[][] two, int[][] three){
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<one.length; i++){
            for(int j=0; j<one.length; j++){
                sb.append(one[i][j]);
            }
            sb.append(" ");
            for(int j=0; j<one.length; j++){
                sb.append(two[i][j]);
            }
            sb.append(" ");
            for(int j=0; j<one.length; j++){
                sb.append(three[i][j]);
            }
            
            sb.append("\n");
        }
        return sb.toString();
    }
    
    
}