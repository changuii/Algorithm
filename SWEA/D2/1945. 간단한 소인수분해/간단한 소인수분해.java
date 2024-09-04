import java.util.*;
import java.io.*;

class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        int[] value = new int[]{2, 3, 5, 7, 11};
        for(int i=1; i<=N; i++){
            int num = Integer.parseInt(br.readLine());

            int[] x = new int[12];
            int val = 0;
            while(num > 1){
                if(num % value[val] == 0){
                    x[value[val]]++;
                    num /= value[val];
                }else{
                    val++;
                }
            }
            
            
            sb.append("#" + i + " ")
                .append(x[value[0]] + " " + x[value[1]] + " " + x[value[2]] + " " + x[value[3]] + " " + x[value[4]])
                .append("\n");
        }
        System.out.println(sb);
    }
}