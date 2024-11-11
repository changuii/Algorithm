import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++){
            int test = Integer.parseInt(br.readLine());

            int[] count = new int[101];

            st = new StringTokenizer(br.readLine());
            for(int i=0; i<1000; i++){
                count[Integer.parseInt(st.nextToken())]++;
            }

            int max = 0;
            for(int i=0; i<count.length; i++){
                if(count[i] >= count[max]){
                    max = i;
                }
            }
            
            sb.append(String.format("#%d %d\n", test, max));
        }
        System.out.println(sb);
    }
}