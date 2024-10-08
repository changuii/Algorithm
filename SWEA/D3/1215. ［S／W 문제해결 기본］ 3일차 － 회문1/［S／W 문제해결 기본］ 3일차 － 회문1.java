import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int T = 10;
        StringBuilder sb= new StringBuilder();
        for(int t=1; t<=T; t++){

            int N = Integer.parseInt(br.readLine())-1;
            
            
            char[][] map = new char[8][8];
            for(int i=0; i<map.length; i++){
                map[i] = br.readLine().toCharArray();
            }
            int count = 0;
            for(int i=0; i<map.length; i++){
                for(int j=0; j<map.length; j++){
                    if(i+N < map.length){
                        StringBuilder val = new StringBuilder(map[i][j] +"");
                        for(int k=1; k<=N; k++){
                            val.append(map[i+k][j]+"");
                        }
                        if(val.toString().equals(val.reverse().toString())){
                            count++;
                            // System.out.println(val);
                        }
                        
                    }
                    if(j+N <map.length){
                        StringBuilder val = new StringBuilder(map[i][j] +"");
                        for(int k=1; k<=N; k++){
                            val.append(map[i][j+k]+"");
                        }
                        if(val.toString().equals(val.reverse().toString())){
                            count++;
                            // System.out.println(val);
                        }
                    }
                    
                }
            }

            
            sb.append("#").append(t).append(" ")
                .append(count).append("\n");
        }
        System.out.println(sb);
        
    }
}