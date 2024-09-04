import java.util.*;
import java.io.*;

class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=N; i++){
            int num = Integer.parseInt(br.readLine());

            int a = 0;
            int b = 0;
            int c = 0;
            int d = 0;
            int e = 0;
            while(num > 1){
                if(num % 2 == 0){
                    num /= 2;
                    a++;
                }
                if(num % 3 == 0){
                    num /= 3;
                    b++;
                }
                if(num % 5 == 0){
                    num /= 5;
                    c++;
                }
                if(num % 7 == 0){
                    num /= 7;
                    d++;
                }
                if(num % 11 == 0){
                    num /= 11;
                    e++;
                }
            }
            
            
            sb.append("#" + i + " ")
                .append(a + " " + b + " " + c+ " " + d + " " + e)
                .append("\n");
        }
        System.out.println(sb);
    }
}