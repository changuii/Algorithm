import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = 10;

        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        for(int t=1; t<=T; t++){
            int v = Integer.parseInt(br.readLine());
            int N = 100;
            int max = 1;

            char[][] map = new char[N][N];
            for(int i=0; i<N; i++){
                map[i] = br.readLine().toCharArray();
            }

            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    StringBuilder s = new StringBuilder(map[i][j]+"");
                    for(int k=i+1; k<N; k++){
                        s.append(map[k][j]+"");
                        if(isPalindrome(s)){
                            max = Math.max(s.length(), max);
                        }
                    }
                    s = new StringBuilder(map[i][j]+"");
                    for(int k=j+1; k<N; k++){
                        s.append(map[i][k]+"");
                        if(isPalindrome(s)){
                            max = Math.max(s.length(), max);
                        }
                    }                    
                }
            }
        
            sb.append(String.format("#%d %d\n", v, max));
            
        }
        System.out.println(sb);
    }

    public static boolean isPalindrome(StringBuilder sb){
        boolean temp = sb.toString().equals(sb.reverse().toString());
        sb.reverse();
        return temp;
    }
}