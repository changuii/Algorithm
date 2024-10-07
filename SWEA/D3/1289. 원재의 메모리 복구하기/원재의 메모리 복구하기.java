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

            char[] val = br.readLine().toCharArray();
            long mem = 0;

            int N = val.length;
            int answer = val[0] == '0' ? 0 : 1;
            int idx = 1;
            int before = val[0]-'0';

            while (idx < val.length) {
                if(before != val[idx] -'0'){
                    before = val[idx] -'0';
                    answer++;
                }
                
                idx++;
            }

            sb.append("#").append(t).append(" ")
                .append(answer).append("\n");
        }
        System.out.println(sb);
    }
}