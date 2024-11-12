import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++){
            String now = br.readLine();

            int answer = 0;
            int temp = now.length() % 2;
            if(isReverseEquals(now.substring(0, now.length() / 2), now.substring(now.length()/2+temp, now.length()))){
                    answer = 1;
            }
            
            sb.append(String.format("#%d %d\n", t,answer));
        }
        System.out.println(sb);
    }

    public static boolean isReverseEquals(String a, String b){
        String reverse = new StringBuilder(a).reverse().toString();
        return reverse.equals(b);
    }
}