import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for(int t=1; t<=T; t++){
            int N = Integer.parseInt(br.readLine());
            
            int[] data = Arrays.stream(br.readLine().split(" "))
                .mapToInt(val -> Integer.parseInt(val))
                .toArray();

            int max = 0;
            long result = 0;
            for(int i=N-1; i>=0; i--){
                if(max < data[i]){
                    max = data[i];
                }
                else{
                    result += max-data[i];
                }
            }

            sb.append(String.format("#%d %d\n", t, result));
        }
        System.out.println(sb);
    }
}