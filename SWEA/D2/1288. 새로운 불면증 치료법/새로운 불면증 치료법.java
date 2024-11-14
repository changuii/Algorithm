import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        
        StringBuilder sb = new StringBuilder();
        for(int t=1; t<=T; t++){
            int N = Integer.parseInt(br.readLine());

            int now = 0;
            Set<Character> set = new HashSet<>();
            while (set.size() < 10) {
                now++;
                record(set, String.valueOf(N * now));
            }
            
            sb.append(String.format("#%d %d\n", t, N*now));            
        }
        System.out.println(sb);
    }

    public static void record(Set<Character> set, String value){
        for(char x : value.toCharArray()){
            set.add(x);
        }
    }
}