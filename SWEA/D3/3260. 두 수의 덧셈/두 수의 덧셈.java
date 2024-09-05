import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*;

// The main method must be in a class named "Main".
class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        for(int test=1; test<=T; test++){
            st = new StringTokenizer(br.readLine());
            BigInteger num1 = new BigInteger(st.nextToken());
            BigInteger num2 = new BigInteger(st.nextToken());

            sb.append("#").append(test).append(" ")
                .append(num1.add(num2)).append("\n");    
        }
        System.out.println(sb);
    }
}