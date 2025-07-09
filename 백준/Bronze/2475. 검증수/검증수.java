import java.util.*;
import java.lang.*;
import java.io.*;

// https://www.acmicpc.net/problem/2475
class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int sum = 0;
        for(int i=0; i<5; i++){
            sum += Math.pow(Integer.parseInt(st.nextToken()), 2) % 10;
        }

        System.out.println(sum % 10);
    }
}